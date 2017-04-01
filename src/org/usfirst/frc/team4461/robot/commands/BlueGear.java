package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BlueGear extends CommandGroup {

    public BlueGear() {
		addSequential(new AutonomousDelay());
    	addSequential(new voltageMove(5, true));
    	addSequential(new Vision());
    	addSequential(new voltageMove(.2,true));
    	addSequential(new Vision());
    	addSequential(new voltageMove(10, true));
    	addSequential(new voltageMove(3, false));
    	addSequential(new AutoTurn(true));
    	addSequential(new voltageMove(5, true));
    }
}
