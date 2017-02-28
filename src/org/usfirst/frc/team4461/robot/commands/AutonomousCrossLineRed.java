package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossLineRed extends CommandGroup {
    public AutonomousCrossLineRed() {
    	addSequential(new AutonomousMove(30));
    	addSequential(new AutonomousTurn(30));
    	addSequential(new AutonomousMove(10));
    	addSequential(new AutonomousTurn(-30));
    	addSequential(new AutonomousMove(120));
    }
}
