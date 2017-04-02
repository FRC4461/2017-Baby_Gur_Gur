package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commands.AutonomousNothing;
import org.usfirst.frc.team4461.robot.commands.AutonomousForward;
import org.usfirst.frc.team4461.robot.commands.leftGear;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	//Initializing Subsystems
	public static RopeClimber RopeClimber = new RopeClimber();
	public static Chassis Chassis = new Chassis();
	public static OI oi = new OI();
	
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	public static SendableChooser<Integer> timeChooser;

	@Override
	public void robotInit() {
		autoChooser = new SendableChooser<Command>();
		timeChooser = new SendableChooser<Integer>();
		timeChooser.addDefault("0 Seconds", 0);
		timeChooser.addObject("1 Second", 1);
		timeChooser.addObject("5 Seconds", 5);
		timeChooser.addObject("10 Seconds", 10);
		autoChooser.addDefault("Nothing", new AutonomousNothing());
		autoChooser.addObject("Left Gear", new leftGear());
		autoChooser.addObject("Autonomous Forward", new AutonomousForward());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		SmartDashboard.putData("Autonomous mode time chooser", timeChooser);
		CameraServer.getInstance().startAutomaticCapture(0);
		Util.timeStamp("ROBOT robotInit");
	}//End robotInit

	@Override
	public void disabledInit() {
		Util.timeStamp("ROBOT disabledPeriodic");
	}//End disabledInit

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}//End disabledPeriodic

	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		Util.timeStamp("ROBOT autonomousInit");
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
		Util.timeStamp("ROBOT teleopInit");
	}//End teleopInit

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Util.timeStamp("Left Encoder Value"+Robot.Chassis.leftEncoderGet());
		Util.timeStamp("Right Encoder Value"+Robot.Chassis.rightEncoderGet());
	}//End teleopPeriodic

	@Override
	public void testPeriodic() {
		System.out.print(Robot.Chassis.limitSwitchFeedback());
		Util.timeStamp("ROBOT Test");
	}//End testPeriodic
	
}//End Class