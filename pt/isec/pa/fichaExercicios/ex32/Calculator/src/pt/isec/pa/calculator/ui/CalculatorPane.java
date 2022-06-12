package pt.isec.pa.calculator.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pt.isec.pa.calculator.model.CalculatorManager;

import java.beans.PropertyChangeSupport;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorPane implements Initializable { // Screen1

    @FXML public Label visor;

    PropertyChangeSupport pcs;
    private CalculatorManager cm;

    public CalculatorPane() {
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visor.setText("0.00");
    }


    public void onButtonNr(ActionEvent actionEvent) {
        cm.addNewDigit(((Button)actionEvent.getSource()).getText());
    }

    public void onButtonOp(ActionEvent actionEvent) {
        cm.setOp(((Button)actionEvent.getSource()).getText());
    }


    public void init(CalculatorManager model) {
        cm = model;
        registerHandlers();
        update();
    }

    private void registerHandlers() {
        if(cm == null) return;
        cm.addListener(evt -> { update(); });
    }
    private void update() {
        if(cm == null) return;
        visor.setText(cm.getDisplay());
    }

    public void onButtonPi(ActionEvent actionEvent) {
        cm.setPi();

    }

    public void onButtonInvert(ActionEvent actionEvent) {
        cm.invertSignal();
    }

    public void onButtonAC(ActionEvent actionEvent) {
        cm.reset();
    }

    public void onButtonPerc(ActionEvent actionEvent) {
        cm.perc();
    }
}
