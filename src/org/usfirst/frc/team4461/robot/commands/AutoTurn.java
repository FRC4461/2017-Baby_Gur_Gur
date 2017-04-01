package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {

	double systemTime = 0;
	double Time = 0;
	boolean turnLeft;
	
	
    public AutoTurn(boolean turnArg) {
    	requires(Robot.Chassis);
    	turnLeft = turnArg; 
		Time = 1000;
    }
    
    protected void initialize() {
    	Util.timeStamp("Auto Turn Init");
    	systemTime = System.currentTimeMillis();
    }
    
    protected void execute() {
    	Util.timeStamp("Turning");
    	if (turnLeft){
	    	Robot.Chassis.Run(.5, -.5);
    	}
    	else if(!turnLeft){
	    	Robot.Chassis.Run(-.5, .5);
    	}
    }
    
    protected boolean isFinished() {
    	if((systemTime + Time) < System.currentTimeMillis()){
        return false;
    	}
    	return true;
	}
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
}
