package org.sciborgs1155.robot.climb;

import edu.wpi.first.units.measure.Angle;

public interface ClimbIO {
  public void setVoltage(double volts);

  public Angle getPosition();
}
