package org.sciborgs1155.robot.elevator;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Elevator.ELEVATOR_MOTOR;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.CONVERSION_FACTOR;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.CURRENT_LIMIT;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class RealElevator implements ElevatorIO {

  private final TalonFX motor;

  public RealElevator() {
    motor = new TalonFX(ELEVATOR_MOTOR);
    TalonFXConfiguration talonConfig = new TalonFXConfiguration();
    talonConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    talonConfig.Feedback.SensorToMechanismRatio = CONVERSION_FACTOR;
    talonConfig.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
  }

  @Override
  public double getPosition() {
    return motor.getPosition().getValueAsDouble();
  }

  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
  }
}
