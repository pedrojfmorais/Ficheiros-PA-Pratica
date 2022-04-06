package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;

public enum ElevatorState {
    GROUND_FLOOR, FIRST_FLOOR, SECOND_FLOOR, BROKEN;

    IElevatorState createState(Elevator elevator, ElevatorContext context){
        return switch (this){
            case GROUND_FLOOR -> new GroundFloorState(elevator, context);
            case FIRST_FLOOR -> new FirstFloorState(elevator, context);
            case SECOND_FLOOR -> new SecondFloorState(elevator, context);
            case BROKEN -> new BrokenState(elevator, context);
        };
    }
}
