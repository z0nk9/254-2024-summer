package org.sciborgs1155.robot.hood;

import edu.wpi.first.units.measure.Angle;

public interface HoodIO {
  void setVoltage(double volts);

  Angle getPosition();
}
