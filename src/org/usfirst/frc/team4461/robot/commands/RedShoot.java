package org.usfirst.frc.team4461.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RedShoot extends CommandGroup {

    public RedShoot() {
    	addSequential(new AutonomousDelay());
    	addSequential(new AutonomousMove(30));
    	addSequential(new AutonomousTurn(30));
    	addSequential(new AutonomousMove(30));
    	addSequential(new AutonomousTurn(90));
    	addSequential(new AutonomousShoot(90));
    	addSequential(new AutonomousTurn(90));
    	addSequential(new AutonomousMove(30));
    }
}
