/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.FinalProject.Robot;

/**
 *
 * @author bstevens
 */
public class ElevatorInitManual extends Command {

    public ElevatorInitManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.elevator);
        this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("......Starting ElevatorInitManual.");
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Use Left Joystick button 6 to raise the cam.");
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "Use Left Joystick button 7 to lower the cam.");
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "Disable TeleOp when finished.");
        //DriverStationLCD.getInstance().updateLCD();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.oi.joystickButton6.get() || Robot.oi.drivestickButton8.get()) {
            Robot.elevator.angleUp();
        } else if (Robot.oi.joystickButton7.get() || Robot.oi.drivestickButton10.get()) {
            Robot.elevator.angleDown();
        } else {
            Robot.elevator.stop();
            Robot.elevator.encoderInit();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(Robot.oi.joystickButton6.get() ||
                 Robot.oi.drivestickButton8.get() ||
                 Robot.oi.joystickButton7.get() ||
                 Robot.oi.drivestickButton10.get());
    }

    // Called once after isFinished returns true
    protected void end() {
        Timer.delay(.1);
        Robot.elevator.encoderInit();
        System.out.println("......Ending ElevatorInitManual.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
