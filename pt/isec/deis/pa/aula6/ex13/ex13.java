package pt.isec.deis.pa.aula6.ex13;

import pt.isec.deis.pa.aula6.ex13.Model.Library_ArrayList;
import pt.isec.deis.pa.aula6.ex13.Model.Library_HashMap;
import pt.isec.deis.pa.aula6.ex13.Model.Library_HashSet;
import pt.isec.deis.pa.aula6.ex13.UI.LibraryUI;
import pt.isec.deis.pa.utils.PAInput;

public class ex13 {
    public static void main(String[] args) {

        LibraryUI ui;

        switch (PAInput.chooseOption("Tipo de variável: ",
                "ArrayList","HashSet","HashMap")) {
            case 1:
                ui = new LibraryUI(new Library_ArrayList("Biblioteca do ISEC"));
                break;
            case 2:
                ui = new LibraryUI(new Library_HashSet("Biblioteca do ISEC"));
                break;
            case 3:
                ui = new LibraryUI(new Library_HashMap("Biblioteca do ISEC"));
                break;
            default:
                return;
        }
        ui.start();
    }
}
