package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  private final WPI_TalonSRX motorE = new WPI_TalonSRX(Constants.ElevatorPorts.ElevatorPort);
  private static final int CPR = 4096; 
  private static final double circ = 3.14; 

  public Elevator() {
    motorE.configFactoryDefault();
    motorE.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    motorE.setSensorPhase(true); 
    motorE.setSelectedSensorPosition(0);

  }

  public void setElevatorPosition(double targetPosition) {
    motorE.set(ControlMode.Position, targetPosition*CPR / circ);
  }

  public double getElevatorPosition() {
    return (motorE.getSelectedSensorPosition()/CPR)*circ;

  }

  public void stopElevator() {
    motorE.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // Display encoder data
    SmartDashboard.putNumber("Elevator Encoder Position(inch)", getElevatorPosition());
    SmartDashboard.putBoolean("Forward Limit", motorE.getSensorCollection().isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("Reverse Limit", motorE.getSensorCollection().isRevLimitSwitchClosed());
  }
}
