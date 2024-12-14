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
    System.out.println("Initializing EC Command...");
    System.out.println("Target Position: " + targetPosition);
    elevator.move(0);

  }

  @Override
  public void execute() {
    elevator.move(1);

    double currentPosition = elevator.getElevatorPosition();
  
    System.out.println("Current Encoder Position: " + currentPosition);
    System.out.println("Error: " + (targetPosition - currentPosition));
  }

  @Override
  public boolean isFinished() {
    if (elevator.getElevatorPosition() >= targetPosition){
      return true;
    }
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    elevator.stopElevator();
    if (interrupted) {
      System.out.println("Command interrupted!");
    } else {
      System.out.println("Elevator reached target position: " + elevator.getElevatorPosition());
    }
    System.out.println("EC Command ended.");
  }
}
