package frc.robot.subsystems.Manager;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Claw.Claw;
import frc.robot.subsystems.Intake.Intake;

public class Manager extends Subsystem<ManagerStates> {
    private Intake intake;
    private Claw claw;
    private XboxController controller;

    public Manager() {
        super("Manager", ManagerStates.OFF);
        intake = new Intake();
        claw = new Claw();
        controller = new XboxController(0);

        AddTriggers();
    }

    @Override
    public void runState() {
        intake.setState(getState().getIntakeState());
        claw.setState(getState().getClawState());
                
        intake.periodic();
        claw.periodic();

        SmartDashboard.putString("Manager State", getState().getStateString());
    }
    

    private void AddTriggers() {
        addTrigger(ManagerStates.OFF, ManagerStates.INTAKING, controller::getAButtonPressed);
        addTrigger(ManagerStates.INTAKING, ManagerStates.PROCESSING, () -> controller.getBButtonPressed());
        addTrigger(ManagerStates.PROCESSING, ManagerStates.SHOOTING, () -> controller.getXButtonPressed());
        addTrigger(ManagerStates.SHOOTING, ManagerStates.OFF, () -> controller.getYButtonPressed());
        addTrigger(ManagerStates.INTAKING, ManagerStates.OFF, () -> controller.getAButtonPressed());
        addTrigger(ManagerStates.PROCESSING, ManagerStates.OFF, () -> controller.getBButtonPressed());
        addTrigger(ManagerStates.SHOOTING, ManagerStates.OFF, () -> controller.getXButtonPressed());
    }

}