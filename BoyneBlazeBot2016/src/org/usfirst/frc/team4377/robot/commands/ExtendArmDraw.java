package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class ExtendArmDraw extends Command {

   
    public ExtendArmDraw() {

    	requires(Robot.armExtension);

    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.armExtension.extendArmExtension();
    }

    protected boolean isFinished() {
    	if (Robot.armExtension.getPosition() == 0)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 180)  );
    	}
    	else if (Robot.armExtension.getPosition() == 1)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 90)  );
    	}
    	else return true;
    	    
    }

    protected void end() {
    	Robot.armExtension.stopArmExtension();
    	Robot.armExtension.setPosition(2);
    	Robot.armExtension.resetSensor();
    }

    protected void interrupted() {
    	end();
    }
}
