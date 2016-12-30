package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import org.usfirst.frc.team4377.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ManualOperateArm extends Command {

	double currentPosition = 0.400;
	double Y = 0;
	double newPosition = 0.400;
    public ManualOperateArm() {

    	requires(Robot.arm);

    }

    protected void initialize() {
    	Robot.arm.enable();
    }

    protected void execute() {
    	
    	//if (RobotMap.armSensorEnabled)  {
    		Y = (-1) * Robot.oi.joystick.getY();
        	currentPosition = Robot.arm.getPosition();
        	
        	if ((Y >= -0.1) && (Y <= 0.1))  {
        		newPosition = Robot.arm.getPosition();
        		Robot.arm.setSetpoint(newPosition);
        	}
        	if (Y>0.1)   {
        		newPosition = currentPosition + (Y*0.1);
        		Robot.arm.setSetpoint(newPosition);
        		
        	}
        	if (Y< -0.1)   {
        		newPosition = currentPosition + (Y*0.1);
        		Robot.arm.setSetpoint(newPosition);
        	}
        	
    		//Robot.arm.enable();
    		//Robot.arm.setSetpoint(newPosition);
    		
    	//} //else   {
    		//Robot.arm.disable();
    		//Robot.arm.manualOverRide(Robot.oi.getJoystick());
    	//}
    		
		
		Timer.delay(0.02);
    }
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    	
    }

    protected void interrupted() {
    	end();
    }
}
