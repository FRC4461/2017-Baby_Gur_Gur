package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XBoxShoot extends Command {

    public XBoxShoot() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	double shooterSpeedOne = .8;
    	double shooterSpeedTwo = .8;
    	Robot.Chassis.shoot(shooterSpeedOne, shooterSpeedTwo);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
