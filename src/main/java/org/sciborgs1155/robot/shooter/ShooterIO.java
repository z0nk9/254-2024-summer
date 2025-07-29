package org.sciborgs1155.robot.shooter;

import edu.wpi.first.units.measure.AngularVelocity;

public interface ShooterIO {
  public AngularVelocity getVelocity();

  public void setVoltage(double volts);
}
