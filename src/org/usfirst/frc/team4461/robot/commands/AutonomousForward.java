package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousForward extends CommandGroup {

    public AutonomousForward() {
		addSequential(new AutonomousDelay());
    	addSequential(new voltageMove(6, true));
    }
}
