package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Elevator;
import frc.robot.RobotContainer;
import frc.robot.Constants;



public class Elevator extends SubsystemBase {

  public final WPI_TalonSRX motorE = new WPI_TalonSRX(Constants.ElevatorPorts.ElevatorPort);
    Joystick joystick;


  /** Creates a new ClimbTeleop. */
  public Elevator(Joystick joystick) {
    this.joystick = joystick;
  }



  public void ElevatorUp(){
    if(joystick.getY() > 0.1 ){
        motorE.set(0.5);
  
   }
  }


  public void ElevatorDown(){
    if(joystick.getY() < -0.1) {
       motorE.set(-0.5);
   }
  }
  // Called when the command is initially scheduled.
  @Override
  public void periodic(){
    if(motorE.getSensorCollection().isFwdLimitSwitchClosed()== true){
        motorE.set(0);
    }
    if(motorE.getSensorCollection().isRevLimitSwitchClosed()== true){
        motorE.set(0);
    }
    double val = joystick.getY();
    if(joystick.getY() > 0.1 ){
        motorE.set(0.5);
  
   }
    if(joystick.getY() < -0.1 ){
        motorE.set(-0.5);
  
   }


    if(joystick.getRawButtonPressed(0)) {
         motorE.set(0);
  }
  SmartDashboard.putBoolean("Forward limit switch value", motorE.getSensorCollection().isFwdLimitSwitchClosed());
  SmartDashboard.putBoolean("Reverse limit switch value", motorE.getSensorCollection().isRevLimitSwitchClosed());   
    }
}
