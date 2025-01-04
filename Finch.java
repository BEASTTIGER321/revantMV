package org.firstinspires.ftc.teamcode.states;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Finch {
    private static Hardware robot = new Hardware();

    enum MovementType {
        FORWARD,
        BACKWARDS,
        STRAFE_LEFT,
        STRAFE_RIGHT,
        TURN_LEFT,
        TURN_RIGHT,
    }
    
    static double ticksPerRotation = 537.6;
    static double wheelCircumference = 11.8737122661;
    static double inchesPerTick = ticksPerRotation/wheelCircumference;

    public static double inchesToTicks(double inches) {
        double ticksMoved = inches * inchesPerTick;
        return ticksMoved;
    }
    public static void moveInches(double inches, double speed, MovementType movementType) {
        switch(movementType) {
            case FORWARD:
                while(true) {
                    if(robot.frontLeft.getCurrentPosition() >= inchesToTicks(-inches) && robot.frontRight.getCurrentPosition() <= inchesToTicks(inches)) {
                        robot.frontLeft.setPower(-speed);
                        robot.frontRight.setPower(speed);
                        robot.backLeft.setPower(-speed);
                        robot.backRight.setPower(speed);
                    }
                    else if(robot.frontLeft.getCurrentPosition() <= inchesToTicks(-inches) && robot.frontRight.getCurrentPosition() >= inchesToTicks(inches)) {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case BACKWARDS:
                while(true) {
                    if(robot.frontLeft.getCurrentPosition() <= inchesToTicks(inches) && robot.frontRight.getCurrentPosition() >= inchesToTicks(-inches)) {
                        robot.frontLeft.setPower(speed);
                        robot.frontRight.setPower(-speed);
                        robot.backLeft.setPower(speed);
                        robot.backRight.setPower(-speed);
                    }
                    else if(robot.frontLeft.getCurrentPosition() >= inchesToTicks(inches) && robot.frontRight.getCurrentPosition() <= inchesToTicks(-inches)) {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case STRAFE_LEFT:
                while(true) {
                    if(robot.frontLeft.getCurrentPosition() <= inchesToTicks(inches) && robot.frontRight.getCurrentPosition() <= inchesToTicks(inches)) {
                        robot.frontLeft.setPower(speed);
                        robot.frontRight.setPower(speed);
                        robot.backLeft.setPower(-speed);
                        robot.backRight.setPower(-speed);
                    }
                    else if(robot.frontLeft.getCurrentPosition() >= inchesToTicks(inches) && robot.frontRight.getCurrentPosition() >= inchesToTicks(inches)) {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case STRAFE_RIGHT:
                while(true) {
                    if(robot.frontLeft.getCurrentPosition() >= inchesToTicks(-inches) && robot.frontRight.getCurrentPosition() >= inchesToTicks(-inches)) {
                        robot.frontLeft.setPower(-speed);
                        robot.frontRight.setPower(-speed);
                        robot.backLeft.setPower(speed);
                        robot.backRight.setPower(speed);
                    }
                    else if(robot.frontLeft.getCurrentPosition() <= inchesToTicks(-inches) && robot.frontRight.getCurrentPosition() <= inchesToTicks(-inches)) {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
        }
    }
    public static void rotateDegrees(double degrees, double speed, MovementType movementType){
        switch(movementType) {
            case TURN_LEFT:
                while(true) {
                    if(!(robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES) > degrees)) {
                        robot.frontLeft.setPower(speed);
                        robot.frontRight.setPower(speed);
                        robot.backLeft.setPower(speed);
                        robot.backRight.setPower(speed);
                    }
                    else {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.imu.resetYaw();
                break;
            case TURN_RIGHT:
                while(true) {
                    if(!(robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES) < -degrees)) {
                        robot.frontLeft.setPower(-speed);
                        robot.frontRight.setPower(-speed);
                        robot.backLeft.setPower(-speed);
                        robot.backRight.setPower(-speed);
                    }
                    else {
                        robot.frontLeft.setPower(0);
                        robot.frontRight.setPower(0);
                        robot.backLeft.setPower(0);
                        robot.backRight.setPower(0);
                        break;
                    }
                }
                robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                robot.imu.resetYaw();
                break;
        }
    }
}