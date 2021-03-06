/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// used to map out the pins aka ports used by different parts of the robot
	// PWM
	public static final int[] LEFT_MOTORS = { 6, 5, 4 };
	public static final int[] RIGHT_MOTORS = {7, 8, 9};
	public static final int CLIMBER_MOTOR = 0;

	//DIO
	public static final int[] LEFT_ENCODER = {0, 1};
	public static final int[] RIGHT_ENCODER = {2, 3};
	
	
	//CAN
	public static final int[] CAN_SHOOTER_MOTOR = {6, 4};
	
	public static final int CAN_INTAKE_MOTOR = 3;
	public static final int[] CAN_HOPPER_MOTOR ={1, 2};

	
	// USB
	public static final int controllerPort = 0;
	
	
}
