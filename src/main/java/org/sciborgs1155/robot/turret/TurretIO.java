package org.sciborgs1155.robot.turret;

import edu.wpi.first.units.measure.Angle;

public interface TurretIO {
  public void setVoltage(double volts);

  public Angle getAngle();
}
