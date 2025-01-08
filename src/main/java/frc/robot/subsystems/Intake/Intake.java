package frc.robot.subsystems.Intake;

import org.team7525.subsystem.Subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem<IntakeStates> {
    private SparkMax wheelSparkMax;
    private SparkMax pivotSparkMax;

    private PIDController pivotController;
    private PIDController wheelController;

    public Intake() {
        super("Intake", IntakeStates.OFF);
        wheelSparkMax = new SparkMax(0, MotorType.kBrushless);
        pivotSparkMax = new SparkMax(1, MotorType.kBrushless);

        pivotController = new PIDController(0.1, 0.0, 0.0);
        wheelController = new PIDController(0.1, 0.0, 0.0);
    }

    @Override
    public void runState() {
        wheelSparkMax.set(wheelController.calculate(wheelSparkMax.getEncoder().getVelocity(), getState().getWheelSpeed()));
        pivotSparkMax.set(pivotController.calculate(pivotSparkMax.getEncoder().getPosition(), getState().getPivotSetpoint()));
        SmartDashboard.putString("Intake State", getState().getStateString());
    }
    

}
