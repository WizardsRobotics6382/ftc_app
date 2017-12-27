package org.firstinspires.ftc.teamcode;

/**
 * Created by Emma.younger18 on 11/21/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Arm Control", group="Linear Opmode")
//@Disabled

public class Move_Arm extends LinearOpMode {

    private DcMotor arm = null;

    @Override
    public void runOpMode () {

        arm = hardwareMap.get (DcMotor.class, "arm");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.dpad_up) {
                arm.setPower(-0.15);
            }

            else if (gamepad1.dpad_down) {
                    arm.setPower(0.15);
            }

            else {
                arm.setPower(0.0);
            }
        }
    }
}
