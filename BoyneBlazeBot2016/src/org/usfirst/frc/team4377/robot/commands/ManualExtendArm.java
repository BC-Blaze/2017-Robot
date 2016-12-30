package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ManualExtendArm extends Command {

    public ManualExtendArm() {

        requires(Robot.armExtension);

    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.armExtension.extendArmExtension();
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
