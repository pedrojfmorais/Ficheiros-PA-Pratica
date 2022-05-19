package pt.isec.pa.ex28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pt.isec.pa.ex28.ui.gui.RootPane;

public class JavaFXMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        RootPane borderPane = new RootPane();
        Scene scene = new Scene(borderPane, 600, 400, Color.OLIVE);

        stage.setScene(scene);
        stage.setTitle("Ex29");

        stage.show();

    }
}
