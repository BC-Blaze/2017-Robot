package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class DrawBridge extends CommandGroup {


    public DrawBridge() {
    	
    	requires(Robot.driveTrain);
    	requires(Robot.armExtension);
    	requires(Robot.arm);

    	addParallel(new RaiseArmDraw());
    	addParallel(new ExtendArmDraw());
    	addSequential(new ApproachDefense());
        Timer.delay(1);
        addSequential(new DriveStraight(0.5,-0.35));
        Timer.delay(1);
        addParallel(new LowerArmDraw());
        addParallel(new RetractArmDraw());
        addSequential(new DriveStraight(1,0.4));
        Timer.delay(1);
        addSequential(new DriveStraight(2,-0.6));
    } 
}
