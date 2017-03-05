package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousRedForward extends CommandGroup {

    public AutonomousRedForward() {
		addSequential(new AutonomousDelay());
        addSequential(new AutonomousMove(215));
    }
}
