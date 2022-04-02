package pt.isec.pa.fichaExercicios.ex24.fsm;

import pt.isec.pa.fichaExercicios.ex24.data.Elevator;

abstract class ElevatorStateAdapter implements IElevatorState {

    protected Elevator elevator;
    protected ElevatorContext context;

    protected ElevatorStateAdapter(Elevator elevator, ElevatorContext elevatorContext) {
        this.elevator = elevator;
        this.context = elevatorContext;
    }

    protected void changeState(IElevatorState state){context.changeState(state);}

    @Override
    public boolean up() {
        return false;
    }

    @Override
    public boolean down() {
        return false;
    }
}
