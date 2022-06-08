package pt.isec.pa.gamebw.model.fsm;

import pt.isec.pa.gamebw.model.data.GameBWData;

public abstract class GameBWStateAdapter implements IGameBWState {
    protected GameBWContext context;
    protected GameBWData data;

    protected GameBWStateAdapter(GameBWContext context, GameBWData data) {
        this.context = context;
        this.data = data;
    }

    protected void changeState(GameBWState newState) {
        context.changeState(newState.createState(context,data));
    }

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }

    @Override
    public BetResult bet(int nr_balls) {
        return BetResult.ERROR;
    }

    @Override
    public boolean loseWhiteball() {
        return false;
    }

    @Override
    public boolean removeTwoBalls() {
        return false;
    }
}
