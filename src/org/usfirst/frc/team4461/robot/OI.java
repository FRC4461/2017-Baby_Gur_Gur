package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commands.Hopper;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	//Joysticks
	public static Joystick lJoy, rJoy;
	
	//Left Joystick Buttons
	JoystickButton lb1, lb2, lb3, lb4;
				   
	//Right Joystick Buttons
	public static JoystickButton rb1, rb2, rb3, rb4;
	
	public OI(){
		System.out.println("4461: Start OI Init.");
		lJoy = new Joystick(RobotMap.lJoy);
		rJoy = new Joystick(RobotMap.rJoy);
		lb1 = new JoystickButton(lJoy, RobotMap.lb1);
		rb2 = new JoystickButton(rJoy, RobotMap.rb2);
		rb1 = new JoystickButton(rJoy, RobotMap.rb1);
		System.out.println("4461: Complete OI Init.");
		
		rb2.toggleWhenPressed(new Hopper());
		rb1.toggleWhenPressed(new Hopper());
	}
	
	public double lJoyGetY(){
		return lJoy.getY();
	}
	
	public double rJoyGetY(){
		return rJoy.getY();
	}
}