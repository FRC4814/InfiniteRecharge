/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.RobotMap;

public class climber extends SubsystemBase {
  public SpeedControllerGroup climberMotors;

  public climber() {
    climberMotors = new SpeedControllerGroup(new VictorSP(RobotMap.CAN_SHOOTER_MOTOR));
  }

  public void setSpeed(double speed) {
    climberMotors.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
