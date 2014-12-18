/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.FinalProject.Robot;

/**
 *
 * @author bstevens
 */
public class ToroDrop extends Command {

    public ToroDrop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //this attempts to give the tilt motor a short burst of high power
        //to get it over the hump if the cam is set past the high point,
        //which sometimes happens when setting manually.
        setTimeout(0.2);
        Robot.elevator.drop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
