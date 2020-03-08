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

public class hopper extends SubsystemBase {
  
  public VictorSPX hopperMotor2, hopperMotor;


  public hopper() {

    hopperMotor2 = new VictorSPX(RobotMap.CAN_HOPPER_MOTOR[1]);
    hopperMotor = new VictorSPX(RobotMap.CAN_HOPPER_MOTOR[0]);

  }

  public void setSpeed() {
    hopperMotor2.set(ControlMode.PercentOutput, -75);
    hopperMotor.set(ControlMode.PercentOutput, 20);
  }
}
