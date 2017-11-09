//This is the hardware file for your robot
//This is where all moving parts will be created and named
//Note that one name is for use in the code, while the name in the "" is used for config

//Should be the location of your code
package org.firstinspires.ftc.teamcode;

//Your import statement pulls examples from the FTC library and lets you use them
//You shouldn't have to import anything new
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//This is the public class
//It is the name of your hardware file
//Whenever you want to use the motors from this file, you'll need to call this class
//I'll point out when it is called in the other examples
public class HardwareSebBot
//Everything that you declare needs to be inside of the {}
//This makes them a part of your class
{

    //I've labeled each set of motors based on what they control
    //Always make sure the motor is public, so that they can be used in other files
    //If they are set to private, other files cannot call and use them
    //To create motors follow the already given examples
    //Start off by declaring them public, then type what they are
    //For instance motors are DcMotor and servos are Servo
    //After that, name them.  This name is used throughout the code, so use the purple name in other files
    //Finally, set them equal to null. Don't ask why, just do it.
    // Drive Motors
    public DcMotor backLeftDrive = null;
    public DcMotor frontLeftDrive = null;
    public DcMotor backRightDrive = null;
    public DcMotor frontRightDrive = null;
    // Glyphs Arm Motors
    public DcMotor glyphMotor1 = null;
    public DcMotor glyphMotor2 = null;
    // Relic Arm Motors
    public DcMotor relicArm = null;
    // Glyph Grabbers
    public Servo leftGrabber = null;
    public Servo rightGrabber = null;
    public Servo jewelpusher = null;
    HardwareMap hwMap           =  null;
    public ElapsedTime period  = new ElapsedTime();



    //This is your hardware map
    //This lets you physically name the different motors/servos/parts on your robot
    //These green names in "" are what you will type in when configuring your robot


    //This initialized the hardware map
    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        //First take the name of the item you want to add the device name to
        //These are the purple names you created earlier
        //Follow the examples below to create your own
        //You'll set the item = hwMap.get
        //This code lets the brain search the plugged in hardware for something by that name
        //After that you'll again type the item type, so DcMotor or Servo followed by .class,
        //Finally put the deviceName in quotes and you're good to go


        // Drive motors
        backLeftDrive  = hwMap.get(DcMotor.class, "back_left");
        frontLeftDrive = hwMap.get(DcMotor.class, "front_left");
        backRightDrive = hwMap.get(DcMotor.class, "back_right");
        frontRightDrive = hwMap.get(DcMotor.class, "front_right");
        // Glyphs Arm Motors
        glyphMotor1 = hwMap.get(DcMotor.class, "left_glyph");
        glyphMotor2 = hwMap.get(DcMotor.class, "right_glyph");
        // Relic Arm Motors
        relicArm = hwMap.get(DcMotor.class, "relic_arm");
        // Glyph Grabbers
        leftGrabber = hwMap.get(Servo.class, "left_grab");
        rightGrabber = hwMap.get(Servo.class, "right_grab");
        jewelpusher = hwMap.get(Servo.class, "jewel_push");



        //This is the easiest part
        //You'll have to invert a few motors to get the robot going straight
        //Just type the name of the object, then set the direction and use either
        //FORWARD or REVERSE to invert the motor/servo

        // Drive Motors
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        // Glyph Arm Motors
        glyphMotor1.setDirection(DcMotor.Direction.FORWARD);
        glyphMotor2.setDirection(DcMotor.Direction.REVERSE);
        // Relic Arm Motors
        relicArm.setDirection(DcMotor.Direction.REVERSE);
        // Glyph Grabbers
        leftGrabber.setDirection(Servo.Direction.FORWARD);
        rightGrabber.setDirection(Servo.Direction.REVERSE);

    }
 }

