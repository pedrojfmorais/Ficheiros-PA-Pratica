package pt.isec.pa.four_in_a_row;

import pt.isec.pa.four_in_a_row.model.FourInARowManager;
import pt.isec.pa.four_in_a_row.model.data.FourInARowData;
import pt.isec.pa.four_in_a_row.ui.FourInARowUI;

public class FourInARow {
    public static void main(String[] args) {
        FourInARowManager game = new FourInARowManager(new FourInARowData());
        FourInARowUI gameui= new FourInARowUI(game);
        gameui.start();
    }
}
