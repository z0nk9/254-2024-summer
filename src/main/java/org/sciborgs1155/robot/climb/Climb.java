package org.sciborgs1155.robot.climb;

import org.sciborgs1155.robot.Robot;
import static org.sciborgs1155.robot.climb.ClimbConstants.MAX_ACCEL;
import static org.sciborgs1155.robot.climb.ClimbConstants.MAX_ANGLE;
import static org.sciborgs1155.robot.climb.ClimbConstants.MAX_VELOCITY;
import static org.sciborgs1155.robot.climb.ClimbConstants.MIN_ANGLE;
import static org.sciborgs1155.robot.climb.ClimbConstants.kD;
import static org.sciborgs1155.robot.climb.ClimbConstants.kI;
import static org.sciborgs1155.robot.climb.ClimbConstants.kP;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import static edu.wpi.first.units.Units.Radians;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  public final ClimbIO hardware;
  public final ProfiledPIDController pid =
      new ProfiledPIDController(kP, kI, kD, new Constraints(MAX_VELOCITY, MAX_ACCEL));

  public Climb(ClimbIO hardware) {
    this.hardware = hardware;
  }

  public static Climb create() {
    return Robot.isReal() ? new Climb(new RealClimb()) : new Climb(new SimClimb());
  }

  public static Climb none() {
    return new Climb(new NoClimb());
  }

  public Command goTo(Angle angle) {
    return run(
        () -> {
          pid.calculate(hardware.getPosition().in(Radians), angle.in(Radians));
        });
  }

  public Command goTo(double angle) {
    return goTo(Radians.of(angle));
  }

  public Command raise() {
    return goTo(MAX_ANGLE);
  }

  public Command lower() {
    return goTo(MIN_ANGLE);
  }
 }
