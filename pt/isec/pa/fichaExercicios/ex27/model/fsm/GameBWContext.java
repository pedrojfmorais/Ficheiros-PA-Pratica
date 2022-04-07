package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

public class GameBWContext {
    IGameBWState state;
    GameBWData data;

    public GameBWContext() {
        data = new GameBWData();
        state = GameBWState.NOT_PLAYING.createState(this,data);
    }

    void changeState(IGameBWState newState) {
        state = newState;
    }

    // getters
    public GameBWState getState() {
        if (state == null)
            return null;
        return state.getState();
    }

    public int getNrWhiteBallsWon() {
        return data.getNrWhiteBallsWon();
    }

    public int getNrWhiteBallsOut() {
        return data.getNrWhiteBallsOut();
    }

    public int getNrBlackBallsOut() {
        return data.getNrBlackBallsOut();
    }

    public boolean bagIsEmpty() {
        return data.bagIsEmpty();
    }

    public boolean startGame() {
        return state.startGame();
    }

    public boolean placeBet(int nBalls) {
        return state.placeBet(nBalls);
    }

    public boolean stopGame() {
        return state.stopGame();
    }

    public boolean removeWhiteBall() {
        return state.removeWhiteBall();
    }

    public boolean removeTwoRandomBalls() {
        return state.removeTwoRandomBalls();
    }
}
