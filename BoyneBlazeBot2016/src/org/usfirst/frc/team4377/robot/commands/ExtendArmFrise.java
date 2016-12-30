package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendArmFrise extends Command {

   
    public ExtendArmFrise() {

    	requires(Robot.armExtension);

    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (Robot.armExtension.getPosition() == 0)   {
    		Robot.armExtension.extendArmExtension();
    	}
    	else if (Robot.armExtension.getPosition() == 2)   {
    		Robot.armExtension.retractArmExtension();
    	}
    	else Robot.armExtension.stopArmExtension();
    }

    protected boolean isFinished() {
    	if (Robot.armExtension.getPosition() == 0)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 90)  );
    	}
    	else if (Robot.armExtension.getPosition() == 2)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 90)  );
    	}
    	else return true;
    	    
    }

    protected void end() {
    	Robot.armExtension.stopArmExtension();
    	Robot.armExtension.setPosition(1);
    	Robot.armExtension.resetSensor();
    }

    protected void interrupted() {
    	end();
    }
}
