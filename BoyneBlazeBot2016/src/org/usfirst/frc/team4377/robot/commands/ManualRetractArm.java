package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ManualRetractArm extends Command {

    public ManualRetractArm() {

        requires(Robot.armExtension);

    }

    protected void initialize() {
    }

    protected void execute() {
     		Robot.armExtension.retractArmExtension();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.armExtension.stopArmExtension();
    }

    protected void interrupted() {
    	end();
    }
}
