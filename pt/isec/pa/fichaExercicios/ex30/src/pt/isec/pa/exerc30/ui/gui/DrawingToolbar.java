package pt.isec.pa.exerc30.ui.gui;

import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import pt.isec.pa.exerc30.model.DrawingManager;
import pt.isec.pa.exerc30.model.Figure;

public class DrawingToolbar extends ToolBar{

    private static final int TOGGLE_SIZE = 40;
    private static final int TOGGLE_IMG_SIZE = TOGGLE_SIZE - 10;

    DrawingManager drawing;
    Rectangle rectRandom;
    ToggleButton btnRed, btnRandom;
    ToggleButton btnLine, btnRect, btnOval;

    ColorPicker colorPicker;

    public DrawingToolbar(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        Rectangle rectR = new Rectangle(0, 0, TOGGLE_IMG_SIZE, TOGGLE_IMG_SIZE);
        rectR.setFill(Color.color(1, 0, 0));

        rectRandom = new Rectangle(0, 0, TOGGLE_IMG_SIZE, TOGGLE_IMG_SIZE);

        btnRed = new ToggleButton(null, rectR);
        btnRed.setPrefSize(TOGGLE_SIZE, TOGGLE_SIZE);

        btnRandom = new ToggleButton("Random", rectRandom);
        btnRandom.setPrefHeight(TOGGLE_SIZE);

        colorPicker = new ColorPicker();
        colorPicker.setPrefHeight(TOGGLE_SIZE);

        Line shLine = new Line(0, 0, TOGGLE_IMG_SIZE, TOGGLE_IMG_SIZE);
        shLine.setFill(Color.BLACK);

        Rectangle shRect = new Rectangle(0, 0 , TOGGLE_IMG_SIZE, TOGGLE_IMG_SIZE);
        shRect.setFill(Color.DEEPPINK);

        Ellipse shOval = new Ellipse(0, 0 , TOGGLE_IMG_SIZE / 2, TOGGLE_IMG_SIZE / 2);
        shOval.setFill(Color.DARKKHAKI);

        btnLine = new ToggleButton(null, shLine);
        btnLine.setPrefSize(TOGGLE_SIZE, TOGGLE_SIZE);

        btnRect = new ToggleButton(null, shRect);
        btnRect.setPrefSize(TOGGLE_SIZE, TOGGLE_SIZE);

        btnOval = new ToggleButton(null, shOval);
        btnOval.setPrefSize(TOGGLE_SIZE, TOGGLE_SIZE);

        ToggleGroup colorsGroup = new ToggleGroup();
        ToggleGroup shapesGroup = new ToggleGroup();

        btnRed.setToggleGroup(colorsGroup);
        btnRandom.setToggleGroup(colorsGroup);

        btnLine.setToggleGroup(shapesGroup);
        btnRect.setToggleGroup(shapesGroup);
        btnOval.setToggleGroup(shapesGroup);

        this.getItems().addAll(btnRed, btnRandom, colorPicker, new Separator(), btnLine, btnRect, btnOval);
    }

    private void registerHandlers() {


        drawing.addPropertyChangeListener(DrawingManager.PROP_TOOLS, evt -> update());

        btnRed.setOnAction(actionEvent -> {
            drawing.setRGB(1, 0, 0);
//            update();
        });

        btnRandom.setOnAction(actionEvent -> {
            drawing.setRGB(Math.random(), Math.random(), Math.random());
//            update();
        });

        colorPicker.setOnAction(actionEvent -> {
            Color color = colorPicker.getValue();
            drawing.setRGB(color.getRed(), color.getGreen(), color.getBlue());
//            update();
        });

        btnLine.setOnAction(actionEvent -> drawing.setCurrentType(Figure.FigureType.LINE));
        btnRect.setOnAction(actionEvent -> drawing.setCurrentType(Figure.FigureType.RECTANGLE));
        btnOval.setOnAction(actionEvent -> drawing.setCurrentType(Figure.FigureType.OVAL));

        btnRed.fire();
        btnLine.fire();
    }

    private void update() {
        Color color = Color.color(drawing.getR(), drawing.getG(), drawing.getB());
        rectRandom.setFill(color);
        colorPicker.setValue(color);

        if(Color.color(1, 0, 0).equals(color))
            btnRed.setSelected(true);
        else
            btnRandom.setSelected(true);

        switch (drawing.getCurrentType()){
            case LINE -> btnLine.setSelected(true);
            case RECTANGLE -> btnRect.setSelected(true);
            case OVAL -> btnOval.setSelected(true);
        }
    }
}
