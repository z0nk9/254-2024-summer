package org.sciborgs1155.robot.shooter;

import static edu.wpi.first.units.Units.RadiansPerSecond;
import static org.sciborgs1155.robot.shooter.ShooterConstants.kD;
import static org.sciborgs1155.robot.shooter.ShooterConstants.kI;
import static org.sciborgs1155.robot.shooter.ShooterConstants.kP;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sciborgs1155.robot.Robot;

public class Shooter extends SubsystemBase {
  private final ShooterIO hardware;
  private final PIDController pid;

  public Shooter(ShooterIO hardware) {
    this.hardware = hardware;
    this.pid = new PIDController(kP, kI, kD);
  }

  public static Shooter create() {
    return Robot.isReal() ? new Shooter(new RealShooter()) : new Shooter(new SimShooter());
  }

  public static Shooter none() {
    return new Shooter(new NoShooter());
  }

  public Command shootAtSpeed(AngularVelocity speed) {
    return run(
        () -> {
          hardware.setVoltage(
              pid.calculate(
                  hardware.getVelocity().in(RadiansPerSecond), speed.in(RadiansPerSecond)));
        });
  }
}
