package org.firstinspires.ftc.teamcode;

/**
 * Created by Emma.younger18 on 12/12/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Claw Control", group="Linear Opmode")
//@Disabled


public class Move_Claw extends LinearOpMode {

    private Servo servoL = null;
    private Servo servoR = null;

    @Override
    public void runOpMode() {

        servoL = hardwareMap.get (Servo.class, "servoL");
        servoR = hardwareMap.get (Servo.class, "servoR");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.x) {
                servoL.setPosition(1.0); //Close Left
            }

            else if (gamepad1.y) {
                servoL.setPosition(0); //Open Left
            }

            else if (gamepad1.b) {
                servoR.setPosition(1.0); //Close Right
            }

            else if (gamepad1.a) {
                servoR.setPosition(0); //Open Right
                                }
        }
    }
}
