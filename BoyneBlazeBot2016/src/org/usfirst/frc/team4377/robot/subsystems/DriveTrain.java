package org.usfirst.frc.team4377.robot.subsystems;

import org.usfirst.frc.team4377.robot.RobotMap;
import org.usfirst.frc.team4377.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {

	private final SpeedController motorRF = RobotMap.driveTrainMotorRF;
    private final SpeedController motorRR = RobotMap.driveTrainMotorRR;
    private final SpeedController motorLF = RobotMap.driveTrainMotorLF;
    private final SpeedController motorLR = RobotMap.driveTrainMotorLR;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final AnalogInput sonar = RobotMap.distanceSonar;

    double a = 0.5;
    double b = 1.0;
    double fwd = 0;
	double rcw = 0;
	double left = 0;
	double right = 0;

    public void initDefaultCommand() {
        
        setDefaultCommand(new ArcadeDrive());

    }
    
    public void arcadeDrive(Joystick stick)   {
    	
    	if ((stick.getRawAxis(1) > 0.2) || (stick.getRawAxis(1) < -0.2))   {
    		fwd = stick.getRawAxis(1)*(stick.getRawAxis(3)+0.5);
    	} else {
    		fwd = 0;
    	}
       	
    	if ((stick.getRawAxis(4) > 0.2) || (stick.getRawAxis(4) < -0.2))   {	
    		rcw = -(stick.getRawAxis(4)*(stick.getRawAxis(3)+0.5));
    	} else {
    		rcw = 0;
    	}
    	
    	//quadrant 1
    	if (fwd>=0) {
    		 if (rcw>=0)  {
    			 left = RobotMap.leftCalc(fwd, rcw, a, b);
    			 right = RobotMap.rightCalc(fwd, rcw, a, b);
    		 }
    	//quadrant 2
    		 else   {
    			 left = RobotMap.rightCalc(fwd, -rcw, a, b);
    			 right = RobotMap.leftCalc(fwd, -rcw, a, b);
    		 }
    	}
    	//quadrant 4
    	else  {
    		if (rcw>=0)   {
    			left = -(RobotMap.rightCalc(-fwd, rcw, a, b));
    			right = -(RobotMap.leftCalc(-fwd, rcw, a, b));
    		}
    	
    	//quadrant 3
    		else   {
    			left = -(RobotMap.leftCalc(-fwd, -rcw, a, b));
    			right = -(RobotMap.rightCalc(-fwd, -rcw, a, b));
    		}  
    	}
    	
    	robotDrive.setLeftRightMotorOutputs(left,right);
    	
    }
    
    public void driveStraight(double speed)   {
    	robotDrive.setLeftRightMotorOutputs(speed, speed);
    }
    
    public void turnLeft()   {
    	robotDrive.tankDrive(0.6, 0.4);
    }
    
    public void turnRight()   {
    	robotDrive.tankDrive(-0.5, 0.5);
    }
    
    public double getDistance()   {
    	return sonar.getAverageVoltage()*100;
    }
}

