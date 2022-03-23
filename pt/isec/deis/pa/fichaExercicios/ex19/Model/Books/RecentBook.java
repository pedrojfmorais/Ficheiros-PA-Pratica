package pt.isec.deis.pa.fichaExercicios.ex19.Model.Books;

import java.util.ArrayList;

public class RecentBook extends Book{
    String ISBN;
    double preco;

    public RecentBook(String titulo, ArrayList<String> autores, String ISBN, double preco){
        super(titulo, autores);
        this.ISBN = ISBN;
        this.preco = preco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("ISBN: ").append(ISBN).append(System.lineSeparator());
        sb.append("Preco: ").append(preco).append(System.lineSeparator());
        return sb.toString();
    }
}
