/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class intake extends SubsystemBase {
  
public SpeedControllerGroup intakeMotors;


  public intake() {

    intakeMotors = new SpeedControllerGroup(new PWMVictorSPX(RobotMap.PWM_SHOOTER_MOTOR), new VictorSP(RobotMap.CAN_SHOOTER_MOTOR));

  }

  @Override
  public void periodic() {
    intakeMotors.set(1);
  }
}
