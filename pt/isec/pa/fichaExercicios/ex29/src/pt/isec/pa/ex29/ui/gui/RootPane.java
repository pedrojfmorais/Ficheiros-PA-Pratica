package pt.isec.pa.ex29.ui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RootPane extends BorderPane {

    int nrBlue;
    Color backgroundColor = Color.GREEN;

    Button btnBlue;
    TextField tfColor = new TextField();
    Label lbStatus;
    public RootPane(){
        nrBlue = 0;
        createViews();
        registerHandlers();
        update();
    }

    public void createViews(){
        btnBlue = new Button("Blue");

        btnBlue.setMinWidth(75);

        tfColor = new TextField();
        tfColor.setPromptText("Color name or rgb");
        tfColor.setPrefWidth(Integer.MAX_VALUE);
        tfColor.setMinWidth(200);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnBlue, tfColor);
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
    }

    public void update(){
        this.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        lbStatus.setText("BLUE: " + nrBlue);
    }

}
