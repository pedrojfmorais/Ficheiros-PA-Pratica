package pt.isec.pa.fichaExercicios.ex27.ui;

import pt.isec.pa.fichaExercicios.ex27.model.fsm.GameBWContext;
import pt.isec.pa.utils.PAInput;

public class GameBWUI {
    GameBWContext fsm;

    public GameBWUI(GameBWContext fsm) {
        this.fsm = fsm;
    }

    private boolean finish = false;
    public void start() {
        while(!finish) {
            showResults();
            if (fsm.getState() == null) System.exit(-1); // TODO: remove!
            switch (fsm.getState()) {
                case NOT_PLAYING -> notPlayingUI();
                case BEFORE_BET -> beforeBetUI();
                case LOST_WAITDECISION -> lostWaitDecisionUI();
            }
        }
    }

    private void lostWaitDecisionUI() {
        System.out.println("Lost Bet");
        if(PAInput.chooseOption("What to do?", "Lose White Ball", "Remove Two Balls") == 1)
            fsm.removeWhiteBall();
        else
            fsm.removeTwoRandomBalls();
    }

    private void beforeBetUI() {
        System.out.println("Place Bet");
        if(PAInput.chooseOption("What to do?", "Place Bet", "Stop Game") == 1) {
            if (fsm.placeBet(PAInput.readInt("How much wanna bet?")))
                System.out.println("Won the Bet!");
            else
                System.out.println("Lost the Bet!");
        }
        else
            fsm.stopGame();


    }

    private void notPlayingUI() {
        System.out.println("Main Menu");
        if(PAInput.chooseOption("Begin", "Start Game", "Quit") == 1)
            fsm.startGame();
        else
            finish = true;
    }

    private void showResults() {
        System.out.println("\n*** Game GW ***");
        System.out.printf("White Balls won: %d\n",fsm.getNrWhiteBallsWon());
        System.out.printf("White Balls out: %d\n",fsm.getNrWhiteBallsOut());
        System.out.printf("Black Balls out: %d\n",fsm.getNrBlackBallsOut());
    }
}
