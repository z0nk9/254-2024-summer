package org.sciborgs1155.robot.turret;

import static org.sciborgs1155.robot.turret.TurretConstants.*;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sciborgs1155.robot.Robot;

public class Turret extends SubsystemBase {
  private final TurretIO hardware;
  private final ProfiledPIDController pid =
      new ProfiledPIDController(
          kP, kI, kD, new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));

  public Turret(TurretIO hardware) {
    this.hardware = hardware;
  }

  public static Turret create() {
    return Robot.isReal() ? new Turret(new RealTurret()) : new Turret(new SimTurret());
  }

  public static Turret none() {
    return new Turret(new NoTurret());
  }
}