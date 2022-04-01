package pt.isec.deis.pa.fichaExercicios.ex24;

import pt.isec.deis.pa.fichaExercicios.ex24.fsm.ElevatorContext;
import pt.isec.deis.pa.fichaExercicios.ex24.ui.ElevatorUI;

public class ex24 {
    public static void main(String[] args) {
        ElevatorContext fsm = new ElevatorContext();
        ElevatorUI ui = new ElevatorUI(fsm);

        ui.start();
    }
}
