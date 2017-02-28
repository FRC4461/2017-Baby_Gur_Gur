package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;


public class AutonomousTurn extends Command {
	double degreesInInches = 0;
	double distanceInTicks = 0;
	double leftDistanceInTicks = 0;
	double rightDistanceInTicks = 0;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousTurn(double inchesArg){
		requires(Robot.Chassis);
		degreesInInches = inchesArg * .09744;
		distanceInTicks = degreesInInches / .00306641;
		leftDistanceInTicks = 1 * distanceInTicks;
		rightDistanceInTicks = -1 *distanceInTicks;		
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
		double leftTicksToTarget = distanceInTicks - Robot.Chassis.leftEncoderGet();
		double rightTicksToTarget = distanceInTicks - Robot.Chassis.rightEncoderGet();
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
		Util.timeStamp("Autonomous Turn Left Stop");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}