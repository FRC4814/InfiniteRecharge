/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.utils.DashboardVariable;
import frc.robot.utils.PID;

public class driveTrain extends SubsystemBase {
  /**
   * Creates a new driveTrain.
   */

  public DifferentialDrive drive;
  private SpeedControllerGroup leftGroup, rightGroup;
  private double gearRatio = 20.00, distancePerPulse, pulsesPerRevolution = 4096;
  private int wheelSize = 6;
  public Encoder leftEnc, rightEnc;

  public DashboardVariable<Double>    kP = new DashboardVariable<Double>("kP", 0.00),
                                      kI = new DashboardVariable<Double>("kI", 0.00),
                                      kD = new DashboardVariable<Double>("kD", 0.00);

  public DashboardVariable<Boolean> driveStraight = new DashboardVariable<Boolean>("drive straight", false);

  PID drivePID;

  public driveTrain(){

    leftEnc = new Encoder(RobotMap.LEFT_ENCODER[0], RobotMap.LEFT_ENCODER[1], true, EncodingType.k4X);
    leftEnc.setMaxPeriod(0.2);

    rightEnc = new Encoder(RobotMap.RIGHT_ENCODER[0], RobotMap.RIGHT_ENCODER[1], true, EncodingType.k4X);
    rightEnc.setMaxPeriod(0.2);

    //calculate distance per pulse
    distancePerPulse = (wheelSize * Math.PI) / (pulsesPerRevolution * gearRatio);

    leftEnc.setDistancePerPulse(distancePerPulse);
    rightEnc.setDistancePerPulse(distancePerPulse);

    leftGroup = new SpeedControllerGroup(new PWMVictorSPX(RobotMap.LEFT_MOTORS[0]), new PWMVictorSPX(RobotMap.LEFT_MOTORS[1]), new PWMVictorSPX(RobotMap.LEFT_MOTORS[2]));
    rightGroup = new SpeedControllerGroup(new PWMVictorSPX(RobotMap.RIGHT_MOTORS[0]), new PWMVictorSPX(RobotMap.RIGHT_MOTORS[1]), new PWMVictorSPX(RobotMap.RIGHT_MOTORS[2]));

    drive = new DifferentialDrive(leftGroup, rightGroup);

    drivePID= new PID(leftEnc, rightEnc, kP.get(), kI.get(), kD.get());
  }


  public void curvDrive() {
    double throttle = OI.myController.getY(Hand.kLeft);
    double turn = OI.myController.getX(Hand.kRight);
    boolean isQuickTurn = false, isSlow = false;


    //quick turn logic
    if(throttle < 0.25){
      isQuickTurn = true;
    }
    else{
      isQuickTurn = false;
    }
    //checks if the slow button is pressed
    if(OI.slowButton.get()) {
      isSlow = true;
    }
    if(isSlow){
      drive.curvatureDrive(throttle/3, turn, isQuickTurn);
    }else{
      drive.curvatureDrive(throttle, turn, isQuickTurn);
    }
    


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
