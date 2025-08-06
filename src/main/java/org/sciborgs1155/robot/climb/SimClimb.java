package org.sciborgs1155.robot.climb;

import static edu.wpi.first.units.Units.Radians;
import static org.sciborgs1155.robot.climb.ClimbConstants.GEARBOX;
import static org.sciborgs1155.robot.climb.ClimbConstants.GEARING;
import static org.sciborgs1155.robot.climb.ClimbConstants.LENGTH;
import static org.sciborgs1155.robot.climb.ClimbConstants.MAX_ANGLE;
import static org.sciborgs1155.robot.climb.ClimbConstants.MIN_ANGLE;
import static org.sciborgs1155.robot.climb.ClimbConstants.MOI;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class SimClimb implements ClimbIO {

  private final SingleJointedArmSim sim =
      new SingleJointedArmSim(
          GEARBOX, GEARING, MOI, LENGTH, MIN_ANGLE.in(Radians), MAX_ANGLE.in(Radians), false, 0);

  @Override
  public void setVoltage(double volts) {
    sim.setInputVoltage(volts);
  }

  @Override
  public Angle getPosition() {
    return Radians.of(sim.getAngleRads());
  }
}
