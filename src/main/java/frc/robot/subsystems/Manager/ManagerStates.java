package frc.robot.subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.subsystems.Claw.ClawStates;
import frc.robot.subsystems.Intake.IntakeStates;

public enum ManagerStates implements SubsystemStates {
    OFF("OFF", IntakeStates.OFF, ClawStates.OFF),
    INTAKING("INTAKING", IntakeStates.ON, ClawStates.INTAKING),
    PROCESSING("PROCESSING", IntakeStates.PASSING, ClawStates.PROCESSING),
    SHOOTING("SHOOTING", IntakeStates.PASSING, ClawStates.SHOOTING);

    private final String stateString;
    private final IntakeStates intakeState;
    private final ClawStates clawState;

    ManagerStates(String stateString, IntakeStates intakeState, ClawStates clawState) {
        this.stateString = stateString;
        this.intakeState = intakeState;
        this.clawState = clawState;
    }

    @Override
    public String getStateString() {
        return stateString;
    }

    public IntakeStates getIntakeState() {
        return intakeState;
    }

    public ClawStates getClawState() {
        return clawState;
    }
    
}
