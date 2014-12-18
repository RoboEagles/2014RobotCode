/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.FinalProject.Robot;

/**
 *
 * @author bstevens
 */
public class TiltForTruss extends Command {

    public TiltForTruss() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        if (Robot.tiltManual) {
//            Robot.tiltManual = false;
//            Robot.setpoint = -66;
//        } else {
//            Robot.tiltManual = true;
//        }
        Robot.tiltManual= false;
        Robot.setpoint = -66;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Timer.delay(0.01);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.joystickButton10.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
