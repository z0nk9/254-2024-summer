package org.sciborgs1155.robot;

public final class Ports {
  // TODO: Add and change all ports as needed.
  public static final class OI {
    public static final int OPERATOR = 0;
    public static final int DRIVER = 1;
  }

  public static final class Drive {
    public static final int CANANDGYRO = 20;
    public static final int FRONT_LEFT_DRIVE = 11;
    public static final int REAR_LEFT_DRIVE = 10;
    public static final int FRONT_RIGHT_DRIVE = 12;
    public static final int REAR_RIGHT_DRIVE = 13;

    public static final int FRONT_LEFT_TURNING = 15;
    public static final int REAR_LEFT_TURNING = 14;
    public static final int FRONT_RIGHT_TURNING = 16;
    public static final int REAR_RIGHT_TURNING = 17;
  }

  public static final class Intake {
    public static final int INTAKE_MOTOR = 2;
    public static final int BEAMBREAK_CHANNEL = 3;
  }

  public static final class Spindexer {
    public static final int SPINDEXER_LEFT_MOTOR = 4;
    public static final int SPINDEXER_RIGHT_MOTOR = 5;
    public static final int BEAMBREAK_CHANNEL = 6;
  }

  public static final class Turret {
    public static final int TURRET_MOTOR = 7;
  }

  public static final class Feeder {
    public static final int FEEDER_MOTOR = 8;
    public static final int FEEDER_BEAMBREAK = 9;
  }

  public static final class Shooter {
    public static final int TOP_SHOOTER_MOTOR = 18;
    public static final int BOTTOM_SHOOTER_MOTOR = 19;
  }
}
