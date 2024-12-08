package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ec extends CommandBase {

  private final Elevator elevator;
  private final double targetPosition;
  private final double tolerance = 100; // Acceptable error margin for position

  public ec(Elevator elevator, double targetPosition) {
    this.elevator = elevator;
    this.targetPosition = targetPosition;
    addRequirements(elevator);
  }

  @Override
  public void initialize() {
    // le set fr
    elevator.setElevatorPosition(targetPosition);
  }

  @Override
  public void execute() {
    // Data-ey DO THE LOGGING SMH RAHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
    double currentPosition = elevator.getElevatorPosition();
    System.out.println("Current Encoder Position: " + currentPosition);
  }

  @Override
  public boolean isFinished() {
    // you in toly f*ker
    double currentPosition = elevator.getElevatorPosition();
    return Math.abs(targetPosition - currentPosition) <= tolerance;
  }

  @Override
  public void end(boolean interrupted) {
    elevator.stopElevator();
    if (interrupted) {
      System.out.println("Command interrupted!");
    } else {
      System.out.println("Elevator reached target position: " + elevator.getElevatorPosition());
    }
  }
}
