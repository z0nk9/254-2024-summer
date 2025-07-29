package org.sciborgs1155.robot.shooterFeeder;

import org.sciborgs1155.lib.Beambreak;
import org.sciborgs1155.lib.SimpleMotor;
import static org.sciborgs1155.robot.Ports.Feeder.FEEDER_BEAMBREAK;
import static org.sciborgs1155.robot.Ports.Feeder.FEEDER_MOTOR;
import org.sciborgs1155.robot.Robot;
import static org.sciborgs1155.robot.shooterFeeder.FeederConstants.CURRENT_LIMIT;
import static org.sciborgs1155.robot.shooterFeeder.FeederConstants.FEEDER_POWER;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.epilogue.Logged;
import static edu.wpi.first.units.Units.Amps;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Feeder extends SubsystemBase {
  private final SimpleMotor motor;
  private final Beambreak beambreak;
  @Logged private final Trigger blocked;

  public Feeder(SimpleMotor motor, Beambreak beambreak) {
    this.motor = motor;
    this.beambreak = beambreak;
    this.blocked = new Trigger(beambreak::get);
  }

  public static Feeder create() {
    return Robot.isReal()
        ? new Feeder(motor(FEEDER_MOTOR), Beambreak.real(FEEDER_BEAMBREAK))
        : none();
  }

  public static Feeder none() {
    return new Feeder(SimpleMotor.none(), Beambreak.none());
  }

  private static SimpleMotor motor(int port) {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
    config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    return SimpleMotor.talon(new TalonFX(port), config);
  }

  public Command feed() {
    return run(() -> motor.set(FEEDER_POWER)).until(blocked);
  }

  public Command unFeed() {
    return run(() -> motor.set(-FEEDER_POWER));
  }
}
