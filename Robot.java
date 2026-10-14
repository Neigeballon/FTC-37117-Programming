package org.wpilib.templates.opmode;

import org.wpilib.framework.OpModeRobot;
import org.wpilib.hardware.ArcadeDrivetrain; 
import org.wpilib.hardware.RobotJoystick;
import org.wpilib.hardware.Motor;

/**
 * The methods in this class are called automatically as described in the OpModeRobot documentation.
 * OpMode classes anywhere in the package (or sub-packages) where this class is located are
 * automatically registered to display in the Driver Station. If you change the name of this class
 * or the package after creating this project, you must also update the Main.java file in the
 * project.
 */
public class Robot extends OpModeRobot {
  public ArcadeDrivetrain drive;
  public RobotJoystick joystick;
  public Motor intakeMotor;
  public Motor shooterMotor;
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    this.drive = new ArcadeDrivetrain("left_drive", "right_drive");
    this.joystick = new RobotJoystick(0); // Number in parenthesis indicates which port
    this.intakeMotor = new Motor("intake_motor");
    this.shooterMotor = new Motor("shooter_motor");
  }

  /** This function is called exactly once when the DS first connects. */
  @Override
  public void driverStationConnected() {}

  /**
   * This function is called periodically anytime when no opmode is selected, including when the
   * Driver Station is disconnected.
   */
  @Override
  public void nonePeriodic() {}
}
