package pt.isec.pa.calculator.model;

import pt.isec.pa.calculator.model.data.Calculator;
import pt.isec.pa.calculator.model.data.Operator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatorManager {
    private Calculator calculator;
    PropertyChangeSupport pcs;

    public CalculatorManager() {
        calculator = new Calculator();
        pcs = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public boolean addNewDigit(String digit) {
        boolean ret = calculator.addNewDigit(digit);
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public boolean setOp(String newop) {
        boolean ret =  calculator.setOp(Operator.getOp(newop));
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public String getDisplay() {
        return calculator.getDisplay();
    }

    public void reset() {
        calculator.reset();
        pcs.firePropertyChange(null,null,null);
    }

    public void invertSignal() {
        calculator.invertSignal();
        pcs.firePropertyChange(null,null,null);
    }

    public void setPi() {
        calculator.setPi();
        pcs.firePropertyChange(null,null,null);
    }

    public void perc() {
        calculator.perc();
        pcs.firePropertyChange(null,null,null);
    }
}
