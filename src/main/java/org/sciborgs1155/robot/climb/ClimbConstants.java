package org.sciborgs1155.robot.climb;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Current;

public class ClimbConstants {
  public static final Current CURRENT_LIMIT = Amps.of(20);
  public static final DCMotor GEARBOX = DCMotor.getKrakenX60(1);
  public static final double GEARING = 11 / 40 * 14 / 42;
  public static final double MOI = 0.001;
  public static final double LENGTH = 1;
  public static final Angle MAX_ANGLE = Degrees.of(70);
  public static final Angle MIN_ANGLE = Radians.of(0);

  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = .1;
  public static final double MAX_VELOCITY = 3;
  public static final double MAX_ACCEL = 5;
}
