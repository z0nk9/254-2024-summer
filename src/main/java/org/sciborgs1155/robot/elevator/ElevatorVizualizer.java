package org.sciborgs1155.robot.elevator;

import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class ElevatorVizualizer {
  private final Mechanism2d mech;
  private final MechanismLigament2d elevator;

  public ElevatorVizualizer(Color8Bit color) {
    mech = new Mechanism2d(50, 50, color);
    MechanismRoot2d chassis = mech.getRoot("elevator", 25, 10);
    elevator = chassis.append(new MechanismLigament2d("elevator", 10, 90, 3, color));
  }

  public void setLength(double height) {
    elevator.setLength(height);
    SmartDashboard.putData("Robot/elevator/visualizer", mech);
  }
}
