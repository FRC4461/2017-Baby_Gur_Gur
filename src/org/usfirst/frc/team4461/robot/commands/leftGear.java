package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class leftGear extends CommandGroup {

    public leftGear() {
		addSequential(new AutonomousDelay());
    	addSequential(new voltageMove(2, true));
    	addSequential(new AutoTurn(.6, true));
    	addSequential(new Vision());
    	addSequential(new LimitSwitch());
    	addSequential(new voltageMove(4, false));
    	addSequential(new AutoTurn(.6, false));
    	addSequential(new voltageMove(10, true));
    }
}
