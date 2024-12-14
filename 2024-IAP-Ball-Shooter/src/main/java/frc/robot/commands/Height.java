package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class Height extends Command {
    double setPoint; 
    double RPI = 2; 
    double ticksNeeded = 4096*(setPoint/RPI);

    public final WPI_TalonSRX motorE = new WPI_TalonSRX(Constants.ElevatorPorts.ElevatorPort);
    public Height(double setPoint, Elevator elevator){
        this.setPoint = setPoint;
        addRequirements(elevator);
    } 
public void stopAtPos(){
    if (motorE.getSelectedSensorPosition(0) >= ticksNeeded){
    motorE.set(0);
}
}
@Override
public void initialize(){
    motorE.setSelectedSensorPosition(0,0,10);
}

@Override
public void end(boolean interrupted) {
}

@Override
public boolean isFinished() {
    return true;
    }
}