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
public class ElevatorInitSwitch extends Command {

    public ElevatorInitSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("......Starting ElevatorInitSwitch.");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!Robot.elevator.getLimit()) {
            Robot.elevator.angleUp();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.elevator.stop();
        System.out.println("......Ending ElevatorInitSwitch.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
