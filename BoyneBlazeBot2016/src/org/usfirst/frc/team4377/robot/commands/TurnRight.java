package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TurnRight extends Command {

    public TurnRight() {

        requires(Robot.driveTrain);
        setTimeout(3);
    }

    protected void initialize() {
    	Robot.driveTrain.turnRight();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.driveTrain.driveStraight(0);
    }

    protected void interrupted() {
    	end();
    }
}
