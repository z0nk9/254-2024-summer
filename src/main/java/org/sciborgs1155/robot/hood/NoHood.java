package org.sciborgs1155.robot.hood;

import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.units.measure.Angle;

public class NoHood implements HoodIO {

  @Override
  public void setVoltage(double volts) {}

  @Override
  public Angle getPosition() {
    return Radians.of(0);
  }
}
