package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {
	
	//Initializing Talon
	CANTalon Climber;

	public RopeClimber(){
		Climber = new CANTalon(RobotMap.CANTalon8);
	}
	
    public void initDefaultCommand() {
    	System.out.println("4461: Rope Climber.java");
    }//End Default Command
    
    public void Climb(double cSpeed){
    	Climber.set(-cSpeed);
    }//End Climb
    
    public void Stop(){
    	Climber.set(0);
    }//End Stop

}//End Class