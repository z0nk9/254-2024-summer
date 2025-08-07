package org.sciborgs1155.robot.climb;

import static edu.wpi.first.units.Units.Degrees;
import static org.sciborgs1155.robot.climb.ClimbConstants.MIN_ANGLE;

import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class ClimbVisualizer {
  @NotLogged private final Mechanism2d mech;
  private final MechanismLigament2d climb;
  private final String name;

  public ClimbVisualizer(String name, Color8Bit color) {
    this.name = name;
    mech = new Mechanism2d(50, 50);
    MechanismRoot2d chassis = mech.getRoot("chassis", 10, 25);
    climb = chassis.append(new MechanismLigament2d("climb", 0, MIN_ANGLE.in(Degrees), 3, color));
  }

  public void setAngle(double angle) {
    climb.setAngle(angle);
    SmartDashboard.putData("Robot/climb/" + name, mech);
  }
}
