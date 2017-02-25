package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.Util;
import org.usfirst.frc.team4461.robot.commands.Drive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

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
		
		leftMotor1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		leftMotor1.setPID(.2, 0, 0);
		leftMotor2.changeControlMode(TalonControlMode.Follower);
		leftMotor3.changeControlMode(TalonControlMode.Follower);
		leftMotor2.set(RobotMap.CANTalon1);
		leftMotor3.set(RobotMap.CANTalon1);
		
		rightMotor1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rightMotor1.setPID(.2, 0, 0);
		rightMotor2.changeControlMode(TalonControlMode.Follower);
		rightMotor3.changeControlMode(TalonControlMode.Follower);
		rightMotor2.set(RobotMap.CANTalon4);
		rightMotor3.set(RobotMap.CANTalon4);
	}//End Chassis
	
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		Util.timeStamp("Chassis.java");
	}//End DefaultCommand
	
	public void Run(double lSpeed, double rSpeed) {
		leftMotor1.changeControlMode(TalonControlMode.PercentVbus);
		rightMotor1.changeControlMode(TalonControlMode.PercentVbus);
		leftMotor1.set(lSpeed);
		rightMotor1.set(-rSpeed);
}

	public void encoderMove(double leftDistanceInTicks, double rightDistanceInTicks) {
		leftMotor1.setPosition(0);
		rightMotor1.setPosition(0);
		leftMotor1.changeControlMode(TalonControlMode.Position);
		rightMotor1.changeControlMode(TalonControlMode.Position);
		leftMotor1.set(leftDistanceInTicks);
		rightMotor1.set(rightDistanceInTicks);
}
	
	public void encoderMove(double distanceInTicks) {
		leftMotor1.setPosition(0);
		rightMotor1.setPosition(0);
		leftMotor1.changeControlMode(TalonControlMode.Position);
		rightMotor1.changeControlMode(TalonControlMode.Position);
		leftMotor1.set(distanceInTicks);
		rightMotor1.set(distanceInTicks);
}


	public double leftEncoderGet(){
		return leftMotor1.get();
	}
	
	public double rightEncoderGet(){
		return rightMotor1.get();
	}

	public void Stop(){
		leftMotor1.set(0);
		leftMotor2.set(0);
		leftMotor3.set(0);
		rightMotor1.set(0);
		rightMotor2.set(0);
		rightMotor3.set(0);
	}// End Stop
}//End Class