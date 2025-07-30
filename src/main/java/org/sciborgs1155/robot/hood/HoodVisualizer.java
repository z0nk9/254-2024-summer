package org.sciborgs1155.robot.hood;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class HoodVisualizer {
  private final Mechanism2d mech;
  private final MechanismLigament2d hood;

  public HoodVisualizer(Color8Bit color) {
    mech = new Mechanism2d(50, 50, color);
    MechanismRoot2d chassis = mech.getRoot("turret", 25, 25);
    hood = chassis.append(new MechanismLigament2d("hood", 20, 10, 3, color));
  }

  public void setAngle(Angle angle) {
    hood.setAngle(angle.in(Degrees));
    SmartDashboard.putData("Robot/hood/hoodVisualizer", mech);
  }
}
