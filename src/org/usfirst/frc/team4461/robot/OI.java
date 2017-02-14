package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commands.HopperShoot;
import org.usfirst.frc.team4461.robot.commands.HopperTake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	//Joysticks
	public static Joystick leftJoystick, 
						   rightJoystick,
						   XBOXController;
	
	
	//Left Joystick Buttons
	public static JoystickButton leftButton1, 
								 leftButton2, 
								 leftButton3, 
								 leftButton4;
				   
	//Right Joystick Buttons
	public static JoystickButton rightButton1, 
								 rightButton2,
								 rightButton3,
								 rightButton4;
	
	
	public OI(){
		Util.timeStamp("Start OI Init.");
		
		leftJoystick = new Joystick(RobotMap.leftJoystick);
		rightJoystick = new Joystick(RobotMap.rightJoystick);
		
		leftButton1 = new JoystickButton(leftJoystick, RobotMap.leftButton1);
		leftButton2 = new JoystickButton(leftJoystick, RobotMap.leftButton2);
		rightButton1 = new JoystickButton(rightJoystick, RobotMap.rightButton1);
		rightButton2 = new JoystickButton(rightJoystick, RobotMap.rightButton2);
		
		rightButton1.toggleWhenPressed(new HopperShoot());
		rightButton2.toggleWhenPressed(new HopperTake());
		
		Util.timeStamp("Complete OI Init.");
	}//End OI
	
	public double lJoyGetY(){
		return leftJoystick.getY();
	}
	
	public double rJoyGetY(){
		return rightJoystick.getY();
	}
}//End Class