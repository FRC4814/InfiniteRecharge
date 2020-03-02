package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.intakeCommand;
import frc.robot.commands.shooterCommand;
import frc.robot.subsystems.shooter;
import frc.robot.utils.CustomXboxController;
import frc.robot.utils.XboxButton;
import frc.robot.utils.XboxControllerButton;

public class OI{

    public static CustomXboxController myController = new CustomXboxController(RobotMap.controllerPort);
    public static XboxControllerButton slowButton = new XboxControllerButton(myController, XboxButton.kBumperLeft);

    public static boolean isShoot = false, isIntake = false;

    public OI(){
        myController.setDeadzone(0.15);

        if(myController.getTriggerAxis(Hand.kLeft) > 0.5){
            isIntake = true;
            new intakeCommand();
        }
        if(myController.getTriggerAxis(Hand.kRight) > 0.5){
            isShoot = true;
            new shooterCommand();
        }
    }
}