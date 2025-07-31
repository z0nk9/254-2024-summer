package org.sciborgs1155.robot.elevator;

import static edu.wpi.first.units.Units.Meters;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.GEARBOX;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.MAX_HEIGHT;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.MIN_HEIGHT;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.kA;
import static org.sciborgs1155.robot.elevator.ElevatorConstants.kV;

import edu.wpi.first.wpilibj.simulation.ElevatorSim;

public class SimElevator implements ElevatorIO {

  private final ElevatorSim sim =
      new ElevatorSim(
          kV,
          kA,
          GEARBOX,
          MIN_HEIGHT.in(Meters),
          MAX_HEIGHT.in(Meters),
          true,
          MIN_HEIGHT.in(Meters));

  @Override
  public double getPosition() {
    return sim.getPositionMeters();
  }

  @Override
  public void setVoltage(double volts) {
    sim.setInputVoltage(volts);
  }
}
