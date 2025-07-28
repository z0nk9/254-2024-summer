package org.sciborgs1155.robot.turret;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class TurretVisualizer {
  private final Mechanism2d mech;
  private final MechanismLigament2d turret;

  public TurretVisualizer(Color8Bit color) {
    mech = new Mechanism2d(50, 50, color);
    MechanismRoot2d chassis = mech.getRoot("chassis", 25, 25);
    turret = chassis.append(new MechanismLigament2d("turret", 20, 0, 3, color));
  }

  public void setAngle(Angle angle) {
    turret.setAngle(angle.in(Degrees));
    SmartDashboard.putData("Robot/turret/turretVisualizer", mech);
  }
}
