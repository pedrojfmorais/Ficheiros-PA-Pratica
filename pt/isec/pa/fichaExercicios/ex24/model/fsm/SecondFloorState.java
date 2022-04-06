package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;
import pt.isec.pa.utils.ModelLogs;

import java.util.Random;

class SecondFloorState extends ElevatorStateAdapter{
    protected SecondFloorState(Elevator elevator, ElevatorContext elevatorContext) {
        super(elevator, elevatorContext);
        elevator.setCurrentFloor(2);
        ModelLogs.getInstance().addLog("O elevador chegou ao 2 andar\n");
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.SECOND_FLOOR;
    }

    @Override
    public boolean down() {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;

        if(randomInt <= 3) {
            changeState(ElevatorState.BROKEN);
            return false;
        }

        ModelLogs.getInstance().addLog("A descer do 2nd Floor para o 1st Floor\n");
        changeState(ElevatorState.FIRST_FLOOR);
        return true;
    }
}
