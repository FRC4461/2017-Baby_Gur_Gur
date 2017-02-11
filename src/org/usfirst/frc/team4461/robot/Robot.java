package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4461.robot.commands.Autonomous;
import org.usfirst.frc.team4461.robot.commands.Drive;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.HopperMotors;

public class Robot extends IterativeRobot {

	public static Chassis Chassis;
	public static HopperMotors HopperMotors;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
//		chooser.addDefault("Starting 1", new Autonomous());
		HopperMotors = new HopperMotors();
		Chassis = new Chassis();
		oi = new OI();
		Util.timeStamp("Robot robotInit.");
	}

	@Override
	public void disabledInit() {
		Util.timeStamp("Robot disabled.");
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = new Autonomous();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		chooser.addDefault("Default Drive Command", new Drive());
		SmartDashboard.putData("Auto mode", chooser);
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
