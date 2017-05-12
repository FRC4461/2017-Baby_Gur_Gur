package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FrontGear extends CommandGroup {

    public FrontGear() {
		addSequential(new AutonomousDelay());
    	addSequential(new voltageMove(1.25, true));
    	addSequential(new Vision());
    	addSequential(new LimitSwitch());
    	addSequential(new voltageMove(3, false));
    	addSequential(new AutonomousTurn(1, true));
    	addSequential(new voltageMove(4, true));
    	addSequential(new AutonomousTurn(1, false));
    	addSequential(new voltageMove(10, true));
    }
}
