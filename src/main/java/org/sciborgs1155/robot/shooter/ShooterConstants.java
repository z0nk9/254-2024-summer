package org.sciborgs1155.robot.shooter;

import static edu.wpi.first.units.Units.Amps;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Current;

public class ShooterConstants {
  public static final Current CURRENT_LIMIT = Amps.of(20);
  public static final double MOI = 0.001;
  public static final double GEARING = 32 / 18;
  public static final DCMotor GEARBOX = DCMotor.getKrakenX60(2);
  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = .1;
  public static final double MAX_VELOCITY = 10;
  public static final double MAX_ACCEL = 10;
}
