package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="Pushbot: Auto Drive By Time", group="Pushbot")

public class AutoTest extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareSebBot        robot   = new HardwareSebBot();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {


        robot.init(hardwareMap);


        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();


        waitForStart();


        robot.frontLeftDrive.setPower(FORWARD_SPEED);
        robot.frontRightDrive.setPower(FORWARD_SPEED);
        robot.backLeftDrive.setPower(FORWARD_SPEED);
        robot.backRightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        robot.frontLeftDrive.setPower(TURN_SPEED);
        robot.frontRightDrive.setPower(-TURN_SPEED);
        robot.backLeftDrive.setPower(TURN_SPEED);
        robot.backRightDrive.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }




        robot.frontLeftDrive.setPower(-TURN_SPEED);
        robot.frontRightDrive.setPower(TURN_SPEED);
        robot.backLeftDrive.setPower(-TURN_SPEED);
        robot.backRightDrive.setPower(TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
