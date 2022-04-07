package pt.isec.pa.fichaExercicios.ex27.model.fsm;

import pt.isec.pa.fichaExercicios.ex27.model.data.GameBWData;

public enum GameBWState {
    NOT_PLAYING, BEFORE_BET, LOST_WAITDECISION;

    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {
            case NOT_PLAYING -> new notPlayingState(context, data);
            case BEFORE_BET -> new beforeBetState(context, data);
            case LOST_WAITDECISION -> new lostWaitDecisionState(context, data);
        };
    }
}
