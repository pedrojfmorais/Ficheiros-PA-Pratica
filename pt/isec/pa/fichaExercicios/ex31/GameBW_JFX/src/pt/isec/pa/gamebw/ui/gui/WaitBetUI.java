package pt.isec.pa.gamebw.ui.gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import pt.isec.pa.gamebw.model.GameBWManager;
import pt.isec.pa.gamebw.model.fsm.BetResult;
import pt.isec.pa.gamebw.model.fsm.GameBWState;
import pt.isec.pa.gamebw.ui.gui.util.ToastMessage;

public class WaitBetUI extends AnchorPane {
    GameBWManager gameBWManager;
    TilePane tilePane;
    Button btns[];
    Button btnEnd;

    public WaitBetUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        tilePane = new TilePane(Orientation.HORIZONTAL);
        tilePane.setPrefColumns(3);
        tilePane.setPrefTileHeight(80);
        tilePane.setPrefTileWidth(80);
        FlowPane auxPane = new FlowPane(tilePane);
        auxPane.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(auxPane,0.0);
        AnchorPane.setBottomAnchor(auxPane,0.0);
        AnchorPane.setLeftAnchor(auxPane,0.0);
        AnchorPane.setRightAnchor(auxPane,0.0);

        btnEnd = new Button("End game");

        AnchorPane.setRightAnchor(btnEnd,10.0);
        AnchorPane.setBottomAnchor(btnEnd,10.0);
        this.getChildren().addAll(auxPane,btnEnd);

        btns = new Button[11];
        for(int i=0;i<btns.length;i++) {
            btns[i] = new Button("" + i);
            btns[i].setUserData(i);
            btns[i].setMinSize(60, 60);
            tilePane.getChildren().add(btns[i]);
        }
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
        for(int i=0;i<btns.length;i++) {
            btns[i].setOnAction(t);
        }
        btnEnd.setOnAction(event -> {
            gameBWManager.end();
        });
    }

    EventHandler<ActionEvent> t = new EventHandler() {
        @Override
        public void handle(Event event) {
            if ( ((Button) event.getSource()).getUserData() instanceof Integer bet) {
                BetResult result = gameBWManager.bet(bet);
                ToastMessage.show(getScene().getWindow(),"Bet result: "+result);
            }
        }
    };

    private void update() {
        if (gameBWManager.getState() != GameBWState.WAIT_BET) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
        int nrW = gameBWManager.getNrWhiteBallsWon();
        for(int i=0;i < btns.length;i++) {
            btns[i].setDisable(i>nrW);
        }
    }
}

/*public class WaitBetUI extends VBox {
    GameBWManager gameBWManager;
    TilePane tilePane;
    Button btns[];

    public WaitBetUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        this.setFillWidth(false);
        tilePane = new TilePane(Orientation.HORIZONTAL);
        tilePane.setPrefColumns(3);
        tilePane.setPrefTileHeight(80);
        tilePane.setPrefTileWidth(80);
        setAlignment(Pos.CENTER);
        this.getChildren().add(tilePane);

        btns = new Button[11];
        for(int i=0;i<btns.length;i++) {
            btns[i] = new Button("" + i);
            btns[i].setUserData(i);
            btns[i].setMinSize(60, 60);
            tilePane.getChildren().add(btns[i]);
        }
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
        for(int i=0;i<btns.length;i++) {
            btns[i].setOnAction(t);
        }
    }

    EventHandler<ActionEvent> t = new EventHandler() {
        @Override
        public void handle(Event event) {
            if ( ((Button) event.getSource()).getUserData() instanceof Integer bet) {
                BetResult result = gameBWManager.bet(bet);
                ToastMessage.show(getScene().getWindow(),"Bet result: "+result);
            }
        }
    };

    private void update() {
        if (gameBWManager.getState() != GameBWState.WAIT_BET) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
        int nrW = gameBWManager.getNrWhiteBallsWon();
        for(int i=0;i < btns.length;i++) {
            btns[i].setDisable(i>nrW);
        }
    }
}*/
