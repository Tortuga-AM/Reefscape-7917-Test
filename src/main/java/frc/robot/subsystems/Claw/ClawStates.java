package frc.robot.subsystems.Claw;

import org.team7525.subsystem.SubsystemStates;

public enum ClawStates implements SubsystemStates {
    OFF("OFF", 270, 56.0),
    INTAKING("INTAKING", 67.9, 98.0),
    SHOOTING("SHOOTING", 56.0, 34.0),
    PROCESSING("PROCESSING", 178.0, 678.0);

    private final String stateString;
    private final double wheelSpeed;
    private final double pivotSetpoint;

    ClawStates(String stateString, double wheelSpeed, double pivotSetpoint) {
        this.stateString = stateString;
        this.wheelSpeed = wheelSpeed;
        this.pivotSetpoint = pivotSetpoint * 360; // convert to degrees from rotations
    }

    @Override
    public String getStateString() {
        return stateString;
    }

    public double getWheelSpeed() {
        return wheelSpeed;
    }

    public double getPivotSetpoint() {
        return pivotSetpoint;
    }
    
}
