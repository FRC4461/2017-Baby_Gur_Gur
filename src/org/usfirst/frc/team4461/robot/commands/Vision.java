package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;

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
		table = NetworkTable.getTable("/GRIP/Contors");
		Time = System.currentTimeMillis();
    }

    protected void execute() {
		double[] defaultValue = new double[0];
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double trueCenterX = (centerX[0] + centerX[1]) / 2.0;
    	double lSpeed = 0;
    	double rSpeed = 0;
    	if(centerX.length == 2){
    		//if we take the cameras dimensions and divide by half 360 /2 = 160
    		//155 is the left deadzone
    		if(trueCenterX < 150){
    	    	lSpeed = -1;
    	    	rSpeed = 1;
    	    	Time = System.currentTimeMillis();
    		}//If
    		else if(trueCenterX > 170){
    	    	lSpeed = -1;
    	    	rSpeed = 1;
    	    	Time = System.currentTimeMillis();
    		}//Else If
    		Robot.Chassis.Run(lSpeed, rSpeed);
    	}//If
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Time + 3000) > System.currentTimeMillis()){
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
