package pt.isec.pa.gamebw.model.fsm.states;

import pt.isec.pa.gamebw.model.data.BallType;
import pt.isec.pa.gamebw.model.data.GameBWData;
import pt.isec.pa.gamebw.model.fsm.BetResult;
import pt.isec.pa.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.gamebw.model.fsm.GameBWState;
import pt.isec.pa.gamebw.model.fsm.GameBWStateAdapter;

public class WaitBetState extends GameBWStateAdapter {
    public WaitBetState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public BetResult bet(int nr_balls) {
        if (!data.bet(nr_balls))
            return BetResult.ERROR;

        BallType ball = data.getBall();
        switch (ball) {
            case WHITE -> {
                data.betWon();
                changeState(data.bagIsEmpty() ? GameBWState.END : GameBWState.WAIT_BET);
                return BetResult.WON;
            }
            case BLACK -> {
                data.betLost();
                changeState(data.bagIsEmpty() && data.getNrWhiteBallsWon()<1 ? GameBWState.END : GameBWState.LOST_WAIT_DECISION);
                return BetResult.LOST;
            }
            case NONE -> changeState(GameBWState.END);
        }
        return BetResult.ERROR;
    }

    @Override
    public void end() {
        changeState(GameBWState.END);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.WAIT_BET;
    }
}
