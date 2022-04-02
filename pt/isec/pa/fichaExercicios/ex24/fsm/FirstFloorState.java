package pt.isec.pa.fichaExercicios.ex24.fsm;

import pt.isec.pa.fichaExercicios.ex24.data.Elevator;

class FirstFloorState extends ElevatorStateAdapter{

    protected FirstFloorState(Elevator elevator, ElevatorContext elevatorContext) {
        super(elevator, elevatorContext);
        elevator.setCurrentFloor(1);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.FIRST_FLOOR;
    }

    @Override
    public boolean up() {
        context.changeState(new SecondFloorState(elevator, context));
        return true;
    }

    @Override
    public boolean down() {
        context.changeState(new GroundFloorState(elevator, context));
        return true;
    }
}
