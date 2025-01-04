package org.firstinspires.ftc.teamcode.states;

import android.app.Activity;
import android.view.View;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;


public class Hardware
{
    // Chasis motors
    public DcMotor frontLeft =null;
    public DcMotor frontRight =null;
    public DcMotor backLeft =null;
    public DcMotor backRight =null;

    // arm lifter motors
    public DcMotor vipLeft =null;
    public DcMotor vipRight =null;

    // hang motors
    public DcMotor linLeft =null;
    public DcMotor linRight =null;

    public Servo misumiLeft =null;
    public Servo misumiRight =null;




    //Hang servos
    public Servo lower_claw =null;
    public Servo lower_wrist =null;
    public Servo lower_rotation =null;
    public Servo upper_claw =null;
    public Servo upper_wrist =null;



    // imu
    public IMU imu;
    public Orientation angles;
    public Acceleration gravity;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();


    // Constructor
    public Hardware(){}

    public void init(HardwareMap ahwMap)
    {
        hwMap = ahwMap;

        // Define and Initialize IMU & orientation
        imu = hwMap.get(IMU.class, "imu");
//        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
//        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
//        parameters.loggingEnabled      = true;
//        parameters.loggingTag          = "IMU";
//        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//        imu = hwMap.get(BNO055IMU.class, "imu");
//        imu.initialize(parameters);
//        angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//        gravity  = imu.getGravity();

        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.LEFT;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        imu.initialize(new IMU.Parameters(orientationOnRobot));
        imu.resetYaw();

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        AngularVelocity angularVelocity = imu.getRobotAngularVelocity(AngleUnit.DEGREES);

        // Now use these simple methods to extract each angle
        // (Java type double) from the object you just created:
        double Yaw   = orientation.getYaw(AngleUnit.DEGREES);
        double Pitch = orientation.getPitch(AngleUnit.DEGREES);
        double Roll  = orientation.getRoll(AngleUnit.DEGREES);

        // Define and Initialize Motors
        frontLeft      = hwMap.get(DcMotor.class, "fl"); //C0
        frontRight     = hwMap.get(DcMotor.class, "fr"); //C1
        backLeft       = hwMap.get(DcMotor.class, "bl"); //C2
        backRight      = hwMap.get(DcMotor.class, "br"); //C3

        vipLeft   = hwMap.get(DcMotor.class, "vl"); //E0
        vipRight   = hwMap.get(DcMotor.class, "vr"); //E0

        linLeft   = hwMap.get(DcMotor.class, "lln");  //E2
        linRight   = hwMap.get(DcMotor.class, "lr");  //E2


        // Define and Initialize Servos

        lower_claw  = hwMap.get(Servo.class, "lc");  //E2
        lower_rotation  = hwMap.get(Servo.class, "lro");  //E2
        lower_wrist  = hwMap.get(Servo.class, "lw");  //E2
        upper_claw  = hwMap.get(Servo.class, "uc");  //E2
        upper_wrist  = hwMap.get(Servo.class, "uw");  //E2


        misumiLeft   = hwMap.get(Servo.class, "ml"); //C3
        misumiRight  = hwMap.get(Servo.class, "mr"); //C3


        // Motors set direction and power
        frontRight.setDirection( DcMotorSimple.Direction.FORWARD );
        frontLeft.setDirection( DcMotorSimple.Direction.REVERSE );
        backRight.setDirection( DcMotorSimple.Direction.FORWARD );
        backLeft.setDirection( DcMotorSimple.Direction.REVERSE );

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);// Set to FORWARD if using AndyMark motors
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);// Set to FORWARD if using AndyMark motors

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        vipLeft.setDirection( DcMotorSimple.Direction.FORWARD );

        vipLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors

        vipLeft.setPower(0);
        vipRight.setDirection( DcMotorSimple.Direction.FORWARD );

        vipRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors

        vipRight.setPower(0);

        linLeft.setDirection( DcMotorSimple.Direction.REVERSE );

        linLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors

        linLeft.setPower(0);
        linRight.setDirection( DcMotorSimple.Direction.REVERSE );

        linRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to REVERSE if using AndyMark motors

        linRight.setPower(0);


        // Servos set direction and position
        misumiLeft.setDirection(Servo.Direction.FORWARD);
       misumiRight.setDirection(Servo.Direction.FORWARD);
        upper_claw.setDirection(Servo.Direction.FORWARD);
        upper_wrist.setDirection(Servo.Direction.FORWARD);
        lower_wrist.setDirection(Servo.Direction.FORWARD);
        lower_rotation.setDirection(Servo.Direction.FORWARD);
        lower_claw.setDirection(Servo.Direction.FORWARD);




        //motor_left_shoulder.setPosition(0.85);

        // Motors set mode
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        vipLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        vipRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        linLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        float hsvValues[] = {0F, 0F, 0F};

        final float values[] = hsvValues;

        final double SCALE_FACTOR = 255;

        int relativeLayoutId = hwMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hwMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hwMap.appContext).findViewById(relativeLayoutId);

    }


    public void setAllPower(double p)
    {
        setMotorPower(p,p,p,p);
    }

    public void setMotorPower(double frontLeftSpeed, double frontRightSpeed, double backRightSpeed, double backLeftSpeed)
    {
        frontLeft.setPower(frontLeftSpeed);
        frontRight.setPower(frontRightSpeed);
        backRight.setPower(backRightSpeed);
        backLeft.setPower(backLeftSpeed);

    }


}
