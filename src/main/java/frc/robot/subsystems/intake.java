/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class intake extends SubsystemBase {
  
  public SpeedControllerGroup intakeMotors;

  public intake() {

    intakeMotors = new SpeedControllerGroup(new PWMVictorSPX(RobotMap.CAN_INTAKE_MOTOR));

  }

  public void setSpeed(double speed) {
    intakeMotors.set(speed);
  }

  @Override
  public void periodic() {

  }
}
