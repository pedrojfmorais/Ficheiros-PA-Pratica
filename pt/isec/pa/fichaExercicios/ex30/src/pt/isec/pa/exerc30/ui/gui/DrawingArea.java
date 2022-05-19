package pt.isec.pa.exerc30.ui.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pt.isec.pa.exerc30.model.Drawing;
import pt.isec.pa.exerc30.model.Figure;

public class DrawingArea extends Canvas {

    Drawing drawing;

    public DrawingArea(Drawing drawing) {
        this.drawing = drawing;

        registerHandlers();
        update();
    }


    private void registerHandlers() {

        this.setOnMousePressed(mouseEvent -> {

//            if(mouseEvent.isControlDown())
//                drawing.setCurrentType(Figure.FigureType.RECTANGLE);
//            else if(mouseEvent.isAltDown())
//                drawing.setCurrentType(Figure.FigureType.OVAL);
//            else
//                drawing.setCurrentType(Figure.FigureType.LINE);
//
//            drawing.setRGB(Math.random(), Math.random(), Math.random());
            drawing.createFigure(mouseEvent.getX(), mouseEvent.getY());
            update();

        });

        this.setOnMouseDragged(mouseEvent -> {

            drawing.updateCurrentFigure(mouseEvent.getX(), mouseEvent.getY());
            update();

        });

        this.setOnMouseReleased(mouseEvent -> {

            drawing.finishCurrentFigure(mouseEvent.getX(), mouseEvent.getY());
            update();

        });
    }

    private void update() {

        GraphicsContext gc = this.getGraphicsContext2D();

        clearScreen(gc);

        for(Figure figure : drawing.getList())
            drawFigure(gc, figure);

        drawFigure(gc, drawing.getCurrentFigure());
    }

    private void clearScreen(GraphicsContext gc) {

        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());

    }

    public void drawFigure(GraphicsContext gc, Figure figure){
        if(figure == null) return;

        Color color = Color.color(figure.getR(), figure.getG(), figure.getB());
        gc.setFill(color);
        gc.setStroke(color.darker());
        gc.setLineWidth(5);

        switch (figure.getType()){

            case LINE -> gc.strokeLine(figure.getX1(), figure.getY1(), figure.getX2(), figure.getY2());
            case RECTANGLE -> {
                gc.fillRect(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                gc.strokeRect(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
            }
            case OVAL -> {
                gc.fillOval(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
                gc.strokeOval(figure.getX1(), figure.getY1(), figure.getWidth(), figure.getHeight());
            }
        }
    }

    public void updateSize(double width, double height){
        setWidth(width);
        setHeight(height);
        update();
    }
}
