package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.fsm.GameBWState;

public interface IGameBWState {
    boolean startGame();

    boolean placeBet(int nBalls);
    boolean stopGame();

    boolean removeWhiteBall();
    boolean removeTwoRandomBalls();

    GameBWState getState();
}
