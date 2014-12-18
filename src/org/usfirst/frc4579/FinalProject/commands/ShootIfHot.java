/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.FinalProject.Robot;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author bstevens
 */
public class ShootIfHot extends Command {

    DriverStationLCD lcd;

    public ShootIfHot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lcd = DriverStationLCD.getInstance();
        lcd.println(DriverStationLCD.Line.kUser5, 1, "Shooting.");
        System.out.println("......Starting ShootIfHot.");
//        if (Robot.camera.hotGoal == false) {
//            System.out.println(".......Waiting for Hot Goal to activate.");
//            double delay = 5.0 - DriverStation.getInstance().getMatchTime();
//            Timer.delay(Math.max(.02, delay);
//        }
        System.out.println(".......Shooting!");
        Robot.shooter.shoot();
        setTimeout(0.53);
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
        Robot.shooter.stop();
        System.out.println("......Ending ShootIfHot.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
