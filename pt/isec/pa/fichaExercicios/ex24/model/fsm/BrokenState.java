package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;
import pt.isec.pa.utils.ModelLogs;

public class BrokenState extends ElevatorStateAdapter{

    protected BrokenState(Elevator elevator, ElevatorContext elevatorContext) {

        super(elevator, elevatorContext);

        ModelLogs.getInstance().addLog("O elevador avariou!\n");
    }

    @Override
    public boolean checkSecurityKey(String str){
        if(!elevator.checkSecurityKey(str))
            return false;

        switch (context.getFloor()){
            case 0 -> changeState(ElevatorState.GROUND_FLOOR);
            case 1 -> changeState(ElevatorState.FIRST_FLOOR);
            case 2 -> changeState(ElevatorState.SECOND_FLOOR);
        }

        ModelLogs.getInstance().addLog("O elevador foi reparado\n");
        return true;
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.BROKEN;
    }
}
