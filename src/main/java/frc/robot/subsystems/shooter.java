/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class shooter extends SubsystemBase {

  public VictorSPX shooterMotor1;
  public PWMVictorSPX shooterMotor2;


  public shooter() {
    shooterMotor1 = new VictorSPX(RobotMap.CAN_SHOOTER_MOTOR);
    shooterMotor2 = new PWMVictorSPX(RobotMap.SHOOTER_MOTOR);

  }

  @Override
  public void periodic() {
    
  }

  public void startShooting(){
    shooterMotor1.set(ControlMode.PercentOutput, 100);
    shooterMotor2.set(1);
  }
}
