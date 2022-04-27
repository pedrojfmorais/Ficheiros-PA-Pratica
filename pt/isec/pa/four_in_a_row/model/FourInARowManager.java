package pt.isec.pa.four_in_a_row.model;

import pt.isec.pa.four_in_a_row.model.data.FourInARowData;
import pt.isec.pa.four_in_a_row.model.data.Piece;
import pt.isec.pa.four_in_a_row.model.memento.CareTaker;

public class FourInARowManager{

    private FourInARowData data;
    private CareTaker careTaker;

    public FourInARowManager(FourInARowData data) {
        this.data = data;
        this.careTaker = new CareTaker(data);
    }

    public void init() {
        data.init();
    }

    public Piece getCurrentPlayer() {
        return data.getCurrentPlayer();
    }

    public boolean play(int column) {
        careTaker.save();
        return data.play(column);
    }

    public boolean isFull() {
        return data.isFull();
    }

    public Piece checkWinner() {
        return data.checkWinner();
    }

    public void undo() {
        careTaker.undo();
    }

    public void redo() {
        careTaker.redo();
    }

    public void reset() {
        careTaker.reset();
    }

    public boolean hasUndo() {
        return careTaker.hasUndo();
    }

    public boolean hasRedo() {
        return careTaker.hasRedo();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
