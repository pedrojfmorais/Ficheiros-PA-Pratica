package pt.isec.pa.fichaExercicios.ex27;

import pt.isec.pa.fichaExercicios.ex27.model.fsm.GameBWContext;
import pt.isec.pa.fichaExercicios.ex27.ui.GameBWUI;

public class ex27 {
    public static void main(String[] args) {
        GameBWContext fsm = new GameBWContext();
        GameBWUI ui = new GameBWUI(fsm);
        ui.start();
    }
}
