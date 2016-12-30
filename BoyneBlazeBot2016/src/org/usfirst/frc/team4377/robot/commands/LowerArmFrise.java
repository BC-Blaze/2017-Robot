package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerArmFrise extends Command {

    public LowerArmFrise() {

       requires(Robot.arm);

    }

    protected void initialize() {

        Robot.arm.enable();
        Robot.arm.setSetpoint(Robot.armDownPosition -0.075);

    }


    protected void execute() {
    }


    protected boolean isFinished() {

        return Robot.arm.onTarget();

    }

 
    protected void end() {
    }

  
    protected void interrupted() {
    }
}
