package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

  Elevator elevator;
  Joystick joystick;
  public final WPI_TalonSRX motorE = new WPI_TalonSRX(Constants.ElevatorPorts.ElevatorPort);


  /** Creates a new ClimbTeleop. */
  public Elevator(Elevator elevator, Joystick joystick) {
    this.elevator = elevator;
    this.joystick = joystick;
  
  }
  public void ElevatorUp(){
    if(RobotContainer.getJoy().getRawButtonPressed(3)){
     
  
   }
  }
  public void ElevatorDown(){
    if (RobotContainer.getJoy().getRawButtonPressed(4)) {
      
   }
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double yValue = joystick.getY();
 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}