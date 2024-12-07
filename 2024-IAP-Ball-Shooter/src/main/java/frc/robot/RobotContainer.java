// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.BeamBreak;
import frc.robot.subsystems.Elevator;
public class RobotContainer {
  public BeamBreak beambreak = new BeamBreak();
  private final Elevator elevator = new Elevator(joy);
  //private final BallShooter shooter = new BallShooter();
  private final static Joystick joy = new Joystick(0);
  public RobotContainer() {
    configureBindings();
    DataLogManager.start();
    DriverStation.startDataLog(DataLogManager.getLog());
  }

  private void configureBindings() {}

  public static Joystick getJoy() {
    return joy;
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}