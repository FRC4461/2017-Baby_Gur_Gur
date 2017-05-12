package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightGear extends CommandGroup {

    public RightGear() {
		addSequential(new AutonomousDelay());
    	addSequential(new voltageMove(2, true));
    	addSequential(new AutonomousTurn(.6, false));
    	addSequential(new Vision());
    	addSequential(new LimitSwitch());
    	addSequential(new voltageMove(4, false));
    	addSequential(new AutonomousTurn(.6, true));
    	addSequential(new voltageMove(10, true));
    }
}
