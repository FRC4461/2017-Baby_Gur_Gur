package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;
import org.usfirst.frc.team4461.robot.subsystems.AutonomousChassis;


public class CameraTest extends Command {
	double Time = 0;
	double timeRun = 0;
	
	/**
	 */
	public CameraTest(double timeRunArg){
		timeRun = timeRunArg;
	}

	@Override
	protected void initialize() {
		Util.timeStamp("Camera Test Init");
		Time = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		
    	Robot.AutonomousChassis.Run();
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
		Robot.AutonomousChassis.Stop();
		Util.timeStamp("Camera Test Stop");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}