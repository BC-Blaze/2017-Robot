package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

   
    public ArcadeDrive() {

    	requires(Robot.driveTrain);

    }

    
    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.arcadeDrive(Robot.oi.getXBoxControl());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.driveStraight(0);
    }

    protected void interrupted() {
    	end();
    }
}
