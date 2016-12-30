package org.usfirst.frc.team4377.robot;

import org.usfirst.frc.team4377.robot.commands.Cheval_de_Frise;
import org.usfirst.frc.team4377.robot.commands.DefaultAutonomousCommandGroup;
import org.usfirst.frc.team4377.robot.commands.DrawBridge;
import org.usfirst.frc.team4377.robot.commands.Portcullis;
import org.usfirst.frc.team4377.robot.commands.SallyPort;
import org.usfirst.frc.team4377.robot.subsystems.Arm;
import org.usfirst.frc.team4377.robot.subsystems.ArmExtension;
import org.usfirst.frc.team4377.robot.subsystems.BallHarvester;
import org.usfirst.frc.team4377.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4377.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

    CommandGroup autonomousCommand;
    public SendableChooser autoChooser;
    public static double armUpPosition = 0.190;  
	public static double armDownPosition = 0.470;  
    public static OI oi;
    public static DriveTrain driveTrain;
    public static BallHarvester ballHarvester;
    public static Arm arm;
    public static ArmExtension armExtension;
    public static Lift lift;
    
   
    
    
    public void robotInit() {
    	RobotMap.init();
    
    	
 		
        driveTrain = new DriveTrain();
        ballHarvester = new BallHarvester();
        arm = new Arm();
        armExtension = new ArmExtension();
        lift = new Lift();
         
        oi = new OI();
       
       // autoChooser = new SendableChooser();
       // autoChooser.addDefault("Drive Over Defenses", new DefaultAutonomousCommandGroup());
       // autoChooser.addObject("Draw Bridge",(new DrawBridge()));
       // autoChooser.addObject("Chival de Frise", new Cheval_de_Frise());
       // autoChooser.addObject("Sally Port", new SallyPort());
       // autoChooser.addObject("Portcullis", new Portcullis());
        
      //  SmartDashboard.putData("Autonomous Choice",autoChooser);
        
    }

    
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	
    	// autonomousCommand = (CommandGroup) SmartDashboard.getData("Autonomous Choice");
    	//if (autonomousCommand != null) autonomousCommand.start();
    	autonomousCommand = (CommandGroup) new DefaultAutonomousCommandGroup();
    	autonomousCommand.start();
        
    }

   
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
       
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

   
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Extension Arm Counter", Robot.armExtension.getSensorCounts());
        SmartDashboard.putNumber("Arm Pot Value", Robot.arm.getPosition());
        SmartDashboard.putNumber("Sonar Sensor", Robot.driveTrain.getDistance());
        //RobotMap.armSensorEnabled = SmartDashboard.getBoolean("Arm Sensor Enabled", true);
       
       	}

    public void testPeriodic() {
        LiveWindow.run();
    }
}
