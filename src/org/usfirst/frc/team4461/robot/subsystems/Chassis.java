package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.Drive;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	CANTalon m1 = new CANTalon(RobotMap.m1);
//	CANTalon m2 = new CANTalon(RobotMap.m2);
	//CANTalon m3 = new CANTalon(RobotMap.m3);
	CANTalon m4 = new CANTalon(RobotMap.m4);
	//CANTalon m5 = new CANTalon(RobotMap.m5);
	//CANTalon m6 = new CANTalon(RobotMap.m6);

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		System.out.println("4461: Chassis.java");
	}
	
	public void Run() {
		System.out.println("4461: Left Joystick Y "+Robot.oi.lJoyGetY()+", Right Joystick Y "+ Robot.oi.rJoyGetY());
		if (Robot.oi.lJoyGetY() > -.05 && Robot.oi.lJoyGetY() <.05){
		m1.set(0);
//		m2.set(0);
//		m3.set(0);
		}
		else if(Robot.oi.rJoyGetY() > -.05 && Robot.oi.rJoyGetY() <.05){
		m4.set(0);
//		m5.set(0);
//		m6.set(0);
		}
		else{
		m1.set(-Robot.oi.lJoyGetY());
//		m2.set(-Robot.oi.lJoyGetY());
//		m3.set(-Robot.oi.lJoyGetY());
		m4.set(-Robot.oi.rJoyGetY());
//		m5.set(-Robot.oi.lJoyGetY());
//		m6.set(-Robot.oi.lJoyGetY());
		}
	}
	
	public void Stop(){
		m1.set(0);
		m4.set(0);
	}
}
