package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class MovingTapeAutonomous extends Command {

	private static NetworkTable table;
	double averagedHeight = 0;
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

    	if(centerX.length == 2 && trueHeight.length == 2){
    	trueCenterX = (centerX[0] + centerX[1]) / 2;
		averagedHeight = (trueHeight[0] + trueHeight[1]) / 2;
		double Distance = (focalPoint*realHeight) / averagedHeight;
		
		if(trueCenterX > 70 && trueCenterX < 90){
			if(Distance > 12){
				double speedForward = .01 * Distance + .1;
				Robot.Chassis.Run(speedForward, speedForward);
			} 
			else{
				codeComplete = true;
			}
		}
		else if(trueCenterX < 70){
			double leftOffset = 70 - trueCenterX;
			double speedTurn = .005 * leftOffset + .2;
			Robot.Chassis.Run(speedTurn, -speedTurn);
		}
		else if(trueCenterX > 90){
			double leftOffset = trueCenterX - 90;
			double speedTurn = .005 * leftOffset + .2;
			Robot.Chassis.Run(-speedTurn, speedTurn);
		}
    }

    	if(centerX.length == 1 && trueHeight.length == 1){
        	trueCenterX = centerX[0];
        	averagedHeight = trueHeight[0];
        	
    		if(trueCenterX < 60){
    			double leftOffset = 60 - trueCenterX;
    			double speedTurn = .005 * leftOffset + .2;
    			Robot.Chassis.Run(speedTurn, -speedTurn);
    		}
    		
    		else if(trueCenterX > 100){
    			double leftOffset = trueCenterX - 100;
    			double speedTurn = .005 * leftOffset + .2;
    			Robot.Chassis.Run(-speedTurn, speedTurn);
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
