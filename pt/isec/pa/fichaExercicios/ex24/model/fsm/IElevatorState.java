package pt.isec.pa.fichaExercicios.ex24.model.fsm;

public interface IElevatorState {

    boolean up();
    boolean down();

    boolean checkSecurityKey(String str);
    ElevatorState getState();

}
