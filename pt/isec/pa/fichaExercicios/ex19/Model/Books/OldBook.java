package pt.isec.pa.fichaExercicios.ex19.Model.Books;

import java.util.ArrayList;

public class OldBook extends Book{
    private int nCopias;

    public OldBook(String titulo, ArrayList<String> autores, int nCopias){
        super(titulo, autores);
        this.nCopias = nCopias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Número de cópias: ").append(nCopias).append(System.lineSeparator());
        return sb.toString();
    }
}
