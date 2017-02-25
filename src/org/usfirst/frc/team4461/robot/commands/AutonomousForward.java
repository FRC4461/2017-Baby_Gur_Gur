package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;


public class AutonomousForward extends Command {
	double distance1 = 0;
	double distance2 = 0;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousForward(double distanceArg, double distanceArg2){
		distance1 = distanceArg;
		distance2 = distanceArg2;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("Autonomous Forward Init");
		Robot.Chassis.encoderMove(distance1, distance2);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished(){
		double f = distance1 - Robot.Chassis.leftEncoderGet();
		if(Math.abs(f) < 50){
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