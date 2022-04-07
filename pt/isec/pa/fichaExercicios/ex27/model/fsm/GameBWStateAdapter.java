package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

abstract class GameBWStateAdapter implements IGameBWState {
    GameBWContext context;
    GameBWData data;

    protected GameBWStateAdapter(GameBWContext context, GameBWData data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public boolean startGame() {
        return false;
    }

    @Override
    public boolean placeBet(int nBalls) {
        return false;
    }

    @Override
    public boolean stopGame() {
        return false;
    }

    @Override
    public boolean removeWhiteBall() {
        return false;
    }

    @Override
    public boolean removeTwoRandomBalls() {
        return false;
    }

    protected void changeState(GameBWState newState) {
        context.changeState(newState.createState(context,data));
    }

}
