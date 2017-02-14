package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.Util;
import org.usfirst.frc.team4461.robot.commands.Drive;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	
	//Initializing Motors
	private CANTalon leftMotor1,
					 leftMotor2,
					 leftMotor3,
					 rightMotor1,
					 rightMotor2,
					 rightMotor3;
	
	public Chassis(){
		leftMotor1 = new CANTalon(RobotMap.CANTalon1);
		leftMotor2 = new CANTalon(RobotMap.CANTalon2);
		leftMotor3 = new CANTalon(RobotMap.CANTalon3);
		rightMotor1 = new CANTalon(RobotMap.CANTalon4);
		rightMotor2 = new CANTalon(RobotMap.CANTalon5);
		rightMotor3 = new CANTalon(RobotMap.CANTalon6);
	}//End Chassis
	
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		Util.timeStamp("Chassis.java");
	}//End DefaultCommand
	
	public void Run(double lSpeed, double rSpeed) {
		
		if (lSpeed > -.05 && lSpeed <.05){
			leftMotor1.set(0);
			leftMotor2.set(0);
			leftMotor3.set(0);
		}//End If
		
		else if(rSpeed > -.05 && rSpeed <.05){
			rightMotor1.set(0);
			rightMotor2.set(0);
			rightMotor3.set(0);
		}//End Else if
		
		else{
			leftMotor1.set(lSpeed);
			leftMotor2.set(lSpeed);
			leftMotor3.set(lSpeed);
			rightMotor1.set(rSpeed);
			rightMotor2.set(rSpeed);
			rightMotor3.set(rSpeed);
		}//End Else
		
	}// End Run

	public void Stop(){
		leftMotor1.set(0);
		leftMotor2.set(0);
		leftMotor3.set(0);
		rightMotor1.set(0);
		rightMotor2.set(0);
		rightMotor3.set(0);
	}// End Stop
}//End Class