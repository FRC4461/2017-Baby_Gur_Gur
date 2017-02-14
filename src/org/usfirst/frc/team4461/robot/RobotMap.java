package org.usfirst.frc.team4461.robot;

public class RobotMap {
	
	/**
	 * Public static final int
	 * RobotMap
	 */
	public static final int
	
	//Drivebase Motors
	CANTalon1 = 1,
	CANTalon2 = 2,
	CANTalon3 = 3,
	CANTalon4 = 4,
	CANTalon5 = 5,
	CANTalon6 = 6,
	
	//Hopper Motors
	CANTalon7 = 7,
	CANTalon8 = 8,
	CANTalon9 = 9,
	
	//Joysticks
	leftJoystick = 0,
	rightJoystick = 1,
	
	//Left Joystick Buttons
	leftButton1 = 1,
	leftButton2 = 2,
	leftButton3 = 3,
	leftButton4 = 4,
	
	//Right Joystick Button
	rightButton1 = 1,
	rightButton2 = 2,
	rightButton3 = 3,
	rightButton4 = 4;// LAST ONE HAS TO BE ;

	public RobotMap(){
		Util.timeStamp("RobotMap Init");
	}//End RobotMap
	
}//End Class
