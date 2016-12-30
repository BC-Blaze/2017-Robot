package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SallyPort extends CommandGroup {
    
    public  SallyPort() {
    	
    	requires(Robot.driveTrain);
    	requires(Robot.armExtension);
    	requires(Robot.arm);
    	
    	
    	addParallel(new ApproachDefense());
    	addSequential(new RaiseArmSally());
    	Timer.delay(1);
        addSequential(new LowerArmSally());
        addSequential (new TurnLeft());
        addParallel(new LowerArmDraw());
        addSequential(new TurnRight());
        addSequential(new DriveStraight(4,-0.6));
        
    }
}
