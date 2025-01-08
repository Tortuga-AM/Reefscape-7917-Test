package frc.robot.subsystems.Claw;

import org.team7525.subsystem.Subsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;

public class Claw extends Subsystem<ClawStates> {
    private TalonFX wheelTalonFX;
    private TalonFX pivotTalonFX;

    private PIDController pivotController;
    private PIDController wheelController;

    public Claw() {
        super("Claw", ClawStates.OFF);
        wheelTalonFX = new TalonFX(0);
        pivotTalonFX = new TalonFX(1);

        wheelTalonFX.setPosition(0);
        pivotTalonFX.setPosition(0);    
    }
    
    @Override
    public void runState() {
        wheelTalonFX.set(wheelController.calculate(wheelTalonFX.getPosition().getValueAsDouble(), getState().getWheelSpeed()));
        pivotTalonFX.set(pivotController.calculate(pivotTalonFX.getPosition().getValueAsDouble(), getState().getPivotSetpoint()));
        
    }

}
