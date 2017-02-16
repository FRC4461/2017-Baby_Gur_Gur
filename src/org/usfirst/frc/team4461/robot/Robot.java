package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team4461.robot.commands.BlueShoot;
import org.usfirst.frc.team4461.robot.commands.Drive;
import org.usfirst.frc.team4461.robot.commands.RedShoot;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.HopperMotors;

public class Robot extends IterativeRobot {

	public static Chassis Chassis;
	public static HopperMotors HopperMotors;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser;

	@Override
	public void robotInit() {
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Red Shoot", new RedShoot());
		autoChooser.addDefault("Blue Shoot", new BlueShoot());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		HopperMotors = new HopperMotors();
		Chassis = new Chassis();
		oi = new OI();
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
				
		Util.timeStamp("Robot robotInit.");
	}//End robotInit

	@Override
	public void disabledInit() {
		Util.timeStamp("Robot disabled.");
	}//End disabledInit

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}//End disabledPeriodic

	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}//End autonomousInit
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}//End autonomousPeriodic

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}//End If
		
	}//End teleopInit

	@Override
	public void teleopPeriodic() {
		autoChooser.addDefault("Tank Drive", new Drive());
		SmartDashboard.putData("Auto mode", autoChooser);
		Scheduler.getInstance().run();
	}//End teleopPeriodic

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}//End testPeriodic
}//End Class
