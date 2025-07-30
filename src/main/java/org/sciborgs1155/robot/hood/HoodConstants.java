package org.sciborgs1155.robot.hood;

import edu.wpi.first.math.system.plant.DCMotor;
import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Current;

public class HoodConstants {
  public static final Current CURRENT_LIMIT = Amps.of(20);
  public static final DCMotor GEARBOX = DCMotor.getKrakenX60(1);
  public static final double GEARING = 14 / 48 * 15 / 36 * 10 / 16;
  public static final double MOI = 0.001;
  public static final double ARM_LENGTH = .5;
  public static final Angle MIN_ANGLE = Degrees.of(10);
  public static final Angle MAX_ANGLE = Degrees.of(50);
  public static final Angle STARTING_ANGLE = Degrees.of(30);
  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = .1;
  public static final double MAX_VELOCITY = .5;
  public static final double MAX_ACCEL = .5;

}
