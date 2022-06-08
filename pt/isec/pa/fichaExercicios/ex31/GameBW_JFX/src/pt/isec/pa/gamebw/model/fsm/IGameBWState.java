package pt.isec.pa.gamebw.model.fsm;

public interface IGameBWState {
    void start();
    void end();
    BetResult bet(int nr_balls);
    boolean loseWhiteball();
    boolean removeTwoBalls();

    GameBWState getState();
}
