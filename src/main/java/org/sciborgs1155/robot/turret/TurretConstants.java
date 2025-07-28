package org.sciborgs1155.robot.turret;

import static edu.wpi.first.units.Units.Amps;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Current;

public class TurretConstants {
  public static final Current CURRENT_LIMIT = Amps.of(20);
  public static final double CONVERSION_FACTOR = 2.3;
  public static final DCMotor GEARBOX = DCMotor.getKrakenX60(1);
  public static final double GEARING = 52 / 14 * 10 / 125;
  public static final double MOI = 0.0001;
  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = .1;
  public static final double MAX_VELOCITY = 3;
  public static final double MAX_ACCELERATION = 5;
}
