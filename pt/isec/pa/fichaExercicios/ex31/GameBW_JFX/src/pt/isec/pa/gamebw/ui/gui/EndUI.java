package pt.isec.pa.gamebw.ui.gui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.model.fsm.GameBWState;

public class EndUI extends BorderPane {
    GameBWManager gameBWManager;
    Button btnStart,btnExit;

    Label lbBrancasFora;
    Label lbPretasFora;
    Label lbBrancasGanhas;


    public EndUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        btnStart = new Button("Start");
        btnStart.setMinWidth(100);
        btnExit  = new Button("Exit");
        btnExit.setMinWidth(100);

        lbBrancasFora = new Label();
        lbPretasFora = new Label();
        lbBrancasGanhas = new Label();

        VBox bolas = new VBox();
        bolas.getChildren().addAll(
                lbBrancasFora,
                lbPretasFora,
                lbBrancasGanhas
        );

        bolas.setAlignment(Pos.CENTER);
        bolas.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY,
                Insets.EMPTY)));

        HBox hBox = new HBox(btnStart,btnExit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(bolas, hBox);

        this.setCenter(vBox);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
        btnStart.setOnAction( event -> {
            gameBWManager.start();
        });
        btnExit.setOnAction( event -> {
            Platform.exit();
        });
    }

    private void update() {
        if (gameBWManager.getState() != GameBWState.END) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        lbBrancasFora.setText("Número bolas brancas tiradas: " + gameBWManager.getNrWhiteBallsOut());
        lbPretasFora.setText("Número bolas pretas tiradas: " + gameBWManager.getNrBlackBallsOut());
        lbBrancasGanhas.setText("Número bolas brancas ganhas: " + gameBWManager.getNrWhiteBallsWon());

    }
}
