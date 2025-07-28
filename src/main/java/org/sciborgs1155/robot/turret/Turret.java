package org.sciborgs1155.robot.turret;

import org.sciborgs1155.robot.Robot;
import static org.sciborgs1155.robot.turret.TurretConstants.MAX_ACCELERATION;
import static org.sciborgs1155.robot.turret.TurretConstants.MAX_VELOCITY;
import static org.sciborgs1155.robot.turret.TurretConstants.kD;
import static org.sciborgs1155.robot.turret.TurretConstants.kI;
import static org.sciborgs1155.robot.turret.TurretConstants.kP;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import static edu.wpi.first.units.Units.Radians;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Represents the turret subsystem of the robot, which controls the rotation of the turret
 * using a ProfiledPIDController.
 */
public class Turret extends SubsystemBase {
  private final TurretIO hardware;
  private final ProfiledPIDController pid =
      new ProfiledPIDController(
          kP, kI, kD, new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));
  private final TurretVisualizer setpointVisualizer = new TurretVisualizer(new Color8Bit(Color.kBlue));
  private final TurretVisualizer measurementVisualizer = new TurretVisualizer(new Color8Bit(Color.kRed));


  /**
   * Constructs a Turret instance with the specified hardware interface.
   *
   * @param hardware The hardware interface for the turret.
   */
  private Turret(TurretIO hardware) {
    this.hardware = hardware;
  }

  /**
   * Creates a new Turret instance based on the current robot environment.
   * If the robot is running in a real environment, it uses the real turret hardware.
   * Otherwise, it uses a simulated turret.
   *
   * @return A new Turret instance.
   */
  public static Turret create() {
    return Robot.isReal() ? new Turret(new RealTurret()) : new Turret(new SimTurret());
  }

  /**
   * Creates a new Turret instance that performs no operations.
   *
   * @return A new Turret instance with no functionality.
   */
  public static Turret none() {
    return new Turret(new NoTurret());
  }

  /**
   * Creates a command to move the turret to the specified angular position.
   *
   * @param goal The target angular position as an {@link Angle}.
   * @return A command that moves the turret to the specified position.
   */
  public Command goTo(Angle goal) {
    return run(() -> {
      hardware.setVoltage(pid.calculate(hardware.getAngle().in(Radians), goal.in(Radians)));
    });
  }

  /**
   * Creates a command to move the turret to the specified angular position.
   *
   * @param goal The target angular position in radians.
   * @return A command that moves the turret to the specified position.
   */
  public Command goTo(double goal) {
    return goTo(Radians.of(goal));
  }

  @Override
  public void periodic() {
    setpointVisualizer.setAngle(Radians.of(pid.getSetpoint().position));
    measurementVisualizer.setAngle(hardware.getAngle());
  }
}