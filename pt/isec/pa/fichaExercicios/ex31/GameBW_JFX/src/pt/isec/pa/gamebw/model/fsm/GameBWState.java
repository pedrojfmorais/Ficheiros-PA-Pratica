package pt.isec.pa.gamebw.model.fsm;

import pt.isec.pa.gamebw.model.data.GameBWData;
import pt.isec.pa.gamebw.model.fsm.states.BeginState;
import pt.isec.pa.gamebw.model.fsm.states.EndState;
import pt.isec.pa.gamebw.model.fsm.states.LostWaitDecisionState;
import pt.isec.pa.gamebw.model.fsm.states.WaitBetState;

public enum GameBWState {
    BEGIN, WAIT_BET, LOST_WAIT_DECISION, END;

    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {
            case BEGIN -> new BeginState(context,data);
            case WAIT_BET -> new WaitBetState(context,data);
            case LOST_WAIT_DECISION -> new LostWaitDecisionState(context,data);
            case END -> new EndState(context,data);
            //default -> null;
        };
    }
}
