package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.Command;


public class Climb extends Command {	
	public Climb() {
        requires(Robot.RopeClimber);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.RopeClimber.Climb();	
    	Util.timeStamp("Climber Current" + Robot.RopeClimber.GetCurrent());
    	Util.timeStamp("Climber Voltage" +  Robot.RopeClimber.GetVoltage());
    	Util.timeStamp("Climber Wattage" + Robot.RopeClimber.GetWatts());
    }

    @Override
    protected boolean isFinished() {
    	if(OI.leftButton1.get()){
    		return true;
    	}
    	else if(!OI.rightButton4.get() && Robot.RopeClimber.StopAtSurge()){
    		return true;
    	}
    	return false;
	}

    @Override
    protected void end() {
    	Robot.RopeClimber.Stop();
    }

    @Override
    protected void interrupted() {
    }
}
