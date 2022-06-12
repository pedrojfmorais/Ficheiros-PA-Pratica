package pt.isec.pa.calculator.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pt.isec.pa.calculator.model.CalculatorManager;

public class MainJFX extends Application {
    CalculatorManager model;
    @Override
    public void init() throws Exception {
        super.init();
        model = new CalculatorManager();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Scene scene = new Scene(new BorderPane(new Label("/* TODO */")),400,600);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CalculatorPane.fxml"));
        VBox root = loader.load();
        CalculatorPane cp = loader.getController();
        cp.init(model);
        Scene scene = new Scene(root);
        //stage.setUserData(model);
        stage.setScene(scene);
        stage.setTitle("Calculator@PA");
        stage.show();
    }
}
