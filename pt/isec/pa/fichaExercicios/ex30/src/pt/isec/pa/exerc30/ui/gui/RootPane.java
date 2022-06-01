package pt.isec.pa.exerc30.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pt.isec.pa.exerc30.model.DrawingManager;

public class RootPane extends BorderPane {
    DrawingManager drawing;
    DrawingArea drawingArea;
    Pane areaPane;

    public RootPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        drawingArea = new DrawingArea(drawing);
        areaPane = new Pane(drawingArea);
        setCenter(areaPane);

        setTop(
                new VBox(
                        new AppMenu(drawing),
                        new DrawingToolbar(drawing)
                )
        );
    }

    private void registerHandlers() {
        areaPane.widthProperty().addListener(observable ->
                drawingArea.updateSize(areaPane.getWidth(), areaPane.getHeight())
        );
        areaPane.heightProperty().addListener(observable ->
                drawingArea.updateSize(areaPane.getWidth(), areaPane.getHeight())
        );
    }

    private void update() {
    }
}
