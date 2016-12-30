package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseArmPort extends Command {

    public RaiseArmPort() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        Robot.arm.enable();
        Robot.arm.setSetpoint(Robot.armUpPosition + 0.200);

    }

    protected void execute() {
    }

    protected boolean isFinished() {

        return Robot.arm.onTarget();

    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
