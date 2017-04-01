package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commands.Climb;
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
								 rightButton4,
								 rightButton5;
	
	
	
	public OI(){
		leftJoystick = new Joystick(RobotMap.leftJoystick);
		rightJoystick = new Joystick(RobotMap.rightJoystick);
		
		leftButton1 = new JoystickButton(leftJoystick, RobotMap.leftButton1);
		leftButton2 = new JoystickButton(leftJoystick, RobotMap.leftButton2);
		rightButton1 = new JoystickButton(rightJoystick, RobotMap.rightButton1);
		rightButton2 = new JoystickButton(rightJoystick, RobotMap.rightButton2);
		rightButton3 = new JoystickButton(rightJoystick, RobotMap.rightButton3);
		rightButton4 = new JoystickButton(rightJoystick, RobotMap.rightButton4);
		rightButton5 = new JoystickButton(rightJoystick, RobotMap.rightButton5);
		
		rightButton1.toggleWhenPressed(new HopperTake());
		rightButton2.toggleWhenPressed(new HopperShoot());
		Climb ClimbAction = new Climb();
		rightButton3.whenPressed(ClimbAction);
		leftButton1.cancelWhenPressed(ClimbAction);
		
		Util.timeStamp("OI INITIALIZED");
	}//End OI
	
	public static double lJoyGetY(){
		double lSpeed = -leftJoystick.getY();
		if(lSpeed > -.05 && lSpeed < .05){
		return 0;
		}
		return lSpeed;
	}
	
	public static double rJoyGetY(){
		double rSpeed = -rightJoystick.getY();
		if(rSpeed > -.05 && rSpeed < .05){
		return 0;
		}
		return rSpeed;
	}
}//End Class