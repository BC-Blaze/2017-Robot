package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RetractArmDraw extends Command {

    public RetractArmDraw() {

        requires(Robot.armExtension);

    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.armExtension.retractArmExtension();
    }

    protected boolean isFinished() {
    	if (Robot.armExtension.getPosition() == 2)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 180)  );
    	}
    	else if (Robot.armExtension.getPosition() == 1)   {
    		return ( (Robot.armExtension.getSensorCounts() >= 90)  );
    	}
    	else return true;
    	    
    }

    protected void end() {
    	Robot.armExtension.stopArmExtension();
    	Robot.armExtension.setPosition(0);
    	Robot.armExtension.resetSensor();
    	
    	
    }

    protected void interrupted() {
    	end();
    }
}
