package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

public class notPlayingState extends GameBWStateAdapter{
    protected notPlayingState(GameBWContext context, GameBWData data) {
        super(context, data);
        data.initGame();
    }

    @Override
    public boolean startGame() {
        changeState(GameBWState.BEFORE_BET);
        return true;
    }

    @Override
    public GameBWState getState() {
        return GameBWState.NOT_PLAYING;
    }
}
