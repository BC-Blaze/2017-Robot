package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Portcullis extends CommandGroup {
    
    public  Portcullis() {
    	
    	requires(Robot.driveTrain);
    	requires(Robot.arm);
    	
    	
    	addParallel(new ApproachDefense());
    	addSequential(new LowerArmPort());
    	Timer.delay(1);    
        addParallel(new RaiseArmPort());
        addSequential(new DriveStraight(4,-0.6));
       
    }
}
