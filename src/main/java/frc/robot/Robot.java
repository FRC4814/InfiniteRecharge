/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.haloDriveCommand;
import frc.robot.subsystems.driveTrain;
import frc.robot.utils.DashboardVariable;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public PowerDistributionPanel pdp;
  private DashboardVariable<Double> totaVoltage = new DashboardVariable<Double>("total voltage", 0.00);
  private DashboardVariable<Double> driveMotorCurrent = new DashboardVariable<Double>("drive motor current", 0.00);

  public static NetworkTable cameraTable;
  public static NetworkTableInstance table;
  public static NetworkTableEntry yaw, pitch, isDriverMode, targetX, targetY;
  public static double rotError, distError, kpRot = -0.1, kpDistance = -0.01, angleTolerance = 5, distanveTolerance = 5, rotationAdjust, distanceAdjust;   

  private RobotContainer m_robotContainer;
  public static driveTrain driveTrain = new driveTrain();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    // Gets the default instance of NetworkTables
    table = NetworkTableInstance.getDefault();

    // Gets the MyCamName table under the chamelon-vision table
    // MyCamName will vary depending on the name of your camera
    cameraTable = table.getTable("chameleon-vision").getSubTable("MyCamName");

    // Gets the yaw to the target from the cameraTable
    yaw = cameraTable.getEntry("yaw");

    // Gets the driveMode boolean from the cameraTable
    isDriverMode = cameraTable.getEntry("driver_mode");

    driveTrain.rightEnc.reset();
    driveTrain.leftEnc.reset();

    pdp = new PowerDistributionPanel(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    totaVoltage.set(pdp.getVoltage());
    driveMotorCurrent.set(pdp.getCurrent(15));
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    CommandScheduler.getInstance().setDefaultCommand(driveTrain, new haloDriveCommand(driveTrain));
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
