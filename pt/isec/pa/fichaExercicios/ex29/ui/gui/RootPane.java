package pt.isec.pa.ex29.ui.gui;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import pt.isec.pa.ex29.models.Elipse;
import pt.isec.pa.ex29.models.Figura;
import pt.isec.pa.ex29.models.Retangulo;

public class RootPane extends Pane {

    Elipse ret;

    Rectangle rectangle;

    Ellipse ellipse;

    double ctrlCenterX, ctrlCenterY;

    public RootPane(Elipse ret) {
        this.ret = ret;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        rectangle = new Rectangle();
        rectangle.setStrokeWidth(2);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(null);

        ellipse = new Ellipse();
        ellipse.setStrokeWidth(2);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(null);

        getChildren().addAll(rectangle, ellipse);


    }

    private void registerHandlers() {

        /*rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.out.println("Cliquei no retângulo");
            figura.setRGB(Math.random(), Math.random(), Math.random());
            update();
        });*/

        this.setOnMouseMoved(mouseEvent -> {
            System.out.println("MOVED");
        });

        this.setOnMousePressed(mouseEvent -> {
            if(!mouseEvent.isControlDown()) {
                ret.setP1(mouseEvent.getX(), mouseEvent.getY());
                ret.setP2(mouseEvent.getX(), mouseEvent.getY());
            }
            else {
                ctrlCenterX = mouseEvent.getX();
                ctrlCenterY = mouseEvent.getY();
            }
            update();

            //System.out.println("PRESSED");
        });

        this.setOnMouseDragged(mouseEvent -> {

            if(!mouseEvent.isControlDown()) {
                ret.setP2(mouseEvent.getX(), mouseEvent.getY());
            }
            else {
                ret.setPs(ctrlCenterX, ctrlCenterY, mouseEvent.getX(), mouseEvent.getY());
            }
            update();

            //System.out.println("DRAGGED");
        });

        this.setOnMouseReleased(mouseEvent -> {
            if(!mouseEvent.isControlDown()) {
                ret.setP2(mouseEvent.getX(), mouseEvent.getY());
            }
            else {
                ret.setPs(ctrlCenterX, ctrlCenterY, mouseEvent.getX(), mouseEvent.getY());
            }
            update();

            //System.out.println("RELEASED");
        });

        /*
        ---------- IGNORAR ISTO QUE NÃO FUNCIONA ----------
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
        //this.setOnKeyPressed(keyEvent -> {

            if( keyEvent.getCode() == KeyCode.ENTER) {
                rectangle.setFill(Color.color(ret.getR(), ret.getG(), ret.getB()));
                System.out.println("Pressed Control");
            }
            System.out.println("Not Pressed Control");
            update();
        });*/

    }

    private void update() {

        rectangle.setX(ret.getMinX());
        rectangle.setY(ret.getMinY());
        rectangle.setWidth(ret.getWidth());
        rectangle.setHeight(ret.getHeight());
        // rectangle.setFill(Color.color(ret.getR(), ret.getG(), ret.getB()));
        ret.setRGB(Math.random(), Math.random(), Math.random());


        ret.setRadius();
        // Definir o centro e depois o raio
        ellipse.setCenterX(ret.getCenterX());
        ellipse.setCenterY(ret.getCenterY());
        ellipse.setRadiusX(ret.getRx());
        ellipse.setRadiusY(ret.getRy());
        ellipse.setFill(Color.RED);



    }
}
