package pt.isec.pa.fichaExercicios.ex24;

import pt.isec.pa.fichaExercicios.ex24.model.fsm.ElevatorContext;
import pt.isec.pa.fichaExercicios.ex24.ui.ElevatorUI;

public class ex24 {
    public static void main(String[] args) {
        ElevatorContext fsm = new ElevatorContext();
        ElevatorUI ui = new ElevatorUI(fsm);

        ui.start();
    }
}
