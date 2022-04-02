package pt.isec.pa.fichaExercicios.ex19.Model.Books;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitulo().compareTo(o2.getTitulo());
    }
}
