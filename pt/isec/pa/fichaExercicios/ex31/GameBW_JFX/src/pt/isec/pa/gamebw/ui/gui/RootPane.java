package pt.isec.pa.gamebw.ui.gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.ui.gui.resources.CSSManager;
import pt.isec.pa.gamebw.ui.gui.resources.ImageManager;

public class RootPane extends BorderPane {
    GameBWManager gameBWManager;
    Node RIGHT, BOTTOM;

    public RootPane(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        CSSManager.applyCSS(this,"styles.css");
        StackPane stackPane = new StackPane(
                new BeginUI(gameBWManager),
                new WaitBetUI(gameBWManager),
                new LostWaitDecisionUI(gameBWManager),
                new EndUI(gameBWManager)
        );
        stackPane.setBackground(new Background(new BackgroundImage(
                ImageManager.getImage("background.png"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1,1,true,true,true,false)
        )));
        this.setCenter(stackPane);

        RIGHT = new BallsWon(gameBWManager);
        BOTTOM = new BallsOut(gameBWManager);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
    }

    private void update() {
        switch (gameBWManager.getState()) {
            case WAIT_BET, LOST_WAIT_DECISION -> {
                this.setRight(RIGHT);
                this.setBottom(BOTTOM);
            }
            default -> {
                this.setRight(null);
                this.setBottom(null);
            }
        }
    }
}
