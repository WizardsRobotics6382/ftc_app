package org.firstinspires.ftc.teamcode;/*
package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor

*/
/**
 * Created by Emma.younger18 on 12/19/17.
 *//*


@TeleOp(name = "Red Autonoumous", group="TeleOp")
@Disabled

public class Autonomous_Red extends LinearOpMode {

    float hsvValues[] = {0F,0F,0F};
    final float values[] = hsvValues;
    int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
    final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
    boolean bPrevState = false;
    boolean bCurrState = false;
    boolean bLedOn = true;
    colorSensor.enableLed(bLedOn);

    private ColorSensor colorSensor = null;
    private CRServo colorArm = null;
    private Servo servoR = null;
    private DcMotor motorLeftBack = null;
    private DcMotor motorRightBack = null;
    private DcMotor motorLeftFront = null;
    private DcMotor motorRightFront = null;


    public void runOpMode(){

        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        colorArm = hardwareMap.get(CRServo.class, "colorArm" );
        servoR = hardwareMap.get (Servo.class, "servoR");
        motorLeftBack = hardwareMap.dcMotor.get ("motorLeftBack");
        motorRightBack = hardwareMap.dcMotor.get ("motorRightBack");
        motorLeftFront = hardwareMap.dcMotor.get ("motorLeftFront");
        motorRightFront = hardwareMap.dcMotor.get ("motorRightFront");

        waitForStart();

        while (opModeIsActive()) {

            colorArm.setDirection(?);

            // check for button state transitions.
            if (bCurrState && (bCurrState != bPrevState))  {

                // button is transitioning to a pressed state. So Toggle LED
                bLedOn = !bLedOn;
                colorSensor.enableLed(bLedOn);
            }

            // Move red motor forward at 70% if red is detected.
            if (colorSensor.red() > 20){ //go forward
                motorLeftBack.setPower(50);
                motorRightBack.setPower(50);
                motorLeftFront.setPower(50);
                motorRightFront.setPower(50);
            }

            // Move blue motor forward at 70% if red is detected.
            else if (colorSensor.blue() > 20){ //go backward
                motorLeftBack.setPower(-50);
                motorRightBack.setPower(-50);
                motorLeftFront.setPower(-50);
                motorRightFront.setPower(-50);
            }

            // Do not move motors if neither color is detected.
            else {
                motorLeftBack.setPower(0);
                motorRightBack.setPower(0);
                motorLeftFront.setPower(0);
                motorRightFront.setPower(0);
            }

            // update previous state variable.
            bPrevState = bCurrState;

            // convert the RGB values to HSV values.
            Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValues);

            // send the info back to driver station using telemetry function.
            telemetry.addData("LED", bLedOn ? "On" : "Off");
            telemetry.addData("Clear", colorSensor.alpha());
            telemetry.addData("Red  ", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue ", colorSensor.blue());
            telemetry.addData("Hue", hsvValues[0]);

            // change the background color to match the color detected by the RGB sensor.
            // pass a reference to the hue, saturation, and value array as an argument
            // to the HSVToColor method.
            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
                }
            });

            telemetry.update();
        }

        // Set the panel back to the default color
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.WHITE);

            delay (1000);    //go forward

            motorLeftBack.setPower(50);
            motorRightBack.setPower(50);
            motorLeftFront.setPower(50);
            motorRightFront.setPower(50);

            delay (2000);  //turn

            motorLeftBack.setPower(0);
            motorRightBack.setPower(50);
            motorLeftFront.setPower(0);
            motorRightFront.setPower(50);

            delay (1000); //go forward

            motorLeftBack.setPower(50);
            motorRightBack.setPower(50);
            motorLeftFront.setPower(50);
            motorRightFront.setPower(50);

            delay (500);

            ServoR.setPosition(0); //open claw
        }

    }
}
*/
