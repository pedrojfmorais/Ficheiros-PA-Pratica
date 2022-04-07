package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

public class beforeBetState extends GameBWStateAdapter{


    protected beforeBetState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public boolean placeBet(int nBalls) {
        if(!data.bet(nBalls)) {
            return false;
        }

        switch (data.getBall()){
            case BLACK -> {
                data.betLost();

                if(context.bagIsEmpty()) //TODO: && numero bolas brancas == 0
                    changeState(GameBWState.NOT_PLAYING);
                else
                    changeState(GameBWState.LOST_WAITDECISION);
                return false;
            }
            case WHITE -> {
                data.betWon();

                if(context.bagIsEmpty()){
                    changeState(GameBWState.NOT_PLAYING);
                }
                return true;
            }
            case NONE -> {
                changeState(GameBWState.NOT_PLAYING);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean stopGame() {
        changeState(GameBWState.NOT_PLAYING);
        return true;
    }

    @Override
    public GameBWState getState() {
        return GameBWState.BEFORE_BET;
    }
}
