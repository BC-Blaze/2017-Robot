package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RaiseArmDraw extends Command {

    public RaiseArmDraw() {

       requires(Robot.arm);

    }

    protected void initialize() {

        Robot.arm.enable();
        Robot.arm.setSetpoint(Robot.armUpPosition);

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
