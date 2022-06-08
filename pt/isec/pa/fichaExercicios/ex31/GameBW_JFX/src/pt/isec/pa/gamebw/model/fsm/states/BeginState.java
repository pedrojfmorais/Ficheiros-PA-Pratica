package pt.isec.pa.gamebw.model.fsm.states;

import pt.isec.pa.gamebw.model.data.GameBWData;
import pt.isec.pa.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.gamebw.model.fsm.GameBWState;
import pt.isec.pa.gamebw.model.fsm.GameBWStateAdapter;

public class BeginState extends GameBWStateAdapter {
    public BeginState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public void start() {
        data.initGame();
        changeState(GameBWState.WAIT_BET);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.BEGIN;
    }
}
