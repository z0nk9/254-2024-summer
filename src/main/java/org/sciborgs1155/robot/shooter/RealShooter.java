package org.sciborgs1155.robot.shooter;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Shooter.*;
import static org.sciborgs1155.robot.shooter.ShooterConstants.*;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.measure.AngularVelocity;
import org.sciborgs1155.lib.FaultLogger;
import org.sciborgs1155.lib.TalonUtils;

public class RealShooter implements ShooterIO {
  private final TalonFX topMotor = new TalonFX(TOP_SHOOTER_MOTOR);
  private final TalonFX bottomMotor = new TalonFX(BOTTOM_SHOOTER_MOTOR);

  public RealShooter() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    bottomMotor.setControl(new Follower(TOP_SHOOTER_MOTOR, true));
    config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    config.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
    topMotor.getConfigurator().apply(config);
    bottomMotor.getConfigurator().apply(config);
    topMotor.setPosition(0);
    bottomMotor.setPosition(0);
    TalonUtils.addMotor(topMotor);
    TalonUtils.addMotor(bottomMotor);
    FaultLogger.register(topMotor);
    FaultLogger.register(bottomMotor);
  }

  @Override
  public AngularVelocity getVelocity() {
    return topMotor.getVelocity().getValue();
  }

  @Override
  public void setVoltage(double volts) {
    topMotor.setVoltage(volts);
  }
}
