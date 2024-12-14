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
    double maxHeight = 52;
    double RPI = 20;
    double max = (maxHeight/RPI)*4096;
    double min = -100000;
    double currentPos = motorE.getSelectedSensorPosition(0);
  /** Creates a new ClimbTeleop. */
  public Elevator(Joystick joystick) {
    this.joystick = joystick;
  }
  /* 
  public void topLimit(){
    if(currentPos==max){
    motorE.set(0);
    }
  }
  */
/* 
  public void ElevatorUp(){
    if(joystick.getY() > 0.1 ){
        motorE.set(0.5);
  
   }
  }
  
  public void resetEncoders(){
    motorE.setSelectedSensorPosition(0,0,10);
  }
 
  public void ElevatorDown(){
    if(joystick.getY() < -0.1) {
       motorE.set(-0.5);
   }
  }
*/
  //resets encoders
  public void initialize(){
      motorE.setSelectedSensorPosition(0,0,10);
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
    /**
    //double value = joystick.getY();
    if(joystick.getY() > 0.1 ){
        motorE.set(0.5);
  
   }
    if(joystick.getY() < -0.1 ){
        motorE.set(-0.5);
  
   }
   //top soft limit
    if(currentPos >= max){
      motorE.set(0);
    }
    */
    currentPos = motorE.getSelectedSensorPosition(0);
    double input = joystick.getY();
    
    if(currentPos < max && input <=  0 ||
    currentPos > min && input > 0){
      motorE.set(input * .6);
    }
    
    

    if(joystick.getRawButtonPressed(0)) {
         motorE.set(0);
  }
  SmartDashboard.putNumber("Current position in ticks",currentPos);
  SmartDashboard.putBoolean("Forward limit switch value", motorE.getSensorCollection().isFwdLimitSwitchClosed());
  SmartDashboard.putBoolean("Reverse limit switch value", motorE.getSensorCollection().isRevLimitSwitchClosed());   
    }
}
