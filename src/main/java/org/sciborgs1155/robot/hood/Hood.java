package org.sciborgs1155.robot.hood;

import static edu.wpi.first.units.Units.Radians;
import static org.sciborgs1155.robot.hood.HoodConstants.MAX_ACCEL;
import static org.sciborgs1155.robot.hood.HoodConstants.MAX_VELOCITY;
import static org.sciborgs1155.robot.hood.HoodConstants.kD;
import static org.sciborgs1155.robot.hood.HoodConstants.kI;
import static org.sciborgs1155.robot.hood.HoodConstants.kP;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sciborgs1155.robot.Robot;

public class Hood extends SubsystemBase {

  public final HoodIO hardware;

  @Logged
  private final ProfiledPIDController pid =
      new ProfiledPIDController(kP, kI, kD, new Constraints(MAX_VELOCITY, MAX_ACCEL));

  private final HoodVisualizer setpointVisualizer = new HoodVisualizer(new Color8Bit(Color.kBlue));

  private final HoodVisualizer measurementVisualizer =
      new HoodVisualizer(new Color8Bit(Color.kRed));

  public Hood(HoodIO hardware) {
    this.hardware = hardware;
  }

  public Hood create() {
    return Robot.isReal() ? new Hood(new RealHood()) : new Hood(new SimHood());
  }

  public Hood none() {
    return new Hood(new NoHood());
  }

  public Command goTo(Angle angle) {
    return run(
        () -> {
          pid.calculate(hardware.getPosition().in(Radians), angle.in(Radians));
        });
  }

  @Override
  public void periodic() {
    setpointVisualizer.setAngle(Radians.of(pid.getSetpoint().position));
    measurementVisualizer.setAngle(hardware.getPosition());
  }
}
