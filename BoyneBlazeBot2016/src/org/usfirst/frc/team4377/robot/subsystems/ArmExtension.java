package org.usfirst.frc.team4377.robot.subsystems;

import org.usfirst.frc.team4377.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ArmExtension extends Subsystem {

    private final SpeedController motor = RobotMap.armExtensionMotor;
    private final Counter zeroSwitch = RobotMap.armExtensionZeroSwitch;
    private final Counter sensor = RobotMap.armExtensionSensor;
    
    int Position=0;
    
    public void initDefaultCommand() {
    	
    }
    
    public void zeroArmExtension()   {
    	
    	motor.set(-1);;
    }
    
    public void stopArmExtension()   {
    	motor.set(0);
    }
    
    public void retractArmExtension()   {
    	
    	motor.set(-1);
    	
    }
    
    public void extendArmExtension()  {
    	
    	motor.set(1);
    	
    }
    
    public double getSensorCounts()   {
    	return sensor.getDistance();
    }
    
       
    public void resetSensor()   {
    	sensor.reset();
    
    }
    
    public int getPosition()   {
    	return Position;
    }
    
    public void setPosition(int X)  {
    	Position = X;
    }
    
    
    
}

