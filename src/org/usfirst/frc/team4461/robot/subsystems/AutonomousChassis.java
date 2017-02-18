package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.Util;
import org.usfirst.frc.team4461.robot.commands.CameraTest;
import org.usfirst.frc.team4461.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


public class AutonomousChassis extends Subsystem {
	
	//Initializing Motors
	private static CANTalon leftMotor1;
	private static CANTalon leftMotor2;
	private static CANTalon leftMotor3;
	private static CANTalon rightMotor1;
	private static CANTalon rightMotor2;
	private static CANTalon rightMotor3;
	
	public AutonomousChassis(){
		leftMotor1 = new CANTalon(RobotMap.CANTalon1);
		leftMotor2 = new CANTalon(RobotMap.CANTalon2);
		leftMotor3 = new CANTalon(RobotMap.CANTalon3);
		rightMotor1 = new CANTalon(RobotMap.CANTalon4);
		rightMotor2 = new CANTalon(RobotMap.CANTalon5);
		rightMotor3 = new CANTalon(RobotMap.CANTalon6);
	}//End Chassis
	
	public void initDefaultCommand() {
		Util.timeStamp("Chassis.java");
	}//End DefaultCommand
	
	public void Run() {
		double centerX;
		synchronized (Robot.imgLock) {
			centerX = Robot.visionThreadCenterX;
		}
		double turn = centerX - (Robot.IMG_WIDTH / 2);
			leftMotor1.set(-0.6);
			leftMotor2.set(-0.6);
			leftMotor3.set(-0.6);
			rightMotor1.set(turn * 0.005);
			rightMotor2.set(turn * 0.005);
			rightMotor3.set(turn * 0.005);
		}//End Else
		// End Run

	public void Stop(){
		leftMotor1.set(0);
		leftMotor2.set(0);
		leftMotor3.set(0);
		rightMotor1.set(0);
		rightMotor2.set(0);
		rightMotor3.set(0);
	}// End Stop
}//End Class