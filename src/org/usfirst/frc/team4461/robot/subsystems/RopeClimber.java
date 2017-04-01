package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {
	
	//Initializing Talon
	CANTalon Climber;
	
	//Electricity
	double WattageSurge = 600;
	
	public RopeClimber(){
		Climber = new CANTalon(RobotMap.CANTalon7);
	}
	
    public void initDefaultCommand() {
    	System.out.println("4461: Rope Climber.java");
    }//End Default Command
    
    public void Climb(){
    	double Speed = -.8;
    	Climber.set(Speed);
    }//End Climb
    
    public void Stop(){
    	Climber.set(0);
    }//End Stop
    
    public double GetCurrent(){
     	return Climber.getOutputCurrent();
    }

    public double GetVoltage(){
     	return Climber.getOutputVoltage();
    }

    public double GetWatts(){
     	return GetCurrent() * GetVoltage();
    }
    
    public boolean StopAtSurge(){
    	return (GetWatts() >= WattageSurge);
    }
}//End Class