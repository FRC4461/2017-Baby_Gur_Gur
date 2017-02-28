package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HopperMotors extends Subsystem {
	
	//Initializing Talons
	CANTalon Shooter;
	CANTalon Shooter2;
	CANTalon Intake;
	
	public HopperMotors(){
		Shooter = new CANTalon(RobotMap.CANTalon7);
		Shooter2 = new CANTalon(RobotMap.CANTalon8);
		Intake = new CANTalon(RobotMap.CANTalon9);
	}
	
    public void initDefaultCommand() {
    	System.out.println("4461: Hopper.java");
    }//End Default Command
    
    public void Take(){
    	Intake.set(-.8);
    }//End Take
    
    public void Shoot(){
    	System.out.println("4461: Hopper.java");
    	double Speed = .5;
    	Shooter.set(Speed);
    	Shooter2.set(Speed);
    }//End Shoot
    
    public void Stop(){
    	Shooter.set(0);
    	Shooter2.set(0);
    	Intake.set(0);
    }//End Stop
    
}//End Class