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
public class intake extends SubsystemBase {
  /**
   * Creates a new intake.
   */

   public VictorSPX intakeMotor = new VictorSPX(RobotMap.CAN_INTAKE_MOTOR);
  public intake() {
  }

  @Override
  public void periodic() {
  }

  public void setSpeed(double speed){
    intakeMotor.set(ControlMode.PercentOutput, speed*-100);
  }
}
