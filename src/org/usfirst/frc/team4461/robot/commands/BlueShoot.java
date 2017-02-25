package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueShoot extends CommandGroup {
    public BlueShoot() {
		addSequential(new AutonomousDelay());
    	addSequential(new AutonomousForward(5000, 5000)); //Leave the starting area
    	addSequential(new AutonomousTurnLeft(5000)); //90 degrees
    	addSequential(new AutonomousForward(5000, 5000)); //Move near hopper
    	addSequential(new AutonomousTurnLeft(5000)); //45 degrees
    	addSequential(new Vision()); //Vison center to face boiler
    	addSequential(new AutonomousForward(200, 200)); //Move forward to recenter
    	addSequential(new Vision()); //Vison recentering to face boiler
    	addSequential(new AutonomousForward(5000, 5000)); //Run into Boiler
    	addSequential(new AutonomousShoot(5000)); //Shoot
    	addSequential(new AutonomousBackwards(5000)); //
    	addSequential(new AutonomousTurnLeft(5000)); //45 degrees
    	addSequential(new AutonomousBackwards(5000));
    }
}