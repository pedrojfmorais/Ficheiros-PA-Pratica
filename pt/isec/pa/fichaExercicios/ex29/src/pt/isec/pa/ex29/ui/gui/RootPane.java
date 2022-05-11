package pt.isec.pa.ex29.ui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RootPane extends BorderPane {

    int nrBlue;
    int nrGreen;
    int nrOther;
    Color backgroundColor = Color.GREEN;

    Button btnBlue;
    Button btnGreen;
    Button btnSetColor;
    TextField tfColor = new TextField();
    Label lbStatus;
    public RootPane(){
        nrBlue = 0;
        nrGreen = 0;
        nrOther = 0;

        createViews();
        registerHandlers();
        update();
    }

    public void createViews(){
        btnBlue = new Button("Blue");
        btnBlue.setMinWidth(75);

        btnGreen = new Button("Green");
        btnGreen.setMinWidth(75);

        btnSetColor = new Button("Set Color");
        btnSetColor.setMinWidth(75);

        tfColor = new TextField();
        tfColor.setPromptText("Color name or rgb");
        tfColor.setPrefWidth(Integer.MAX_VALUE);
        tfColor.setMinWidth(200);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnBlue, btnGreen, tfColor, btnSetColor);
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);

        this.setTop(hbox);

        lbStatus = new Label();
        lbStatus.setPrefWidth(Integer.MAX_VALUE);
        lbStatus.setStyle("-fx-background-color: #d0d0d0; -fx-font-size: 16; -fx-font-family: 'Roboto Light'");
        lbStatus.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        lbStatus.setPadding(new Insets(10));
        this.setBottom(lbStatus);
    }

    public void registerHandlers(){

        btnBlue.setOnAction(actionEvent -> {
            backgroundColor = Color.BLUE;
            nrBlue++;
            update();
        });

        btnGreen.setOnAction(actionEvent -> {
            backgroundColor = Color.GREEN;
            nrGreen++;
            update();
        });

        btnSetColor.setOnAction(actionEvent -> {
            try{
                backgroundColor = Color.valueOf(tfColor.getText());
                nrOther++;
                update();

                tfColor.setStyle("-fx-control-inner-background: white");

            }catch (IllegalArgumentException e){
                tfColor.setStyle("-fx-background-color: red");
                tfColor.requestFocus();
            }

        });

        //Duas formas para detetar o enter no textfield
        //tfColor.setOnAction(btnSetColor.getOnAction());

        tfColor.setOnKeyPressed(keyEvent ->{
            if(keyEvent.getCode() == KeyCode.ENTER)
                btnSetColor.fire();
        });
    }

    public void update(){
        this.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        lbStatus.setText("BLUE: " + nrBlue + "\tGreen: " + nrGreen + "\tOther: " + nrOther);
    }
}
