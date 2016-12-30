package org.usfirst.frc.team4377.robot.commands;

import org.usfirst.frc.team4377.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class Cheval_de_Frise extends CommandGroup {
    
    public  Cheval_de_Frise() {
    	
    	requires(Robot.driveTrain);
    	requires(Robot.armExtension);
    	requires(Robot.arm);
    	
    	addSequential(new RaiseArmSally());
    	Timer.delay(1);
    	addParallel(new DriveStraight(3,-0.6));
        addSequential(new ExtendArmFrise());
        Timer.delay(1);
        addSequential(new LowerArmFrise());
        addParallel(new RetractArmFrise());
        addSequential(new LowerArmDraw());
        addSequential(new DriveStraight(6,-0.6));
        
    }
}
