package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

public class AutonomousMove extends Command {
	final double countsPerRevolution = 1024;
	final double wheelCircumference = 12.56;
	double leftDistanceInTicks = 0;
	double rightDistanceInTicks = 0;
	double ticksToTarget = 0;
	double distance = 0;
		
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousMove(double distanceArg){
		requires(Robot.Chassis);
		Util.timeStamp("auto move");
		distance = distanceArg;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("auto move");
		double wheelRotations = distance / wheelCircumference;
		double ticksToTravel = wheelRotations * countsPerRevolution;
		leftDistanceInTicks = ticksToTravel * 1;
		rightDistanceInTicks = ticksToTravel * -1;
		Robot.Chassis.encoderMove(leftDistanceInTicks, rightDistanceInTicks);
	}

	@Override
	protected void execute() {
		Util.timeStamp(Robot.Chassis.leftEncoderGet()+"/"+Robot.Chassis.rightEncoderGet());
	}

	@Override
	protected boolean isFinished(){
		double leftTicksToTarget = leftDistanceInTicks - Robot.Chassis.leftEncoderGet();
		double rightTicksToTarget = rightDistanceInTicks - Robot.Chassis.rightEncoderGet();
		boolean leftEncoderDone = false;
		boolean rightEncoderDone = false;
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
		Util.timeStamp("Autonomous Forward Stop");
	}

	@Override
	protected void interrupted() {
		end();
	}
}