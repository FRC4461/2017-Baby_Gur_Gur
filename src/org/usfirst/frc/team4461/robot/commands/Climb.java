package org.usfirst.frc.team4461.robot.commands;

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
    	return (!Robot.oi.rightButton4.get() && Robot.RopeClimber.StopAtSurge());
	}

    @Override
    protected void end() {
    	Robot.RopeClimber.Stop();
    }

    @Override
    protected void interrupted() {
    }
}