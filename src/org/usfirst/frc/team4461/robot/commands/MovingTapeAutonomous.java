package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class MovingTapeAutonomous extends Command {
	private static NetworkTable table;
	double averagedHeight1 = 0;
	double averagedHeight = 0;
	double trueCenterX1 = 0;
	double trueCenterX = 0;
	final double realHeight = 5;
	final double focalPoint = 180; 
	
	boolean codeComplete = false;
	
    public MovingTapeAutonomous() {
        requires(Robot.Chassis);
    }

    protected void initialize() {
		table = NetworkTable.getTable("/GRIP/Contors");
    }

    protected void execute() {
		double[] defaultValue = new double[0];
		double[] trueHeight = table.getNumberArray("height", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
    	trueCenterX = (centerX[0] + centerX[1]) / 2;
		averagedHeight = (trueHeight[0] + trueHeight[1]) / 2;
		double Distance = (focalPoint*realHeight) / averagedHeight;
		
		
    	if(centerX.length == 2 && trueHeight.length == 2){ //If you get 2 array values
		if(trueCenterX > 60 && trueCenterX < 100){ //If its centered
			if(Distance > 18){ //If further then this distance
				double speedForward = .01 * Distance + .1;
				double rightWheelFix = speedForward / .75;
				double leftWheelFix = speedForward / 1;
				
				Robot.Chassis.Run(leftWheelFix, rightWheelFix);
			} 
			else if(Distance < 18){//If within this distance
				Robot.Chassis.Run(0,0);
				codeComplete = true;
			}
		}
		else if(trueCenterX < 50){// if its to the left
			double leftOffset = 60 - trueCenterX;
			double speedTurn = .005 * leftOffset + .2;
			double rightWheelFix = speedTurn / .75;
			double leftWheelFix = speedTurn / 1;
			Robot.Chassis.Run(leftWheelFix, -rightWheelFix);
		}
		else if(trueCenterX > 110){
			double leftOffset = trueCenterX - 100;
			double speedTurn = .005 * leftOffset + .2;
			double rightWheelFix = speedTurn / .75;
			double leftWheelFix = speedTurn / 1;
			Robot.Chassis.Run(-leftWheelFix, rightWheelFix);
		}
    }

    	if(centerX.length == 1 && trueHeight.length == 1){
        	trueCenterX1 = centerX[0];
        	averagedHeight1 = trueHeight[0];
    		double Distance1 = (focalPoint*realHeight) / averagedHeight;
    		if(trueCenterX1 > 60 && trueCenterX1 < 100){
    			if(Distance1 > 18){
    				double speedForward = .01 * Distance1 + .1;
    				Robot.Chassis.Run(speedForward, speedForward);
    			} 
    			else if(Distance < 18){//If within this distance
    				Robot.Chassis.Run(0,0);
    				codeComplete = true;
    			}
    		}
    		if(trueCenterX < 50){
    			double leftOffset = 60 - trueCenterX;
    			double speedTurn = .005 * leftOffset + .2;
    			double rightWheelFix = speedTurn / .75;
    			double leftWheelFix = speedTurn / 1;
    			Robot.Chassis.Run(leftWheelFix, -rightWheelFix);
    		}
    		
    		else if(trueCenterX > 110){
    			double leftOffset = trueCenterX - 100;
    			double speedTurn = .005 * leftOffset + .2;
    			double rightWheelFix = speedTurn / .75;
    			double leftWheelFix = speedTurn / 1;
    			Robot.Chassis.Run(-leftWheelFix, rightWheelFix);
    		}
    	}
   }

    protected boolean isFinished() {
    	if(codeComplete){
    		return true;
    	}
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
