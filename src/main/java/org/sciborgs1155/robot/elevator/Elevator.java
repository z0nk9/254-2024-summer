package org.sciborgs1155.robot.elevator;

import org.sciborgs1155.robot.Robot;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.MAX_ACCEL;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.MAX_VELOCITY;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.kD;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.kI;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.kP;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  public final ElevatorIO hardware;
  private final ProfiledPIDController pid = new ProfiledPIDController(kP, kI, kD, new Constraints(MAX_VELOCITY, MAX_ACCEL));

  public Elevator(ElevatorIO hardware) {
    this.hardware = hardware;
  }

  public static Elevator create() {
    return Robot.isReal() ? new Elevator(new RealElevator()) : new Elevator(new SimElevator());
  }

  public static Elevator none() {
    return new Elevator(new NoElevator());
  }

  public Command goTo(double height) {
    return run(() -> {
      hardware.setVoltage(pid.calculate(hardware.getPosition(), height));
    });
  }
}
