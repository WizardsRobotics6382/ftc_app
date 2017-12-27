package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Emma.younger18 on 12/22/17.
 */

@TeleOp(name = "All The Code", group="Linear Opmode")
//@Disabled

public class Everything extends LinearOpMode {
    private Servo servoL = null;
    private Servo servoR = null;
    private DcMotor arm = null;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorLeftBack = null;
    private DcMotor motorRightBack = null;
    private DcMotor motorLeftFront = null;
    private DcMotor motorRightFront = null;

    @Override
    public void runOpMode() {

        servoL = hardwareMap.get(Servo.class, "servoL");
        servoR = hardwareMap.get(Servo.class, "servoR");
        arm = hardwareMap.get(DcMotor.class, "arm");
        motorLeftBack = hardwareMap.dcMotor.get("motorLeftBack");
        motorRightBack = hardwareMap.dcMotor.get("motorRightBack");
        motorLeftFront = hardwareMap.dcMotor.get("motorLeftFront");
        motorRightFront = hardwareMap.dcMotor.get("motorRightFront");

        double left;
        double right;
        double drive;
        double turn;
        double max;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            //Drive

            drive = -gamepad1.left_stick_x;
            turn = gamepad1.right_stick_y;

            left = drive + turn;
            right = drive - turn;

            max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /= max;
            }

            motorLeftBack.setPower(left);
            motorRightBack.setPower(right);
            motorLeftFront.setPower(left);
            motorRightFront.setPower(right);

            //Claw

            if (gamepad1.x) {
                servoL.setPosition(1.0); //Close Left
            } else if (gamepad1.y) {
                servoL.setPosition(0); //Open Left
            } else if (gamepad1.b) {
                servoR.setPosition(1.0); //Close Right
            } else if (gamepad1.a) {
                servoR.setPosition(0); //Open Right
            }

            //Arm

            if (gamepad1.dpad_up) {
                arm.setPower(-0.15);
            } else if (gamepad1.dpad_down) {
                arm.setPower(0.15);
            } else {
                arm.setPower(0.0);
            }
        }
    }
}