package org.sciborgs1155.robot.shooter;

import static edu.wpi.first.units.Units.RadiansPerSecond;

import edu.wpi.first.units.measure.AngularVelocity;

public class NoShooter implements ShooterIO {
  @Override
  public AngularVelocity getVelocity() {
    return RadiansPerSecond.of(0);
  }

  @Override
  public void setVoltage(double volts) {}
}
