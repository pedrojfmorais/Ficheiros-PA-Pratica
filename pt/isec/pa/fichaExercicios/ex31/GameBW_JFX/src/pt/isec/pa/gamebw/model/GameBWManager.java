package pt.isec.pa.gamebw.model;

import pt.isec.pa.gamebw.model.fsm.BetResult;
import pt.isec.pa.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.gamebw.model.fsm.GameBWState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameBWManager {
    private GameBWContext fsm;
    PropertyChangeSupport pcs;

    public GameBWManager() {
        fsm = new GameBWContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    public void start() {
        fsm.start();
        pcs.firePropertyChange(null,null,null);
    }

    public void end() {
        fsm.end();
        pcs.firePropertyChange(null,null,null);
    }

    public BetResult bet(int nr_balls) {
        var ret = fsm.bet(nr_balls);
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public boolean loseWhiteball() {
        var ret = fsm.loseWhiteball();
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public boolean removeTwoBalls() {
        var ret = fsm.removeTwoBalls();
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public GameBWState getState() {
        return fsm.getState();
    }

    public int getNrWhiteBallsWon() {
        return fsm.getNrWhiteBallsWon();
    }

    public int getNrWhiteBallsOut() {
        return fsm.getNrWhiteBallsOut();
    }

    public int getNrBlackBallsOut() {
        return fsm.getNrBlackBallsOut();
    }

    public boolean bagIsEmpty() {
        return fsm.bagIsEmpty();
    }

}
