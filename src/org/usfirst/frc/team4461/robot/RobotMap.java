package org.usfirst.frc.team4461.robot;

public class RobotMap {
	public static int //This is what applies to all of them.
	
	//Drivebase Motors
	m1 = 1,
	m2 = 2,
	m3 = 3,
	m4 = 4,
	m5 = 5,
	m6 = 6,
	
	//Hopper Motors
	hm1 = 7,
	hm2 = 8,
	hm3 = 9,
	
	//Encoder
	Encoder1_A = 10,
	Encoder1_B = 11,
	
	//Joysticks
	lJoy = 0,
	rJoy = 1,
	
	//Left Joystick Buttons
	lb1 = 1,
	lb2 = 2,
	lb3 = 3,
	lb4 = 4,
	
	//Right Joystick Button
	rb1 = 1,
	rb2 = 2,
	rb3 = 3,
	rb4 = 4,
	
	//Chassis Encoders
	ChassisEncoder1 = 1,
	ChassisEncoder2 = 2,
	ChassisEncoder3 = 3,
	ChassisEncoder4 = 4,
	ChassisEncoder5 = 5,
	ChassisEncoder6 = 6;	// LAST ONE HAS TO BE ;

	public RobotMap(){
		Util.timeStamp("RobotMap Init");
	}
}
