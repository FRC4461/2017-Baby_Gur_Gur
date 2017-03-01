package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team4461.robot.commands.BlueGear;
import org.usfirst.frc.team4461.robot.commands.BlueShoot1;
import org.usfirst.frc.team4461.robot.commands.BlueShoot2;
import org.usfirst.frc.team4461.robot.commands.RedGear;
import org.usfirst.frc.team4461.robot.commands.RedShoot1;
import org.usfirst.frc.team4461.robot.commands.RedShoot2;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.HopperMotors;

public class Robot extends IterativeRobot {

//	private NetworkTable table;	
//	private double[] centerX;
//	private double[] defaultValue = new double[0];
	
	//GRIP
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	
	public VisionThread visionThread;
	public static double visionThreadCenterX = 0.0;
	
	public static Object imgLock = new Object();
	
	//Initializing Subsystems
	public static Chassis Chassis = new Chassis();
	public static HopperMotors HopperMotors = new HopperMotors();
	public static OI oi = new OI();
	
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	public static SendableChooser<Integer> timeChooser;

	@Override
	public void robotInit() {
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		autoChooser = new SendableChooser<Command>();
		timeChooser = new SendableChooser<Integer>();
		timeChooser.addDefault("0 Secconds", 0);
		timeChooser.addObject("1 Secconds", 1);
		timeChooser.addObject("2 Secconds", 2);
		timeChooser.addObject("3 Secconds", 3);
		timeChooser.addObject("5 Secconds", 5);
		timeChooser.addObject("7 Secconds", 7);
		timeChooser.addObject("10 Secconds", 10);
		autoChooser.addDefault("Red Shoot 1", new RedShoot1());
		autoChooser.addObject("Red Shoot 2", new RedShoot2());
		autoChooser.addObject("Blue Shoot 1", new BlueShoot1());
		autoChooser.addObject("Blue Shoot 2", new BlueShoot2());
		autoChooser.addObject("Red Gear", new RedGear());
		autoChooser.addObject("Blue Gear", new BlueGear());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		SmartDashboard.putData("Autonomous mode time chooser", timeChooser);
//		CameraServer.getInstance().startAutomaticCapture(0);
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
		//Util.timeStamp("ROBOT autonomousPeriodic");
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
		Util.timeStamp("ROBOT teleopPeriodic");
	}//End teleopPeriodic

	@Override
	public void testPeriodic() {
		LiveWindow.run();
		Util.timeStamp("ROBOT Test");
	}//End testPeriodic
}//End Class
