package pt.isec.pa.aula15.biblio;

import pt.isec.pa.aula15.biblio.model.LibraryManager;
import pt.isec.pa.aula15.biblio.ui.LibraryUI;

public class Main {
    public static void main(String[] args){
        LibraryManager lib = new LibraryManager("DEIS-ISEC");
        LibraryUI libui = new LibraryUI(lib);
        libui.start();
    }
}