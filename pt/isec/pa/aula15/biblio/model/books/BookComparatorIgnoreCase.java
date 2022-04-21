package pt.isec.pa.aula15.biblio.model.books;

import java.util.Comparator;

public class BookComparatorIgnoreCase implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}
