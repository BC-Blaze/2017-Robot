package org.usfirst.frc.team4377.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static SpeedController driveTrainMotorRF;
    public static SpeedController driveTrainMotorRR;
    public static SpeedController driveTrainMotorLF;
    public static SpeedController driveTrainMotorLR;
    public static RobotDrive driveTrainRobotDrive;
    
    public static AnalogInput distanceSonar;
    
    public static SpeedController ballHarvesterMotor;
    
    public static boolean armSensorEnabled;
    public static AnalogPotentiometer armPot;
    public static SpeedController armMotor;
    
    public static SpeedController armExtensionMotor;
    public static Counter armExtensionZeroSwitch;
    public static Counter armExtensionSensor;
    public static AnalogTrigger armExtensionAnalogTrigger;
    
    public static SpeedController liftMotor1;
    public static DoubleSolenoid liftSolenoid;
    
   
    
    public static void init() {
    	
    // Drive Train Set Up  
       
        driveTrainMotorRF = new VictorSP(0);
        LiveWindow.addActuator("DriveTrain", "Motor RF", (VictorSP) driveTrainMotorRF);
        driveTrainMotorRR = new VictorSP(1);
        LiveWindow.addActuator("DriveTrain", "Motor RR", (VictorSP) driveTrainMotorRR);
        driveTrainMotorLF = new VictorSP(2);
        LiveWindow.addActuator("DriveTrain", "Motor LF", (VictorSP) driveTrainMotorLF);
        driveTrainMotorLR = new VictorSP(3);
        LiveWindow.addActuator("DriveTrain", "Motor LR", (VictorSP) driveTrainMotorLR);
        driveTrainRobotDrive = new RobotDrive(driveTrainMotorLF, driveTrainMotorLR,
        driveTrainMotorRF, driveTrainMotorRR);
        
        driveTrainRobotDrive.setSafetyEnabled(false);
        driveTrainRobotDrive.setExpiration(0.2);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
    // Ball Harvester Set Up PWM Channel 4
        ballHarvesterMotor = new Talon(4);
        LiveWindow.addActuator("Ball Harvester", "Motor", (Talon) ballHarvesterMotor);
    
    // Arm Motor Set Up PWM Channel 5
        armMotor = new Talon(5);
        armMotor.setInverted(true);
        LiveWindow.addActuator("Arm", "Motor", (Talon) armMotor);
        
    // Arm Extension Set Up PWM Channel 6       
        armExtensionMotor = new Spark(6);
        LiveWindow.addActuator("Arm Extension", "Motor", (Spark) armExtensionMotor);
        
    // Extension Zero Switch Set Up  Digital Input 3  
        armExtensionZeroSwitch = new Counter(3);
        LiveWindow.addSensor("Arm Extension", "Zero Switch", armExtensionZeroSwitch);
        
    // Arm Potentiometer Set Up  Analog Input 2
        armPot = new AnalogPotentiometer(2, 1, 0.0);
        LiveWindow.addSensor("Arm", "Pot", armPot);
    
    // Arm Extension Encoder Set Up Analog Input 3
        armExtensionAnalogTrigger = new AnalogTrigger(3);
        armExtensionAnalogTrigger.setLimitsVoltage(3.5, 3.8);
        
        armExtensionSensor = new Counter(armExtensionAnalogTrigger);
        armExtensionSensor.setDistancePerPulse(2);
        LiveWindow.addSensor("Arm Extension", "Sensor", armExtensionSensor);
        
    // Sonar Sensor Set Up Analog Input 1
        distanceSonar = new AnalogInput(1);
        LiveWindow.addSensor("DriveTrain", "Sonar", distanceSonar);
        
        liftMotor1 = new Talon(7);
        LiveWindow.addActuator("Lift", "Motor1", (Talon) liftMotor1);
        
        liftSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Lift", "Solenoid", liftSolenoid);
        
        
        
    }
    public static double leftCalc(double fwd,double rcw,double a, double b)   {
    	return (fwd+b*rcw*(1-fwd));
    }
    
    public static double rightCalc(double fwd,double rcw,double a, double b)   {
    	return (fwd-b*rcw +fwd*rcw*(b-a-1));
    }
}
