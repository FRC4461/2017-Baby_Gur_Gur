package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedShoot extends CommandGroup {

    public RedShoot() {
		Util.timeStamp("Autonomous >>>Start Red Shoot<<<");
    	addSequential(new AutonomousForward(5000));
		Util.timeStamp("Autonomous >>>Forward<<<");
    	addSequential(new AutonomousTurnRight(5000));
		Util.timeStamp("Autonomous >>>Turn Right<<<");
    	addSequential(new AutonomousForward(5000));
		Util.timeStamp("Autonomous >>>Forward<<<");
    	addSequential(new AutonomousTurnRight(5000));
		Util.timeStamp("Autonomous >>>Turn Right<<<");
    	addSequential(new AutonomousShoot(5000));
		Util.timeStamp("Autonomous >>>Shoot<<<");
    	addSequential(new AutonomousTurnRight(5000));
		Util.timeStamp("Autonomous >>>Turn Right<<<");
    	addSequential(new AutonomousBackwards(5000));
		Util.timeStamp("Autonomous >>>Backwards<<<");
    }
}
