package org.sciborgs1155.robot.hood;

import static edu.wpi.first.units.Units.Radians;
import static org.sciborgs1155.robot.hood.HoodConstants.ARM_LENGTH;
import static org.sciborgs1155.robot.hood.HoodConstants.GEARBOX;
import static org.sciborgs1155.robot.hood.HoodConstants.GEARING;
import static org.sciborgs1155.robot.hood.HoodConstants.MAX_ANGLE;
import static org.sciborgs1155.robot.hood.HoodConstants.MIN_ANGLE;
import static org.sciborgs1155.robot.hood.HoodConstants.MOI;
import static org.sciborgs1155.robot.hood.HoodConstants.STARTING_ANGLE;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class SimHood implements HoodIO {
  private final SingleJointedArmSim sim =
      new SingleJointedArmSim(
          GEARBOX,
          GEARING,
          MOI,
          ARM_LENGTH,
          MIN_ANGLE.in(Radians),
          MAX_ANGLE.in(Radians),
          false,
          STARTING_ANGLE.in(Radians));

  @Override
  public void setVoltage(double volts) {
    sim.setInputVoltage(volts);
  }

  @Override
  public Angle getPosition() {
    return Radians.of(sim.getAngleRads());
  }
}
