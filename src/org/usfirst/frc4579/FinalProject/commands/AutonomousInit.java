/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.FinalProject.Robot;
import org.usfirst.frc4579.FinalProject.subsystems.Camera;

/**
 *
 * @author bstevens
 */
public class AutonomousInit extends Command {

    Timer timer;
    Command timeDelay;

//    protected synchronized void setInterruptible(boolean interruptible) {
//        super.setInterruptible(interruptible); //To change body of generated methods, choose Tools | Templates.
//    }
    public AutonomousInit() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("......Starting AutonomousInit.");
        Robot.camera.lightOn();
        //delay to allow the horizontal goal indicator to stabilize.
        timer = new Timer();
        timer.start();
        while (timer.get() < 0.20) {
        }
        Robot.camera.ImageAnalysis();
        System.out.println(".......hotGoal is " + Robot.camera.hotGoal);
        Robot.camera.lightOff();
        Robot.camera.SetCameraForOps();
        System.out.println("......Ending AutonomousInit.");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
