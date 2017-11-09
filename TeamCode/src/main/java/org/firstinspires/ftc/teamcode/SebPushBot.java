//All this top mumbo jumbo is the same as in hardware

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

//This is where you name your op mode
//This is what the driver will see on the driver station phone
//TO change the teleop name, change what the name equals, and put in quotes
//This is good for testing different code, especially in autonomous
@TeleOp(name="Pushbot: Teleop Tank", group="Pushbot")


//Another public class, this time its for teleop
//Name this something you can remember and extend OpMode
//Extending OpMode means that it will include the following parts
public class SebPushBot extends OpMode{


    //This is where you type in your hardware file name
    //Type exactly what I have, but replace HardwareSebBot with your file name
    //This makes the hardware file a part of your OpMode
    HardwareSebBot robot       = new HardwareSebBot();



    @Override
    public void init() {
        //Initialize your hardwareMap so that the robot has stuff to actually control
        robot.init(hardwareMap);

        //You can add telemetry the way I have it here to display info on the driver station
        //This will let you know your opmode is working, or can help you keep track of different
        //autonomous modes
        telemetry.addData("Say", "Hello Driver");    //
    }

    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
    }

    //Declare doubles, which are positive to negative values used to control motors
    //You'll need one for each motor in a different area
    //For instance, two drive motors on the same side can use the same, but an arm motor will need
    //its own
    @Override
    public void loop() {
        double leftPower;
        double rightPower;
        double glyphArm;
        double relic;

        //Take those doubles and set them equal to controller input
        //In this example I took leftPower and set it equal to the input of the left stick's y-axis
        //This let's the left stick control the left side of your robot with values -1 to 1
        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;
        glyphArm = -gamepad2.left_stick_y ;
        relic = -gamepad2.right_stick_y;

        // This sets each motor equal to the power from your sticks
        // You can see here each drive motor is set to either left or right power
        // Make sure to put robot. in front of motor names so they know to check the robot
        robot.backLeftDrive.setPower(leftPower);
        robot.frontLeftDrive.setPower(leftPower);
        robot.backRightDrive.setPower(rightPower);
        robot.frontRightDrive.setPower(rightPower);

        robot.glyphMotor1.setPower(glyphArm);
        robot.glyphMotor2.setPower(glyphArm);

        robot.relicArm.setPower(relic);


        //servos work differently from motors in that they have to be manually set to go
        //either forwards or backwards
        //Here I made an else if chain to do that
        //I set the conditions to be different buttons
        //left bumper sets the servos to 1, which is forward
        //left trigger (when it's pressed down more than 20%) makes them go backwards
        //The else is there for the case in which neither button is pressed
        //In that case it's set to .5 which is motionless for servos
        if (gamepad2.left_bumper)  {
            robot.leftGrabber.setPosition(1.0);
            robot.rightGrabber.setPosition(1.0);
        }
        else if (gamepad2.left_trigger >0.2) {
            robot.leftGrabber.setPosition(0.0);
            robot.rightGrabber.setPosition(0.0);
        }
        else {
            robot.leftGrabber.setPosition(0.5);
            robot.rightGrabber.setPosition(0.5);
        }
        if (gamepad1.left_bumper)  {
            robot.jewelpusher.setPosition(0.0);
        }
        else if (gamepad1.right_bumper) {
            robot.jewelpusher.setPosition(1.0);

        }
        else {
            robot.jewelpusher.setPosition(0.5);

        }
    }


    @Override
    public void stop() {
    }
}
