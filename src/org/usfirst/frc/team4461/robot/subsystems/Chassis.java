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
		
		leftMotor2.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		leftMotor2.setPID(.2, 0, 0);
		leftMotor1.changeControlMode(TalonControlMode.Follower);
		leftMotor1.set(leftMotor2.getDeviceID());
		leftMotor3.changeControlMode(TalonControlMode.Follower);
		leftMotor3.set(leftMotor2.getDeviceID());
		
		rightMotor2.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rightMotor2.setPID(.2, 0, 0);
		rightMotor1.changeControlMode(TalonControlMode.Follower);
		rightMotor1.set(rightMotor2.getDeviceID());
		rightMotor3.changeControlMode(TalonControlMode.Follower);
		rightMotor3.set(rightMotor2.getDeviceID());
		
		
		Util.timeStamp("Chassis");
	}//End Chassis
	
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}//End DefaultCommand
	
	public void Run(double lSpeed, double rSpeed) {
		leftMotor1.changeControlMode(TalonControlMode.PercentVbus);
		rightMotor1.changeControlMode(TalonControlMode.PercentVbus);
		leftMotor2.changeControlMode(TalonControlMode.PercentVbus);
		rightMotor2.changeControlMode(TalonControlMode.PercentVbus);
		leftMotor3.changeControlMode(TalonControlMode.PercentVbus);
		rightMotor3.changeControlMode(TalonControlMode.PercentVbus);
		
		leftMotor1.setVoltageRampRate(.3);
		leftMotor2.setVoltageRampRate(.3);
		leftMotor3.setVoltageRampRate(.3);
		rightMotor1.setVoltageRampRate(.3);
		rightMotor2.setVoltageRampRate(.3);
		rightMotor3.setVoltageRampRate(.3);
		
		leftMotor1.set(lSpeed);
		rightMotor1.set(-rSpeed);
		leftMotor2.set(lSpeed);
		rightMotor2.set(-rSpeed);
		leftMotor3.set(lSpeed);
		rightMotor3.set(-rSpeed);
}

	public void encoderMove(double leftDistanceInTicks, double rightDistanceInTicks) {

		leftMotor2.changeControlMode(TalonControlMode.Position);
		rightMotor2.changeControlMode(TalonControlMode.Position);
		leftMotor2.setPosition(0);
		rightMotor2.setPosition(0);
		leftMotor2.set(leftDistanceInTicks);
		rightMotor2.set(rightDistanceInTicks);
}

	
	public double leftEncoderGet(){
		return leftMotor2.getEncPosition();
	}
	
	public double rightEncoderGet(){
		return rightMotor2.getEncPosition();
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