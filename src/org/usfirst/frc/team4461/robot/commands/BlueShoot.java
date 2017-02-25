package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BlueShoot extends CommandGroup {
    public BlueShoot() {
		addSequential(new AutonomousDelay());
    	addSequential(new AutonomousMove(30)); //Leave the starting area
    	addSequential(new AutonomousTurn(90)); //90 degrees
    	addSequential(new AutonomousMove(30)); //Move near hopper
    	addSequential(new AutonomousTurn(45)); //45 degrees
    	addSequential(new Vision()); //Vison center to face boiler
    	addSequential(new AutonomousMove(30)); //Move forward to recenter
    	addSequential(new Vision()); //Vison recentering to face boiler
    	addSequential(new AutonomousMove(30)); //Run into Boiler
    	addSequential(new AutonomousShoot(30)); //Shoot
    	addSequential(new AutonomousMove(30)); //
    	addSequential(new AutonomousTurn(45)); //45 degrees
    	addSequential(new AutonomousMove(30));
    }
}