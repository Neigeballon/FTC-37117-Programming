package org.firstinspires.ftc.teamcode;//IS THE MOTOR A DC MOTOR? IF NOT, LOOK UP WHAT TO DO!!!
//CHECK TO SEE IF THE LEFT AND RIGHT MOTORS WORK IN REVERSE OR NOT!!!
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Basic Robot OpMode", group = "Linear Opmode")
public class BasicRobotOpMode extends LinearOpMode {

    // Declare FTC Hardware components
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor intakeMotor = null;
    private DcMotor shooterMotor = null;
    private double speedMultiplier = 1.0;
    private boolean doesMultiply = false;
    private boolean lastState = false;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables using the hardware map from the driver station
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        shooterMotor = hardwareMap.get(DcMotor.class, "shooter_motor");

        // Set motor directions if needed (e.g., reverse one side of the drive)
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        // Run while the match is running
        while (opModeIsActive()) {
            // Check the current state of the A button
            boolean currentState = gamepad1.a;

            // Detect if the button was just pressed (transitioned from unpressed to pressed)
            if (currentState && !lastState) {
            doesMultiply = !doesMultiply; // Flip the state (true becomes false, false becomes true)
            }

            // Save the current state for the next loop iteration
            lastState = currentState;
            if (doesMultiply) {
                speedMultiplier = 0.5;
            }
            else {
                speedMultiplier = 1.0;
            }
            
            // Basic Arcade Drive logic using Gamepad 1
            // Y-axis is usually inverted on gamepads, so we negate it (-gamepad1.left_stick_y)
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;

            if (Math.abs(drive) < 0.05) drive = 0;
            if (Math.abs(turn) < 0.05) turn = 0;

            double leftPower  = rangeClip(drive + turn);
            double rightPower = rangeClip(drive - turn);

            leftDrive.setPower(leftPower*speedMultiplier);
            rightDrive.setPower(rightPower*speedMultiplier);

            // Intake control (e.g., press A button)
            
            if (gamepad2.left_trigger > 0.1) {
                intakeMotor.setPower(-1.0);
            }
            else if (gamepad2.left_bumper) {
                intakeMotor.setPower(1.0);
            }
            else {
                intakeMotor.setPower(0.0);
            }

            // Shooter control (e.g., hold B button)
           
            if (gamepad2.right_trigger > 0.1) {
                shooterMotor.setPower(-1.0);
            }
            else if (gamepad2.right_bumper) {
                shooterMotor.setPower(1.0);
            }
            else {
                shooterMotor.setPower(0.0);
            }

            // Send telemetry data back to the Driver Station
            telemetry.addData("Left Pwr", leftPower);
            telemetry.addData("Right Pwr", rightPower);
            telemetry.update();
        }
    }

    // Helper method to keep motor power values between -1.0 and 1.0
    private double rangeClip(double value) {
        return Math.max(-1.0, Math.min(1.0, value));
    }
}
