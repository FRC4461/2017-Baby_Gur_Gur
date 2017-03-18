package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BlueGear extends CommandGroup {

    public BlueGear() {
		addSequential(new AutonomousDelay());
    	addSequential(new Vision());
    	addSequential(new AutonomousMove(10));
    	addSequential(new Vision());
    }
}
