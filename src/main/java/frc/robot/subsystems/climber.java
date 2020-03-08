/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class climber extends SubsystemBase {
  public PWMVictorSPX climberMotor;

  public climber() {
    climberMotor = new PWMVictorSPX(RobotMap.CLIMBER_MOTOR);
  }

  public void setSpeed(double speed) {
    climberMotor.set(0.75);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
