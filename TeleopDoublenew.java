package org.firstinspires.ftc.teamcode.states;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Double Control1", group="Jivitesh")

public class TeleopDoublenew extends LinearOpMode
{
    Hardware robot = new Hardware();

    @Override
    public void runOpMode()
    {

        robot.init(hardwareMap);

        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {

            Mecanum.Motion motion = Mecanum.joystickToMotion(gamepad1.left_stick_x,gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.right_stick_y);

            // Convert desired motion to wheel powers, with power clamping
            Mecanum.Wheels wheels = Mecanum.motionToWheels(motion);
            robot.frontLeft.setPower((wheels.frontLeft) * .5);
            robot.frontRight.setPower((wheels.frontRight) * .5);
            robot.backLeft.setPower((wheels.backLeft) * .5);
            robot.backRight.setPower((wheels.backRight) * .5);

            if (!gamepad2.dpad_down && !gamepad2.dpad_up) {
               // robot.vipLeft.setPower(0.0);
              //  robot.vipRight.setPower(0.0);





                robot.lower_claw.setPosition(0);
                robot.lower_rotation.setPosition(0);
                robot.lower_wrist.setPosition(0);
                robot.upper_wrist.setPosition(0);
                robot.upper_claw.setPosition(0);
            }
            if (gamepad2.dpad_up) {
                //robot.vipLeft.setPower(-1);
                //robot.vipRight.setPower(-1);
                robot.misumiLeft.setPosition(.06);
                robot.misumiRight.setPosition(.98);
                robot.lower_claw.setPosition(.6);
                robot.lower_rotation.setPosition(.6);
                robot.lower_wrist.setPosition(.6);
                robot.upper_wrist.setPosition(.6);
                robot.upper_claw.setPosition(.6);

            }
            if (gamepad2.dpad_down) {
                //robot.vipLeft.setPower(1);
                //robot.vipRight.setPower(1);
                robot.misumiLeft.setPosition(0.32);
                robot.misumiRight.setPosition(0.75);
                robot.lower_claw.setPosition(.45);
                robot.lower_rotation.setPosition(.45);
                robot.lower_wrist.setPosition(.45);
                robot.upper_wrist.setPosition(.45);
                robot.upper_claw.setPosition(.45);
            }

            if (!gamepad2.dpad_left && !gamepad2.dpad_right) {
                robot.linLeft.setPower(0);
                robot.linRight.setPower(0);
            }
            if (gamepad2.dpad_left) {
                robot.linLeft.setPower(-1);
                robot.linRight.setPower(-1);
            }
            if (gamepad2.dpad_right) {
                robot.linLeft.setPower(1);
                robot.linRight.setPower(-1);

            }



        }
    }
}
