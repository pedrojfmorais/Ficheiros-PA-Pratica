package pt.isec.pa.exerc30.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.exerc30.model.Drawing;
import pt.isec.pa.exerc30.model.DrawingManager;

public class MainJFX extends Application {
    DrawingManager drawing;

    @Override
    public void init() throws Exception {
        super.init();
        drawing = new DrawingManager();
    }

    @Override
    public void start(Stage stage) throws Exception {
        configureStage(stage, -1 , -1);
        configureStage(new Stage(), 0, stage.getY());
        configureListPane(stage.getX()+stage.getWidth(), stage.getY());
    }

    private void configureStage(Stage stage, double x, double y){
        RootPane root = new RootPane(drawing);
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Drawing@PA");
        if(x >= 0 && y >= 0) {
            stage.setX(x);
            stage.setY(y);
        }
        stage.show();
    }

    private void configureListPane(double x, double y){
        Stage stage = new Stage();
        ListPane listPane = new ListPane(drawing);
        Scene scene = new Scene(listPane,300,400);
        stage.setScene(scene);
        stage.setTitle("Lista de Figuras");
        if(x >= 0 && y >= 0) {
            stage.setX(x);
            stage.setY(y);
        }
        stage.show();
    }
}
