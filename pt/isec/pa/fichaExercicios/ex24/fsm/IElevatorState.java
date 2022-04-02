package pt.isec.pa.fichaExercicios.ex24.fsm;

public interface IElevatorState {

    boolean up();
    boolean down();

    ElevatorState getState();
}
