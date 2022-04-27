package pt.isec.pa.four_in_a_row.model.memento;

import pt.isec.pa.four_in_a_row.model.data.FourInARowData;

public interface IMemento {
    default FourInARowData getSnapshot(){return null;}
}
