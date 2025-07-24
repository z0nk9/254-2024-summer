package org.sciborgs1155.robot.intake;

import static edu.wpi.first.units.Units.Amps;
import static org.sciborgs1155.robot.Ports.Intake.BEAMBREAK_CHANNEL;
import static org.sciborgs1155.robot.Ports.Intake.INTAKE_MOTOR;
import static org.sciborgs1155.robot.intake.IntakeConstants.CURRENT_LIMIT;
import static org.sciborgs1155.robot.intake.IntakeConstants.INTAKE_POWER;

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

public class Intake extends SubsystemBase {
  private final SimpleMotor motor;
  private final Beambreak beambreak;
  @Logged private final Trigger blocked;

  public static Intake create() {
    return Robot.isReal()
        ? new Intake(motor(INTAKE_MOTOR), Beambreak.real(BEAMBREAK_CHANNEL))
        : none();
  }

  private static SimpleMotor motor(int port) {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.CurrentLimits.SupplyCurrentLimit = CURRENT_LIMIT.in(Amps);
    config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    return SimpleMotor.talon(new TalonFX(port), config);
  }

  public static Intake none() {
    return new Intake(SimpleMotor.none(), Beambreak.none());
  }

  public Intake(SimpleMotor motor, Beambreak beambreak) {
    this.motor = motor;
    this.beambreak = beambreak;
    this.blocked = new Trigger(beambreak::get);
  }

  public Command run(double volts) {
    return run(() -> motor.set(volts));
  }

  public Command intake() {
    return run(INTAKE_POWER);
  }

  public Command outtake() {
    return run(-INTAKE_POWER);
  }
}
