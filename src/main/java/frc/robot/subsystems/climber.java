/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class climber extends SubsystemBase {
  public static VictorSPX climberMotor;

  public climber() {
    climberMotor = new VictorSPX(RobotMap.CAN_CLIMBER_MOTOR);
  }

  public void setSpeed(double speed) {
    climberMotor.set(ControlMode.PercentOutput, 100);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
