package org.usfirst.frc.team4377.robot.subsystems;

import org.usfirst.frc.team4377.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BallHarvester extends Subsystem {

   private final SpeedController motor = RobotMap.ballHarvesterMotor;

   	public void initDefaultCommand() {
       
    }
    
    public void collectBall()   {
    	motor.set(-0.5);
    }
    
    public void shootBall()   {
    	motor.set(1);
    }
    
    public void stop()    {
    	motor.set(0);
    }
}

