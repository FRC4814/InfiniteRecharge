package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.utils.CustomXboxController;
import frc.robot.utils.XboxButton;
import frc.robot.utils.XboxControllerButton;

public class OI{

    public static CustomXboxController myController = new CustomXboxController(RobotMap.controllerPort);
    public static XboxControllerButton slowButton = new XboxControllerButton(myController, XboxButton.kBumperLeft);


    public OI(){
        myController.setDeadzone(0.15);

        if(myController.getTriggerAxis(Hand.kRight) > 0.5){
            
        }
    }
}