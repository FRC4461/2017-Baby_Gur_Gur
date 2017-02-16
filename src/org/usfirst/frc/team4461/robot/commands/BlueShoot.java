package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Util;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueShoot extends CommandGroup {
    public BlueShoot() {
		Util.timeStamp("Autonomous >>>Start Blue Shoot<<<");
    	addSequential(new AutonomousForward(5000));
		Util.timeStamp("Autonomous >>>Forward<<<");
    	addSequential(new AutonomousTurnLeft(5000));
		Util.timeStamp("Autonomous >>>Turn Left<<<");
    	addSequential(new AutonomousForward(5000));
		Util.timeStamp("Autonomous >>>Forward<<<");
    	addSequential(new AutonomousTurnLeft(5000));
		Util.timeStamp("Autonomous >>>Turn Left<<<");
    	addSequential(new AutonomousBackwards(5000));
		Util.timeStamp("Autonomous >>>Shoot<<<");
    	addSequential(new AutonomousShoot(5000));
		Util.timeStamp("Autonomous >>>Turn Left<<<");
    	addSequential(new AutonomousBackwards(5000));
		Util.timeStamp("Autonomous >>>Backwards<<<");
    }
}