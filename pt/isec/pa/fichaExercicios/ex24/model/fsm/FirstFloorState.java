package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;
import pt.isec.pa.utils.ModelLogs;

import java.util.Random;

class FirstFloorState extends ElevatorStateAdapter{

    protected FirstFloorState(Elevator elevator, ElevatorContext elevatorContext) {
        super(elevator, elevatorContext);
        elevator.setCurrentFloor(1);
        ModelLogs.getInstance().addLog("O elevador chegou ao 1 andar\n");
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.FIRST_FLOOR;
    }

    @Override
    public boolean up() {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;

        if(randomInt <= 2) {
            changeState(ElevatorState.BROKEN);
            return false;
        }

        ModelLogs.getInstance().addLog("A subir do 1st Floor para o 2nd Floor\n");
        changeState(ElevatorState.SECOND_FLOOR);
        return true;
    }

    @Override
    public boolean down() {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;

        if(randomInt <= 2) {
            changeState(ElevatorState.BROKEN);
            return false;
        }

        ModelLogs.getInstance().addLog("A descer do 1st Floor para o GroundFloor\n");
        changeState(ElevatorState.GROUND_FLOOR);
        return true;
    }
}
