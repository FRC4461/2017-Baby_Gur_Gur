package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;


public class Drive extends Command {
	public Drive() {
		requires(Robot.Chassis);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
    	double lSpeed = OI.lJoy.getY();
    	double rSpeed = OI.rJoy.getY();
		Robot.Chassis.Run(lSpeed, rSpeed);
	}

	@Override
	protected boolean isFinished(){
		return false;
	}

	@Override
	protected void end() {
		Robot.Chassis.Stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}