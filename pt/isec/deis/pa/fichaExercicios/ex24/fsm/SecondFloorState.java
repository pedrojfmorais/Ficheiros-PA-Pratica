package pt.isec.deis.pa.fichaExercicios.ex24.fsm;

import pt.isec.deis.pa.fichaExercicios.ex24.data.Elevator;

class SecondFloorState extends ElevatorStateAdapter{
    protected SecondFloorState(Elevator elevator, ElevatorContext elevatorContext) {
        super(elevator, elevatorContext);
        elevator.setCurrentFloor(2);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.SECOND_FLOOR;
    }

    @Override
    public boolean down() {
        context.changeState(new FirstFloorState(elevator, context));
        return true;
    }
}
