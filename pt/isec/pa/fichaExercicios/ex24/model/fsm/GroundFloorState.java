package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;
import pt.isec.pa.utils.ModelLogs;

import java.util.Random;

class GroundFloorState extends ElevatorStateAdapter{

    protected GroundFloorState(Elevator elevator, ElevatorContext context) {
        super(elevator, context);
        elevator.setCurrentFloor(0);
        ModelLogs.getInstance().addLog("O elevador chegou ao rés do chão\n");
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.GROUND_FLOOR;
    }

    @Override
    public boolean up() {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;

        if(randomInt <= 1) {
            changeState(ElevatorState.BROKEN);
            return false;
        }

        ModelLogs.getInstance().addLog("A subir do GroundFloor para o 1st Floor\n");

        changeState(ElevatorState.FIRST_FLOOR);
        return true;
    }
}
