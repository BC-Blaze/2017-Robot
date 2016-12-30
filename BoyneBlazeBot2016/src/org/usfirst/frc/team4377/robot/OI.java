package org.usfirst.frc.team4377.robot;

import org.usfirst.frc.team4377.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class OI {
   
    public Joystick xBoxControl;
    public JoystickButton joystickButton1;
    public JoystickButton joystickButton2;
    public JoystickButton joystickButton3;
    public JoystickButton joystickButton4;
    public JoystickButton joystickButton5;
    public JoystickButton joystickButton7;
    public JoystickButton joystickButton8;
    public JoystickButton joystickButton11;
    public JoystickButton joystickButton12;
    public Joystick joystick;
   
    //public SendableChooser armSensorChooser;


   

    public OI() {
        joystick = new Joystick(1);
        

        joystickButton4 = new JoystickButton(joystick, 4);
        joystickButton4.whileHeld(new ManualExtendArm());
        joystickButton3 = new JoystickButton(joystick, 3);
        joystickButton3.whileHeld(new ManualRetractArm());
       // joystickButton5 = new JoystickButton(joystick, 5);
        //joystickButton5.whenPressed(new ZeroArmExtension());
        joystickButton2 = new JoystickButton(joystick, 2);
        joystickButton2.whileHeld(new CollectBall());
        joystickButton1 = new JoystickButton(joystick, 1);
        joystickButton1.whileHeld(new ShootBall());
        xBoxControl = new Joystick(0);
        
        joystickButton7 = new JoystickButton(joystick, 7);
        joystickButton7.whenPressed(new RetractLift());
        
        joystickButton8 = new JoystickButton(joystick, 8);
        joystickButton8.whenPressed(new ExtendLift());
        
        joystickButton11 = new JoystickButton(joystick, 11);
        joystickButton11.whileHeld(new WinchMotorDown());
        
        joystickButton12 = new JoystickButton(joystick, 12);
        joystickButton12.whileHeld(new WinchMotorUp());

        SmartDashboard.putData("Cheval de Frise", new Cheval_de_Frise());
        SmartDashboard.putData("Drawbridge", new DrawBridge());
        SmartDashboard.putData("Portcullis", new Portcullis());
        SmartDashboard.putData("Sally Port", new SallyPort());
        
       // SmartDashboard.putData("Extend the Arm for Drawbridge", new ExtendArmDraw());
       // SmartDashboard.putData("Extend the Arm for Cheval de Frise", new ExtendArmFrise());
        //SmartDashboard.putData("Zero the Arm Extension", new ZeroArmExtension());
       // SmartDashboard.putData("Retract the Arm for Drawbridge", new RetractArmDraw());
       // SmartDashboard.putData("Retract the Arm for Cheval de Frise", new RetractArmFrise()); 
        
        //SmartDashboard.putData("Lower the Arm for Drawbridge", new LowerArmDraw());
        //SmartDashboard.putData("Lower the Arm for Cheval de Frise", new LowerArmFrise());
        //SmartDashboard.putData("Lower the Arm for Portcullis", new LowerArmPort());
        //SmartDashboard.putData("Lower the Arm for Sally Port", new LowerArmSally());
        
        //SmartDashboard.putData("Raise the Arm for Drawbridge", new RaiseArmDraw());
        //SmartDashboard.putData("Raise the Arm for Portcullis", new RasieArmPort());
        //SmartDashboard.putData("Raise the Arm for Sally Port", new RasieArmSally());
       
        //SmartDashboard.putNumber("Extension Arm Counter", Robot.armExtension.getSensorCounts());
        //SmartDashboard.putNumber("Arm Pot Value", Robot.arm.getPosition());
        
       
      
        
    }

   public Joystick getXBoxControl() {
        return xBoxControl;
    }

    public Joystick getJoystick() {
        return joystick;
    }

}

