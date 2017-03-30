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
    		Util.timeStamp("if 2");
    		//if we take the cameras dimensions and divide by half 160 /2 = 80
    		//70-90 is the deadzone
    		if(trueCenterX > 75 && trueCenterX < 85){
    			complete = true;
        		Util.timeStamp("CENTERED");
    		}
    		else if(trueCenterX < 76){
    	    	lSpeed = -.165;
    	    	rSpeed = .165;
    	    	Time = System.currentTimeMillis();
        		Util.timeStamp("LEFT");
    		}//If
    		else if(trueCenterX > 86){
    	    	lSpeed = .165;
    	    	rSpeed = -.165;
        		Util.timeStamp("RIGHT");
    		}
    		Robot.Chassis.Run(lSpeed, rSpeed);
    	}//If
    	
    	if(centerX.length == 1){
    		double true1CenterX = centerX[0];
    		if(true1CenterX < 37.5){
    	    	lSpeed = -.165;
    	    	rSpeed = .165;
    	    	Time = System.currentTimeMillis();
        		Util.timeStamp("1 LEFT");
    		}//If
    		else if(true1CenterX > 122.5){
    	    	lSpeed = .165;
    	    	rSpeed = -.165;
    	    	Time = System.currentTimeMillis();
        		Util.timeStamp("1 RIGHT");
    		}//Else If
    		Robot.Chassis.Run(lSpeed, rSpeed);
    	}//IF
    	if(centerX.length == 0){
	    	lSpeed = 0;
	    	rSpeed = 0;
    		Robot.Chassis.Run(lSpeed, rSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Time + 5000) < System.currentTimeMillis()){
    		return true;
    	}
    	if(complete){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Util.timeStamp("Vision End");
    }

    protected void interrupted() {
    }
}
