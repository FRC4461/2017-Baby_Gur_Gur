package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class voltageMove extends Command {
	double systemTime = 0;
	double Time = 0;
	boolean motorForward;
	
    public voltageMove(double timeRun, boolean forward) {
		requires(Robot.Chassis);
		Time = timeRun * 1000;
		motorForward = forward;
    }

    protected void initialize() {
		Util.timeStamp("Voltage Move Init");
		systemTime = System.currentTimeMillis();
    }
    
    protected void execute() {
		Util.timeStamp("Moving");
		if(motorForward){
	    	double lSpeed = .2325;
	    	double rSpeed = .2;
	    	Robot.Chassis.Run(lSpeed, rSpeed);
		}
		else if(!motorForward){
	    	double lSpeed = -.2325;
	    	double rSpeed = -.2;
	    	Robot.Chassis.Run(lSpeed, rSpeed);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((systemTime + Time) < System.currentTimeMillis() || Robot.Chassis.limitSwitchFeedback() == false){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Util.timeStamp("Move End");
    	Robot.Chassis.Stop();
    }

    protected void interrupted() {
    	Robot.Chassis.Stop();
    	Util.timeStamp("Move Interupted");
    }
}
