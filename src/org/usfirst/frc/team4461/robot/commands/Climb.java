package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {	
	public Climb() {
        requires(Robot.RopeClimber);
    }

    @Override
    protected void initialize() {
    }

    protected void execute() {
    	double cSpeed = OI.rJoyGetZ();
        Robot.RopeClimber.Climb(cSpeed);	
    }

    @Override
    protected boolean isFinished() {
    	if(OI.leftButton1.get()){
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
