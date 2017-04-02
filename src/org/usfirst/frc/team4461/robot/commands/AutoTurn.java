package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {

	double runTime = 0;
	double timeInitialized = 0;
	boolean turnLeft;
	
	/**
	 * @param timeArg
	 * Put time in Seconds you want to run
	 * 
	 * @param turnArg
	 *  TRUE = Turn left
	 *  FALSE = Turn right
	 */
    public AutoTurn(double timeArg , boolean turnArg) {
    	requires(Robot.Chassis);
    	runTime = timeArg;
    	turnLeft = turnArg; 
    }
    
    protected void initialize() {
    	Util.timeStamp("Auto Turn Init");
    	timeInitialized = System.currentTimeMillis();
    }
    
    protected void execute() {
    	Util.timeStamp("Turning");
    	if (turnLeft){
	    	Robot.Chassis.Run(.2, -.225);
    	}
    	else if(!turnLeft){
	    	Robot.Chassis.Run(-.2, .225);
    	}
    }
    
    protected boolean isFinished() {
    	if((timeInitialized + runTime) < System.currentTimeMillis()){
        return true;
    	}
    	return false;
	}
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
}
