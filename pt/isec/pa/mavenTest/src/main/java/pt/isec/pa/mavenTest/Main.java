package pt.isec.pa.mavenTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Pane(), 500, 500, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Maven");
        stage.show();
    }
}
