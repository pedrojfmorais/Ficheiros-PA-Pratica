package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;

abstract class ElevatorStateAdapter implements IElevatorState {

    protected Elevator elevator;
    protected ElevatorContext context;

    protected ElevatorStateAdapter(Elevator elevator, ElevatorContext elevatorContext) {
        this.elevator = elevator;
        this.context = elevatorContext;
    }

    protected void changeState(ElevatorState state){context.changeState(state.createState(elevator, context));}

    @Override
    public boolean up() {
        return false;
    }

    @Override
    public boolean down() {
        return false;
    }

    @Override
    public boolean checkSecurityKey(String str) {
        return false;
    }
}
