package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.Hopper;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HopperMotors extends Subsystem {

//	CANTalon hm1 = new CANTalon(RobotMap.hm1);
//	CANTalon hm2 = new CANTalon(RobotMap.hm2);
//	CANTalon hm3 = new CANTalon(RobotMap.hm3);
	CANTalon m1 = new CANTalon(RobotMap.m1);
	CANTalon m2 = new CANTalon(RobotMap.m2);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Hopper());
    	System.out.println("4461: Hopper.java");
    }
    
    public void Take(){
    if(OI.rb2.get()){
    	m1.set(-.8);
    	}
    else{
    	m1.set(0);
    	}
    }
    
    public void Shoot(){
    if(OI.rb1.get()){
    	m2.set(.6);
    	}
    else{
    	m2.set(0);
    	}
    }
    
    public void Stop(){
    	m1.set(0);
    	m2.set(0);
    }
}



