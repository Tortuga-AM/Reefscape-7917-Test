package frc.robot.subsystems.Intake;

import org.team7525.subsystem.SubsystemStates;

public enum IntakeStates implements SubsystemStates {
    OFF("OFF", 0.23, 56.4),
    ON("ON", 0.23, 56.4),
    PASSING("PASSING", 0.23, 56.4);


    private final String stateString;
    private final double wheelSpeed;
    private final double pivotSetpoint;

    IntakeStates(String stateString, double wheelSpeed, double pivotSetpoint) {
        this.stateString = stateString;
        this.wheelSpeed = wheelSpeed;
        this.pivotSetpoint = pivotSetpoint;
    }

    public double getWheelSpeed() {
        return wheelSpeed;
    }

    @Override
    public String getStateString() {
        return stateString;
    }

    public double getPivotSetpoint() {
        return pivotSetpoint;
    }
}
