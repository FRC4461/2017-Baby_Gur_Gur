package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

public class AutonomousMove extends Command {
	double distance = 0;
	double distanceInTicks = 0;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousMove(double distanceArg){
		requires(Robot.Chassis);
		distance = distanceArg;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("Autonomous Forward Init"+Robot.Chassis.rightEncoderGet());
		distanceInTicks = distance / .00306641;
		Robot.Chassis.encoderMove(distanceInTicks);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished(){
		Util.timeStamp("left Encoder Move"+Robot.Chassis.leftEncoderGet());
		double ticksToTarget = distanceInTicks - Robot.Chassis.leftEncoderGet();
		if(Math.abs(ticksToTarget) < 50){
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