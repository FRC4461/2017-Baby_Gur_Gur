package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossLineBlue extends CommandGroup {
    public AutonomousCrossLineBlue() {
		addSequential(new AutonomousDelay());
    	addSequential(new AutonomousMove(20));
    	addSequential(new AutonomousTurn(-30));
    	addSequential(new AutonomousMove(30));
    	addSequential(new AutonomousTurn(30));
    	addSequential(new AutonomousMove(166));
    }
}
