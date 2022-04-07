package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

public class lostWaitDecisionState extends GameBWStateAdapter{
    protected lostWaitDecisionState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public boolean removeWhiteBall() {
        if(data.betLost_optionWhite()) {
            if(!context.bagIsEmpty()) {
                changeState(GameBWState.BEFORE_BET);
                return true;
            }
        }

        changeState(GameBWState.NOT_PLAYING);
        return false;
    }

    @Override
    public boolean removeTwoRandomBalls() {
        if(context.bagIsEmpty()) {
            changeState(GameBWState.NOT_PLAYING);
            return false;
        }
        data.betLost_optionTwoBalls();

        changeState(GameBWState.BEFORE_BET);
        return true;
    }

    @Override
    public GameBWState getState() {
        return GameBWState.LOST_WAITDECISION;
    }
}
