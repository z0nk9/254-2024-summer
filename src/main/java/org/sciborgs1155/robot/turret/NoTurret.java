package org.sciborgs1155.robot.turret;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class NoTurret implements TurretIO {

  @Override
  public void setVoltage(double volts) {}

  @Override
  public Angle getAngle() {
    return Degrees.of(0);
  }
}
