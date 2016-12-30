
package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class CollectBall extends Command {

   
    public CollectBall() {

    	requires(Robot.ballHarvester);

    }

    protected void initialize() {
    }

   
    protected void execute() {
    	Robot.ballHarvester.collectBall();
    }

    
    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    	Robot.ballHarvester.stop();
    }

    
    protected void interrupted() {
    	end();
    }
}
