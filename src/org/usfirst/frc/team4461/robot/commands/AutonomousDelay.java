package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDelay extends Command {
	
    public AutonomousDelay() {
    }

    protected void initialize() {
    	double delayTime;
    	Util.timeStamp("DELAY");
    	delayTime = Robot.timeChooser.getSelected(); 
    	setTimeout(delayTime);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Util.timeStamp("DELAY FINISHED");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
