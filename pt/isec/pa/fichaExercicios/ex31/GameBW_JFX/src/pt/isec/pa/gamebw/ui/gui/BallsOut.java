package pt.isec.pa.gamebw.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.ui.gui.resources.ImageManager;

public class BallsOut extends HBox {
    GameBWManager gameBWManager;
    HBox hbWhite,hbBlack;

    public BallsOut(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(Color.CORNSILK,CornerRadii.EMPTY, Insets.EMPTY)));

        Label lbOut = new Label("Balls Out");
        lbOut.setAlignment(Pos.CENTER);
        lbOut.setMinWidth(100);

        hbWhite = new HBox();
        hbWhite.setAlignment(Pos.CENTER_RIGHT);
        hbWhite.setPrefWidth(Integer.MAX_VALUE);

        hbBlack = new HBox();
        hbBlack.setAlignment(Pos.CENTER_LEFT);
        hbBlack.setPrefWidth(Integer.MAX_VALUE);

        this.getChildren().addAll(hbWhite,lbOut,hbBlack);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
    }

    private void update() {
        hbWhite.getChildren().clear();
        int wb = gameBWManager.getNrWhiteBallsOut();
        for (int i = 0; i < wb; i++) {
            ImageView imageView = new ImageView(ImageManager.getImage("white.png"));
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            hbWhite.getChildren().add(imageView);
        }
        if (wb==0) {
            hbWhite.getChildren().add(new Label("-none-"));
            hbWhite.getChildren().get(0).setId("labelnone");
        }

        hbBlack.getChildren().clear();
        int bb = gameBWManager.getNrBlackBallsOut();
        for (int i = 0; i < bb; i++) {
            ImageView imageView = new ImageView(ImageManager.getImage("black.png"));
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            hbBlack.getChildren().add(imageView);
        }
        if (bb==0) {
            hbBlack.getChildren().add(new Label("-none-"));
            hbBlack.getChildren().get(0).setId("labelnone");
        }
    }
}
