package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class movePlz extends Command {
	double systemTime = 0;
	double Time = 0;
	
    public movePlz(double timeRun) {
		requires(Robot.Chassis);
		Time = timeRun * 1000;
    }

    protected void initialize() {
		Util.timeStamp("MOVE PLZ INIT");
		systemTime = System.currentTimeMillis();
    }
    
    protected void execute() {

		Util.timeStamp("MOOOOVEEE PLLZZZZ");
    	    	double lSpeed = .2;
    	    	double rSpeed = .2;
    	    	Robot.Chassis.Run(lSpeed, rSpeed);
    		}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((systemTime + Time) < System.currentTimeMillis()){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Util.timeStamp("Move End");
    }

    protected void interrupted() {
    }
}
