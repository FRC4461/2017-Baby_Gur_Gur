package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HopperMotors extends Subsystem {
	
	CANTalon hm1 = new CANTalon(RobotMap.hm1);
	CANTalon hm2 = new CANTalon(RobotMap.hm2);
	CANTalon hm3 = new CANTalon(RobotMap.hm3);
	
    public void initDefaultCommand() {
    	System.out.println("4461: Hopper.java");
    }
    
    public void Take(){
    	hm3.set(-.8);
    }
    
    public void Shoot(){
    	System.out.println("4461: Hopper.java");
    	double Speed = .5;
    	hm1.set(Speed);
    	hm2.set(Speed);
}
    
    public void Stop(){
    	hm1.set(0);
    	hm2.set(0);
    	hm3.set(0);
    }
}