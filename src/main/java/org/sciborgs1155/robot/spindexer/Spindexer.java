package org.sciborgs1155.robot.spindexer;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Spindexer.BEAMBREAK_CHANNEL;
import static org.sciborgs1155.robot.Ports.Spindexer.SPINDEXER_LEFT_MOTOR;
import static org.sciborgs1155.robot.Ports.Spindexer.SPINDEXER_RIGHT_MOTOR;
import static org.sciborgs1155.robot.intake.IntakeConstants.CURRENT_LIMIT;
import static org.sciborgs1155.robot.spindexer.SpindexerConstants.SPINDEXER_SPEED;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import org.sciborgs1155.lib.Beambreak;
import org.sciborgs1155.lib.SimpleMotor;
import org.sciborgs1155.robot.Robot;

public class Spindexer extends SubsystemBase {
  private final SimpleMotor leftMotor;
  private final SimpleMotor rightMotor;

  private final Beambreak beambreak;
  @Logged private final Trigger blocked;

  public Spindexer(SimpleMotor leftMotor, SimpleMotor rightMotor, Beambreak beambreak) {
    this.leftMotor = leftMotor;
    this.rightMotor = rightMotor;
    this.beambreak = beambreak;
    this.blocked = new Trigger(beambreak::get);
  }

  public static Spindexer create() {
    return Robot.isReal()
        ? new Spindexer(
            motor(SPINDEXER_LEFT_MOTOR),
            motor(SPINDEXER_RIGHT_MOTOR),
            Beambreak.real(BEAMBREAK_CHANNEL))
        : none();
  }

  private static SimpleMotor motor(int port) {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
    config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    return SimpleMotor.talon(new TalonFX(port), config);
  }

  public static Spindexer none() {
    return new Spindexer(SimpleMotor.none(), SimpleMotor.none(), Beambreak.none());
  }

  public Command spin(boolean clockwise) {
    return run(
        () -> {
          if (clockwise) {
            leftMotor.set(SPINDEXER_SPEED);
            rightMotor.set(SPINDEXER_SPEED);
          } else {
            leftMotor.set(-SPINDEXER_SPEED);
            rightMotor.set(-SPINDEXER_SPEED);
          }
        });
  }

  public Command intake() {
    return run(
        () -> {
          leftMotor.set(SPINDEXER_SPEED);
          rightMotor.set(-SPINDEXER_SPEED);
        });
  }
}
