package pt.isec.deis.pa.fichaExercicios.ex24.fsm;

public interface IElevatorState {

    boolean up();
    boolean down();

    ElevatorState getState();
}
