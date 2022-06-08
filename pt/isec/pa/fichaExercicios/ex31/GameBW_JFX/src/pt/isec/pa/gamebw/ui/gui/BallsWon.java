package pt.isec.pa.gamebw.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.ui.gui.resources.ImageManager;

public class BallsWon extends VBox {
    GameBWManager gameBWManager;
    VBox vbWhite;

    public BallsWon(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        setBackground(new Background(new BackgroundFill(Color.CORNSILK.darker(),CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(10));

        Label lbOut = new Label("Balls Won");
        lbOut.setAlignment(Pos.CENTER);
        lbOut.setMinWidth(100);

        vbWhite = new VBox();
        vbWhite.setAlignment(Pos.CENTER);

        this.getChildren().addAll(lbOut,vbWhite);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
    }

    private void update() {
        vbWhite.getChildren().clear();
        int wb = gameBWManager.getNrWhiteBallsWon();
        for (int i = 0; i < wb; i++) {
            ImageView imageView = new ImageView(ImageManager.getImage("white.png"));
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            vbWhite.getChildren().add(imageView);
        }
        if (wb == 0) {
            vbWhite.getChildren().add(new Label("-none-"));
            vbWhite.getChildren().get(0).setId("labelnone");
        }
    }
}
