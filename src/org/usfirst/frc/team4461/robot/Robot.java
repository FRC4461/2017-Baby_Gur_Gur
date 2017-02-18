package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

import java.util.Arrays;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4461.robot.commands.BlueGear;
import org.usfirst.frc.team4461.robot.commands.BlueShoot;
import org.usfirst.frc.team4461.robot.commands.CameraTest;
import org.usfirst.frc.team4461.robot.commands.Drive;
import org.usfirst.frc.team4461.robot.commands.RedGear;
import org.usfirst.frc.team4461.robot.commands.RedShoot;
import org.usfirst.frc.team4461.robot.subsystems.AutonomousChassis;
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
	public static Chassis Chassis;
	public static AutonomousChassis AutonomousChassis;
	public static HopperMotors HopperMotors;
	public static OI oi;
	
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;

	@Override
	public void robotInit() {
//		table = NetworkTable.getTable("/GRIP/Contors");
//		NetworkTable.setIPAddress("10.44.61.10");
//		NetworkTable.setTeam(4461);
//		centerX = table.getNumberArray("centerX", defaultValue);
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
	    
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (imgLock) {
	                visionThreadCenterX = r.x + (r.width / 2);
	            }
	        }
	    });
	    visionThread.start();
		
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Red Shoot", new RedShoot());
		autoChooser.addDefault("Blue Shoot", new BlueShoot());
		autoChooser.addDefault("Red Gear", new RedGear());
		autoChooser.addDefault("Blue Gear", new BlueGear());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		HopperMotors = new HopperMotors();
		AutonomousChassis = new AutonomousChassis();
		Chassis = new Chassis();
		oi = new OI();
//		CameraServer.getInstance().startAutomaticCapture(0);
//		CameraServer.getInstance().startAutomaticCapture(1);
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
       
		//addSequential(new CameraTest(0));
		//autoChooser.addDefault("Camera Test", new CameraTest(0));
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
		SmartDashboard.putData("Auto mode", autoChooser);
		//System.out.println(String.valueOf(centerX));
//		for(double x : centerX){
//			System.out.print(String.valueOf(x));
//		}
		Scheduler.getInstance().run();
	}//End teleopPeriodic

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}//End testPeriodic
}//End Class
