package org.sciborgs1155.robot.turret;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Turret.TURRET_MOTOR;
import static org.sciborgs1155.robot.turret.TurretConstants.CONVERSION_FACTOR;
import static org.sciborgs1155.robot.turret.TurretConstants.CURRENT_LIMIT;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.measure.Angle;

public class RealTurret implements TurretIO {
  private TalonFX motor = new TalonFX(TURRET_MOTOR);

  public RealTurret() {
    TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    motorConfig.Feedback.SensorToMechanismRatio = CONVERSION_FACTOR;
    motorConfig.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
  }

  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
  }

  @Override
  public Angle getAngle() {
    return motor.getPosition().getValue();
  }
}
