/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4579.FinalProject.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author bstevens
 */
public class DropToroCG extends CommandGroup {

    public DropToroCG() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new ToroDrop());
        addSequential(new ToroShootAngle());
    }
}
