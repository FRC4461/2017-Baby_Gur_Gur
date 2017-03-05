package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousBlueForward extends CommandGroup {

    public AutonomousBlueForward() {
		addSequential(new AutonomousDelay());
    	addSequential(new AutonomousMove(215));
    }
}
