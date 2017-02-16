package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;


public class AutonomousShoot extends Command {
	double Time = 0;
	double timeRun = 0;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousShoot(double timeRunArg){
		timeRun = timeRunArg;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("Autonomous Shoot Init");
		Time = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished(){
		if((Time + timeRun) < System.currentTimeMillis()){
		return true;
		}
		else return false;
	}

	@Override
	protected void end() {
		Robot.Chassis.Stop();
		Util.timeStamp("Autonomous Shoot Stop");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}