package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commands.AutonomousNothing;
import org.usfirst.frc.team4461.robot.commands.AutonomousForward;
import org.usfirst.frc.team4461.robot.commands.BlueGear;
import org.usfirst.frc.team4461.robot.commands.BlueShoot1;
import org.usfirst.frc.team4461.robot.commands.BlueShoot2;
import org.usfirst.frc.team4461.robot.commands.MovingTapeAutonomous;
import org.usfirst.frc.team4461.robot.commands.RedGear;
import org.usfirst.frc.team4461.robot.commands.RedShoot1;
import org.usfirst.frc.team4461.robot.commands.RedShoot2;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.HopperMotors;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	//Initializing Subsystems
	public static HopperMotors HopperMotors = new HopperMotors();
	public static Chassis Chassis = new Chassis();
	public static OI oi = new OI();
	
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	public static SendableChooser<Integer> timeChooser;

	@Override
	public void robotInit() {
		autoChooser = new SendableChooser<Command>();
		timeChooser = new SendableChooser<Integer>();
		timeChooser.addDefault("0 Secconds", 0);
		timeChooser.addObject("1 Seccond", 1);
		timeChooser.addObject("2 Secconds", 2);
		timeChooser.addObject("3 Secconds", 3);
		timeChooser.addObject("5 Secconds", 5);
		timeChooser.addObject("7 Secconds", 7);
		timeChooser.addObject("10 Secconds", 10);
		autoChooser.addObject("Red Shoot 1", new RedShoot1());
		autoChooser.addObject("Red Shoot 2", new RedShoot2());
		autoChooser.addObject("Blue Shoot 1", new BlueShoot1());
		autoChooser.addObject("Blue Shoot 2", new BlueShoot2());
		autoChooser.addDefault("Nothing", new AutonomousNothing());
		autoChooser.addObject("MovingTape", new MovingTapeAutonomous());
		autoChooser.addObject("Red Gear", new RedGear());
		autoChooser.addObject("Blue Gear", new BlueGear());
		autoChooser.addObject("Autonomous Forward", new AutonomousForward());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		SmartDashboard.putData("Autonomous mode time chooser", timeChooser);
		CameraServer.getInstance().startAutomaticCapture(0);
//		CameraServer.getInstance().startAutomaticCapture(1);
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
		LiveWindow.run();
		Util.timeStamp("ROBOT Test");
	}//End testPeriodic
	
}//End Class