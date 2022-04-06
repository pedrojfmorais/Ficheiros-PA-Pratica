package pt.isec.pa.fichaExercicios.ex24.model.fsm;

import pt.isec.pa.fichaExercicios.ex24.model.data.Elevator;

public class ElevatorContext {

    private Elevator elevator;
    private IElevatorState state;

    public ElevatorContext(){
        elevator = new Elevator(0);
        state = new GroundFloorState(elevator, this);
    }

    void changeState(IElevatorState state){this.state = state;}

    public ElevatorState getState(){return state.getState();}

    public boolean checkSecurityKey(String str){return state.checkSecurityKey(str);}

    public boolean up(){return state.up();}
    public boolean down(){return state.down();}

    public int getFloor(){return elevator.getCurrentFloor();}
}
