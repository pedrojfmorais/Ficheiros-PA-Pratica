package pt.isec.pa.gamebw.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.model.fsm.GameBWState;

public class LostWaitDecisionUI extends BorderPane {
    GameBWManager gameBWManager;
    Button btnLose,btnRemove;

    public LostWaitDecisionUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        btnLose = new Button("Lose white ball");
        btnLose.setMinWidth(200);
        btnRemove  = new Button("Remove from bag");
        btnRemove.setMinWidth(200);
        VBox vBox = new VBox(btnLose,btnRemove);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        this.setCenter(vBox);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
        btnLose.setOnAction(event -> {
            gameBWManager.loseWhiteball();
        });
        btnRemove.setOnAction(event -> {
            gameBWManager.removeTwoBalls();
        });
    }

    private void update() {
        if (gameBWManager.getState() != GameBWState.LOST_WAIT_DECISION) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        btnLose.setDisable(gameBWManager.getNrWhiteBallsWon()<1);
        btnRemove.setDisable(gameBWManager.bagIsEmpty());
    }
}
