package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.Util;
import org.usfirst.frc.team4461.robot.commands.Drive;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {

	private CANTalon motor1, motor2, motor3, motor4, motor5, motor6;
	
	public Chassis(){
		
		motor1 = new CANTalon(RobotMap.m1);
		motor2 = new CANTalon(RobotMap.m2);
		motor3 = new CANTalon(RobotMap.m3);
		motor4 = new CANTalon(RobotMap.m4);
		motor5 = new CANTalon(RobotMap.m5);
		motor6 = new CANTalon(RobotMap.m6);
		
	}
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		Util.timeStamp("Chassis.java");
	}
	
	public void Run(double lSpeed, double rSpeed) {
		if (lSpeed > -.05 && lSpeed <.05){
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		}
		else if(rSpeed > -.05 && rSpeed <.05){
		motor4.set(0);
		motor5.set(0);
		motor6.set(0);
		}
		else{
		motor1.set(lSpeed);
		motor2.set(lSpeed);
		motor3.set(lSpeed);
		motor4.set(rSpeed);
		motor5.set(rSpeed);
		motor6.set(rSpeed);
		}
	}

	public void Stop(){
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		motor4.set(0);
		motor5.set(0);
		motor6.set(0);
	}
	
}