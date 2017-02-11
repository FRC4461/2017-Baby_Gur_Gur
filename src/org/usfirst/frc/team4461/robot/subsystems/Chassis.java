package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.Drive;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {

	private CANTalon motor1, motor2, motor3, motor4, motor5, motor6;
	
	private Encoder encoder1;
	private Encoder encoder2;
	
	private double encoderOneRate = 1/(1.0/1);
	private double encoderTwoRate = 1/(1.0/1);
	
	public Chassis(){
		
		motor1 = new CANTalon(RobotMap.m1);
		motor2 = new CANTalon(RobotMap.m2);
		motor3 = new CANTalon(RobotMap.m3);
		motor4 = new CANTalon(RobotMap.m4);
		motor5 = new CANTalon(RobotMap.m5);
		motor6 = new CANTalon(RobotMap.m6);
		
		encoder1 = new Encoder(RobotMap.ChassisEncoder1, RobotMap.ChassisEncoder2, RobotMap.ChassisEncoder3);
		encoder2 = new Encoder(RobotMap.ChassisEncoder4, RobotMap.ChassisEncoder5, RobotMap.ChassisEncoder6);
		
		encoder1.reset();
		encoder2.reset();
		
		encoder1.setDistancePerPulse(encoderOneRate);
		encoder2.setDistancePerPulse(encoderTwoRate);
		
	}
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		System.out.println("4461: Chassis.java");
	}
	
	public void Run() {
		if (Robot.oi.lJoyGetY() > -.05 && Robot.oi.lJoyGetY() <.05){
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		}
		else if(Robot.oi.rJoyGetY() > -.05 && Robot.oi.rJoyGetY() <.05){
		motor4.set(0);
		motor5.set(0);
		motor6.set(0);
		}
		else{
		motor1.set(-Robot.oi.lJoyGetY());
		motor2.set(-Robot.oi.lJoyGetY());
		motor3.set(-Robot.oi.lJoyGetY());
		motor4.set(-Robot.oi.rJoyGetY());
		motor5.set(-Robot.oi.rJoyGetY());
		motor6.set(-Robot.oi.rJoyGetY());
		}
	}
	
	public void Stop(){
//		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		motor4.set(0);
		motor5.set(0);
		motor6.set(0);
	}
	
	public void updateDashboard(){
		SmartDashboard.putNumber("Encoder One Pulses", encoder1.get());
		SmartDashboard.putNumber("Encoder Two Pulses", encoder2.get());
		SmartDashboard.putNumber("Encoder One Distance", encoder1.getDistance());
		SmartDashboard.putNumber("Encoder Two Distance", encoder2.getDistance());
	}
}