package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Command {
	private static NetworkTable table;
	double Time = 0;
	
    public Vision() {
		requires(Robot.Chassis);
    }

    protected void initialize() {
    	Util.timeStamp("VISION");
		table = NetworkTable.getTable("/GRIP/Contors");
		Time = System.currentTimeMillis();
    }

	public static boolean complete = false;
	
    protected void execute() {
		double[] defaultValue = new double[0];
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		Util.timeStamp("Center X"+centerX.length);
    	double lSpeed = 0;
    	double rSpeed = 0;
    	if(centerX.length == 2){
    		double trueCenterX = (centerX[0] + centerX[1]) / 2.0;
    		//if we take the cameras dimensions and divide by half 160 /2 = 80
    		//70-90 is the deadzone
    		if(trueCenterX > 60 && trueCenterX < 100){
    			complete = true;
    		}
    		else if(trueCenterX < 60){
    	    	lSpeed = .3;
    	    	rSpeed = -.3;
    	    	Time = System.currentTimeMillis();
    		}//If
    		else if(trueCenterX > 100){
    	    	lSpeed = -.3;
    	    	rSpeed = .3;
    	    	Time = System.currentTimeMillis();
    		}
    		Robot.Chassis.Run(lSpeed, rSpeed);
    	}//If
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Time + 3000) < System.currentTimeMillis()){
    		return true;
    	}
    	if(complete){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    protected void interrupted() {
    }
}
