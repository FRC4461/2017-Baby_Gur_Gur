package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class LimitSwitch extends Command {
	double timeToRun = 5000;
	double timeInitialized = 0;
	
    public LimitSwitch() {
		requires(Robot.Chassis);
    }

    protected void initialize() {
		Util.timeStamp("Voltage Move Init");
		timeInitialized = System.currentTimeMillis();
    }
    
    protected void execute() {
		Util.timeStamp("Moving");
	    	double lSpeed = .25;
	    	double rSpeed = .2685;
	    	Robot.Chassis.Run(lSpeed, rSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((timeInitialized + timeToRun) < System.currentTimeMillis() || Robot.Chassis.limitSwitchFeedback() == false){
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
