package pt.isec.pa.exerc30.ui.gui;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import pt.isec.pa.exerc30.model.DrawingManager;
import pt.isec.pa.exerc30.model.Figure;

public class ListPane extends ListView<Figure> {

    DrawingManager drawing;
    MenuItem delete, change;

    public ListPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        delete = new MenuItem("Delete");
        change = new MenuItem("Change color");

        this.setContextMenu(new ContextMenu(delete, change));
    }

    public void registerHandlers(){
        drawing.addPropertyChangeListener(DrawingManager.PROP_FIGURES, evt -> update());

        delete.setOnAction(actionEvent -> {
            drawing.remove(this.getSelectionModel().getSelectedIndex());
        });

        this.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getClickCount() == 2) {
                delete.fire();
//                drawing.remove(this.getSelectionModel().getSelectedIndex());
            }
        });
    }

    public void update(){
        this.getItems().clear();
        this.getItems().addAll(drawing.getList());
    }
}
