package pt.isec.pa.fichaExercicios.ex24.fsm;

import pt.isec.pa.fichaExercicios.ex24.data.Elevator;

class GroundFloorState extends ElevatorStateAdapter{

    protected GroundFloorState(Elevator elevator, ElevatorContext context) {
        super(elevator, context);
        elevator.setCurrentFloor(0);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.GROUND_FLOOR;
    }

    @Override
    public boolean up() {
        changeState(new FirstFloorState(elevator, context));
        return true;
    }
}
