package pt.isec.deis.pa.fichaExercicios.ex24.fsm;

import pt.isec.deis.pa.fichaExercicios.ex24.data.Elevator;

public class ElevatorContext {

    private Elevator elevator;
    private IElevatorState state;

    public ElevatorContext(){
        elevator = new Elevator(0);
        state = new GroundFloorState(elevator, this);
    }

    void changeState(IElevatorState state){this.state = state;}

    public ElevatorState getState(){return state.getState();}

    public boolean up(){return state.up();}
    public boolean down(){return state.down();}

    public int getFloor(){return elevator.getCurrentFloor();}
}
