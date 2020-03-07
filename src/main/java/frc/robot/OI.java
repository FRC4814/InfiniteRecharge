package frc.robot;

import frc.robot.commands.climberCommand;
import frc.robot.commands.intakeCommand;
import frc.robot.commands.shooterCommand;
import frc.robot.utils.CustomXboxController;
import frc.robot.utils.XboxButton;
import frc.robot.utils.XboxControllerButton;

public class OI{

    public static CustomXboxController myController = new CustomXboxController(RobotMap.controllerPort);
    public static XboxControllerButton slowButton = new XboxControllerButton(myController, XboxButton.kBumperLeft);
    public static XboxControllerButton shootButton = new XboxControllerButton(myController, XboxButton.kButtonB);
    public static XboxControllerButton intakeButton = new XboxControllerButton(myController, XboxButton.kButtonA);
    public static XboxControllerButton climbButton = new XboxControllerButton(myController, XboxButton.kButtonY);

    public static boolean isShoot = false, isIntake = false;

    public OI(){
        myController.setDeadzone(0.15);

        shootButton.whileHeld(new shooterCommand());

        intakeButton.whileHeld(new intakeCommand());

        climbButton.whileHeld(new climberCommand());
    }
}