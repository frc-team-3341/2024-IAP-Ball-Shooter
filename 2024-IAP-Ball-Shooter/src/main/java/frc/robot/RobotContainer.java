// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ShooterCommands;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.BeamBreak;

public class RobotContainer {
  public BeamBreak beambreak = new BeamBreak();
  private final BallShooter m_shooter = new BallShooter();
  private final static CommandJoystick  m_joy = new CommandJoystick (0);
  private final static CommandXboxController  m_controller = new CommandXboxController(1);

  private final static ShooterCommands command = new ShooterCommands(10);

  DigitalInput limitSwitch = new DigitalInput(3); // Limit switch on DIO 3
  Trigger exampleTrigger = new Trigger(limitSwitch::get);
  public RobotContainer() {
    configureBindings();
    DataLogManager.start();
    DriverStation.startDataLog(DataLogManager.getLog());
  }

  private void configureBindings() {
    if (m_controller != null) {
      m_controller.x().onTrue(m_shooter.stopMotors());
      m_controller.a().onTrue(m_shooter.setFeedWheelSpeed(0.9));
      m_controller.b().onTrue(m_shooter.setFlyWheelSpeed(50));
    }
    if (m_joy != null) {
      m_joy.button(2).onTrue(m_shooter.stopMotors());
      m_joy.button(1).onTrue(m_shooter.setFeedWheelSpeed(0.9));
      m_joy.button(4).onTrue(m_shooter.setFlyWheelSpeed(50));
    }

    
  }

  public Command getAutonomousCommand() {
    return command;
    //return Commands.print("No autonomous command configured");
  }
}
