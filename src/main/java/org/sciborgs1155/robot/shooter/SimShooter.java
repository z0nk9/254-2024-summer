package org.sciborgs1155.robot.shooter;

import static org.sciborgs1155.robot.shooter.ShooterConstants.GEARBOX;
import static org.sciborgs1155.robot.shooter.ShooterConstants.GEARING;
import static org.sciborgs1155.robot.shooter.ShooterConstants.MOI;

import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class SimShooter implements ShooterIO {
  private final FlywheelSim sim =
      new FlywheelSim(LinearSystemId.createFlywheelSystem(GEARBOX, MOI, GEARING), GEARBOX);

  @Override
  public AngularVelocity getVelocity() {
    return sim.getAngularVelocity();
  }

  @Override
  public void setVoltage(double volts) {
    sim.setInputVoltage(volts);
  }
}
