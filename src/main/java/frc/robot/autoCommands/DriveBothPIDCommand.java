/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import java.lang.module.ModuleDescriptor.Requires;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveBothPIDCommand extends CommandBase {
	double targetSetpointL, targetSetpointR;
	double currentSetpointL, currentSetpointR;
	double speedL, speedR;
	boolean onTarget;
  /**
   * Creates a new DriveBothPIDCommand.
   */

  public DriveBothPIDCommand(double targetSetpointL, double targetSetpointR) {
    // Use addRequirements() here to declare subsystem dependencies.
    this(targetSetpointL, targetSetpointR, 0.4);
  }

  public DriveBothPIDCommand(double targetSetpointL, double targetSetpointR, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    

    this.targetSetpointL = targetSetpointL;
		this.targetSetpointR = targetSetpointR;

		this.speedL = (targetSetpointL > 0) ? speed : -speed;
		this.speedR = this.speedL;

		if (targetSetpointL > targetSetpointR)
			this.speedR *= targetSetpointR / targetSetpointL;
		else
			this.speedL *= targetSetpointL / targetSetpointR;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentSetpointL = 0.0;
		currentSetpointR = 0.0;

		onTarget = false;

    Robot.driveTrain.rightEnc.reset();
    Robot.driveTrain.rightEnc.reset();
		Robot.driveTrain.enablePID();

		System.out.println("Drive Init");
  }

  // Called every time the scheduler runs while the command is scheduled.
  double speedMod = 1.0;

  @Override
  public void execute() {
    if (currentSetpointL > targetSetpointL)
			speedMod *= 0.7;
		speedMod = Math.max(speedMod, 0.1);

		currentSetpointL = currentSetpointL + speedL * speedMod;
		currentSetpointR = currentSetpointR + speedR * speedMod;

		Robot.driveTrain.setSetpoint(currentSetpointL, currentSetpointR);

		System.out.println(currentSetpointL + currentSetpointR);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //if (isFinished())
		//	Robot.pidArm.disable();

		Robot.driveTrain.resetSpeedLimit();
		Robot.driveTrain.setSpeed(0.0, 0.0);

		Robot.driveTrain.setSetpoint(targetSetpointL, targetSetpointR);

		//Robot.driveTrain.disablePID();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (targetSetpointL > 0)
			return Robot.driveTrain.leftEnc.getDistance() >= targetSetpointL && Robot.driveTrain.rightEnc.getDistance() >= targetSetpointR;
    else
    // not sure if supposed to be like this but right encoder is mentioned                   ^  V
			return Robot.driveTrain.leftEnc.getDistance() <= targetSetpointL && Robot.driveTrain.rightEnc.getDistance() <= targetSetpointR;
  }
}
