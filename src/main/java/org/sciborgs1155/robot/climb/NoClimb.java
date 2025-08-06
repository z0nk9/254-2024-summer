package org.sciborgs1155.robot.climb;

import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.units.measure.Angle;

public class NoClimb implements ClimbIO {

  @Override
  public void setVoltage(double volts) {}

  @Override
  public Angle getPosition() {
    return Radians.of(0);
  }
}
