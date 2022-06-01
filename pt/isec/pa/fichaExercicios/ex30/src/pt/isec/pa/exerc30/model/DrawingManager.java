package pt.isec.pa.exerc30.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.List;

public class DrawingManager {

    public static final String PROP_TOOLS = "_tools_";
    public static final String PROP_FIGURES = "_figures_";

    Drawing drawing;
    PropertyChangeSupport pcs;

    public DrawingManager() {
        this.drawing = new Drawing();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener listener){
        pcs.addPropertyChangeListener(property, listener);
    }

    public double getR() {
        return drawing.getR();
    }
    public double getG() {
        return drawing.getG();
    }
    public double getB() {
        return drawing.getB();
    }

    public void setRGB(double r, double g, double b) {
        drawing.setRGB(r, g, b);
        pcs.firePropertyChange(PROP_TOOLS, null, null);
    }

    public Figure.FigureType getCurrentType() {
        return drawing.getCurrentType();
    }

    public void setCurrentType(Figure.FigureType currentType) {
        drawing.setCurrentType(currentType);
        pcs.firePropertyChange(PROP_TOOLS, null, null);
    }

    public void createFigure(double x, double y) {
        drawing.createFigure(x, y);
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public void updateCurrentFigure(double x, double y) {
        drawing.updateCurrentFigure(x, y);
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public void finishCurrentFigure(double x, double y) {
        drawing.finishCurrentFigure(x, y);
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public Figure getCurrentFigure() {
        return drawing.getCurrentFigure();
    }

    public List<Figure> getList() {
        return drawing.getList();
    }

    public void clearAll() {
        drawing.clearAll();
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public void removeLast() {
        drawing.removeLast();
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public void remove(int index) {
        drawing.remove(index);
        pcs.firePropertyChange(PROP_FIGURES, null, null);
    }

    public void load(File hFile){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(hFile))){

            drawing = (Drawing) ois.readObject();

            pcs.firePropertyChange(PROP_FIGURES, null, null);
            pcs.firePropertyChange(PROP_TOOLS, null, null);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(File hFile){
        try(ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(hFile))) {

            oos.writeObject(drawing);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
