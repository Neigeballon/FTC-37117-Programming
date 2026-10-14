package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Basic Auto", group = "Autonomous")
public class BasicAuto extends LinearOpMode {

    // Declare FTC Hardware components
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor intakeMotor = null;
    private DcMotor shooterMotor = null;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables using the hardware map from the driver station
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        shooterMotor = hardwareMap.get(DcMotor.class, "shooter_motor");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready for Auto");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {}
        
    }
}
