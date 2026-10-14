package org.wpilib.templates.opmode.opmode;

import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.opmode.Teleop;
import org.wpilib.templates.opmode.Robot;

@Teleop
public class MyTeleop extends PeriodicOpMode {
  private final Robot robot;

  public MyTeleop(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void periodic() {
    double speedMultiplier = 1.0;
    double forwardSpeed = robot.joystick.getY()*speedMultiplier;
    double turnSpeed = robot.joystick.getX()*speedMultiplier;
    robot.drive.arcadeDrive(-robot.joystick.getY(), robot.joystick.getX());
    if(robot.joystick.getRawButton(4)){
      speedMultiplier = 0.5;
    }
    else{
      speedMultiplier = 1.0;
    }

    // --- INTAKE CONTROL ---
    // If Button 1 (e.g., 'A') is pressed, spin intake forward. Otherwise, stop it.
    if (robot.joystick.getRawButton(1)) {
      robot.intakeMotor.set(1.0); // 1.0 is full power forward
    } else if (robot.joystick.getRawButton(2)) { 
      robot.intakeMotor.set(-1.0); // -1.0 reverses it to spit things out
    } else {
      robot.intakeMotor.set(0.0); // 0.0 turns the motor off
    }

    // --- SHOOTER CONTROL ---
    // If Button 3 (e.g., 'X') is pressed, spin shooter at full speed. Otherwise, stop it.
    if (robot.joystick.getRawButton(3)) {
      robot.shooterMotor.set(1.0); 
    } else {
      robot.shooterMotor.set(0.0);
    }
  }
}
