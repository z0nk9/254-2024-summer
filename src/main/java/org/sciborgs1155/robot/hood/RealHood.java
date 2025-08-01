package org.sciborgs1155.robot.hood;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Hood.HOOD_MOTOR;
import static org.sciborgs1155.robot.shooter.ShooterConstants.CURRENT_LIMIT;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.measure.Angle;

public class RealHood implements HoodIO {

  private TalonFX motor = new TalonFX(HOOD_MOTOR);

  public RealHood() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    config.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
    motor.getConfigurator().apply(config);
  }

  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
  }

  @Override
  public Angle getPosition() {
    return motor.getPosition().getValue();
  }
}
