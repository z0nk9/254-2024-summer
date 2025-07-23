package org.sciborgs1155.robot.intake;

import org.sciborgs1155.lib.Beambreak;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Intake extends SubsystemBase {
    private final TalonFX[] motors;
    private final Beambreak beambreak;
    @Logged private final Trigger blocked;
    public Intake(TalonFX[] motors, Beambreak beambreak) {
        this.motors = motors;
        this.beambreak = beambreak;
        this.blocked = new Trigger(beambreak::get);
    }
}
