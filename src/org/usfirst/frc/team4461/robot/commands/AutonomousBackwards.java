package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;


public class AutonomousBackwards extends Command {
	double Time = 0;
	double timeRun = 0;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public AutonomousBackwards(double timeRunArg){
		timeRun = timeRunArg;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("Autonomous Backwards Init");
		Time = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
    	double lSpeed = -1;
    	double rSpeed = -1;
		Robot.Chassis.Run(lSpeed, rSpeed);
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
		Util.timeStamp("Autonomous Backwards Stop");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}