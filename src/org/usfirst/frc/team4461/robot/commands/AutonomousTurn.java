package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;


public class AutonomousTurn extends Command {
	double wheelRadius = 2;
	double robotRadius = 13.51;
	double ticksPerRevolution = 4096;
	double encoderWheelTicks = 0;
	double turnAmount = 0;
	double leftDistanceInTicks = 0;
	double rightDistanceInTicks = 0;
	double leftTicksToTarget = 0;
	double rightTicksToTarget = 0;
	
	boolean leftEncoderDone;
	boolean rightEncoderDone;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousTurn(double inchesArg){
		requires(Robot.Chassis);
		encoderWheelTicks = ((robotRadius / wheelRadius) * (ticksPerRevolution / 360));
		turnAmount = encoderWheelTicks * inchesArg;
		leftDistanceInTicks = turnAmount * 1;
		rightDistanceInTicks = turnAmount * -1;
	}

	@Override
	protected void initialize() {
		Robot.Chassis.encoderMove(leftDistanceInTicks, rightDistanceInTicks);
		Util.timeStamp("Autonomous Turn Left Init");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished(){
		leftTicksToTarget = leftDistanceInTicks - Robot.Chassis.leftEncoderGet();
		rightTicksToTarget = rightDistanceInTicks - Robot.Chassis.rightEncoderGet();
		leftEncoderDone = false;
		rightEncoderDone = false;
		if(Math.abs(leftTicksToTarget) < 50){
			leftEncoderDone = true;
		}
		if(Math.abs(rightTicksToTarget) < 50){
			rightEncoderDone = true;
		}
		
		if (leftEncoderDone && rightEncoderDone){
			return true;
		}
		else return false;
	}

	@Override
	protected void end() {
		Robot.Chassis.Stop();
		Util.timeStamp("Autonomous Turn Left Stop");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}