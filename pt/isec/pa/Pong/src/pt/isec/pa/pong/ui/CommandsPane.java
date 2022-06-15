package pt.isec.pa.pong.ui;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import pt.isec.pa.pong.model.Game;

import java.net.URL;
import java.util.ResourceBundle;

class CommandViewMode{
    Game game;
    BooleanProperty cantStart, cantPause, cantResume;

    public CommandViewMode(Game game) {
        this.game = game;

        cantStart = new SimpleBooleanProperty(false);
        cantPause = new SimpleBooleanProperty(false);
        cantResume = new SimpleBooleanProperty(false);

        game.addListener(Game.PROP_GAME, evt -> Platform.runLater(() -> {
            cantStart.set(game.isGameActive());
            cantPause.set(!game.isGameActive() || game.isGamePaused());
            cantResume.set(!game.isGameActive() || !game.isGamePaused());
        }));
    }

    public void start() {
        game.initGame();
    }

    public void pause() {
        game.pauseGame();
    }

    public void resume() {
        game.resumeGame();
    }
}

public class CommandsPane implements Initializable {
    public HBox root;
    public Button btnStart;
    public Button btnPause;
    public Button btnResume;
    CommandViewMode gameVM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.sceneProperty().addListener((observableValue, olsScene, newScene) -> {
            gameVM = new CommandViewMode((Game) newScene.getUserData());
            registerHandlers();
            update();
        });
    }

    private void registerHandlers() {
        btnStart.disableProperty().bind(gameVM.cantStart);
        btnPause.disableProperty().bind(gameVM.cantPause);
        btnResume.disableProperty().bind(gameVM.cantResume);
    }

    private void update() {
    }

    public void onStart(ActionEvent ignoredEvent) {
        gameVM.start();
    }

    public void onPause(ActionEvent ignoredEvent) {
        gameVM.pause();
    }

    public void onResume(ActionEvent ignoredEvent) {
        gameVM.resume();
    }
}
