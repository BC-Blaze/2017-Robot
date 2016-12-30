package org.usfirst.frc.team4377.robot.subsystems;

import org.usfirst.frc.team4377.robot.Robot;
import org.usfirst.frc.team4377.robot.RobotMap;
import org.usfirst.frc.team4377.robot.commands.ManualOperateArm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Arm extends PIDSubsystem {

   
    private final AnalogPotentiometer pot = RobotMap.armPot;
    private final SpeedController motor = RobotMap.armMotor;

    public Arm() {
        
        super("Arm", 10, 0.0, 0.0);
        setAbsoluteTolerance(0.01);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Arm", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(-0.5, 0.5);
        getPIDController().setInputRange(Robot.armUpPosition,Robot.armDownPosition);
        //setSetPoint((Robot.armDownPosition-((Robot.armDownPosition-Robot.armUpPosition)/2)));
        //enable();
    }

    public void initDefaultCommand() {
       
    	setDefaultCommand(new ManualOperateArm());

    }
    
    public void setSetPoint(double m_setPoint)  {
    	
    	getPIDController().setSetpoint(m_setPoint);
    }

    protected double returnPIDInput() {
        
        return pot.get();

    }

    protected void usePIDOutput(double output) {
               motor.pidWrite(output);

    }
    
    public void manualOverRide (Joystick stick)   {
    	motor.set((-stick.getY()));
    }
   
}
