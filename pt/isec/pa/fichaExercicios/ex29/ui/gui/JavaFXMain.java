package pt.isec.pa.ex29.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.ex29.models.Elipse;
import pt.isec.pa.ex29.models.Figura;
import pt.isec.pa.ex29.models.Retangulo;
import pt.isec.pa.ex29.ui.gui.RootPane;

public class JavaFXMain extends Application {

    Elipse ret;

    @Override
    public void init() throws Exception {
        super.init();
        ret = new Elipse();
    }

    @Override
    public void start(Stage stage) throws Exception {
        RootPane rootPane = new RootPane(ret);

        Scene scene = new Scene(rootPane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("DEIS-ISEC");
        stage.show();

    }


}
