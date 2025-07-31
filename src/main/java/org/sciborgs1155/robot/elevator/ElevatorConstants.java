package org.sciborgs1155.robot.elevator;

import edu.wpi.first.math.system.plant.DCMotor;
import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Pounds;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.Mass;

public class ElevatorConstants {
  public static final Current CURRENT_LIMIT = Amps.of(20);
  public static final DCMotor GEARBOX = DCMotor.getKrakenX60(1);
  public static final double GEARING = 11 / 36 * 15 / 18;
  public static final Distance SPROCKET_RADIUS = Inches.of(1.7565 / 2);
  public static final Distance SPROCKET_CIRCUMFRENCE = SPROCKET_RADIUS.times(2 * Math.PI);
  public static final Mass CARRIAGE_MASS = Pounds.of(5);
  public static final double kV = 1.35;
  public static final double kA = .0006;
  public static final Distance MAX_HEIGHT = Inches.of(17);
  public static final Distance MIN_HEIGHT = Meters.of(0);

  // Input to Output; "values greater than one represent a reduction"
  /** conversion factor in METERS PER ROTATION */
  public static final double CONVERSION_FACTOR = GEARING / SPROCKET_CIRCUMFRENCE.in(Meters) / 2;
  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = .1;
  public static final double MAX_VELOCITY = .5;
  public static final double MAX_ACCEL = .5;
}
