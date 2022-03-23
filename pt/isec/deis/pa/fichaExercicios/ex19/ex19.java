package pt.isec.deis.pa.fichaExercicios.ex19;

import pt.isec.deis.pa.fichaExercicios.ex19.Model.Libraries.Library_ArrayList;
import pt.isec.deis.pa.fichaExercicios.ex19.UI.LibraryUI;

public class ex19 {
    public static void main(String[] args) {

        LibraryUI ui;

        ui = new LibraryUI(new Library_ArrayList("Biblioteca do ISEC"));

        ui.start();

    }
}
