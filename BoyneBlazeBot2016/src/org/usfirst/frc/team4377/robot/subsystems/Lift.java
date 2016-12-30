package org.usfirst.frc.team4377.robot.subsystems;

import org.usfirst.frc.team4377.robot.RobotMap;
import org.usfirst.frc.team4377.robot.commands.WinchMotorStop;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	private final SpeedController motor1 = RobotMap.liftMotor1;
    private final DoubleSolenoid solenoid = RobotMap.liftSolenoid;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
       setDefaultCommand(new WinchMotorStop());
       
    }
    
    public void liftMotorsForward()   {
    	motor1.set(1);;
    }
    
    public void liftMotorsReverse()   {
    	motor1.set(-1);
    }
    
    public void liftMotorsStop()   {
    	motor1.set(0);
    }
    
    public void solenoidForward()   {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void solenoiodReverse()   {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    	
    }
    public void soleniodOff()   {
    	solenoid.set(DoubleSolenoid.Value.kOff);
    }
}

