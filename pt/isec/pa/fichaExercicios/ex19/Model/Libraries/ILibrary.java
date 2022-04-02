package pt.isec.pa.fichaExercicios.ex19.Model.Libraries;

import pt.isec.pa.fichaExercicios.ex19.Model.Books.Book;

import java.util.ArrayList;

public interface ILibrary {
    int addBook(Book livro);
    Book findBook(int codigo);
    boolean removeBook(int codigo);
    String getName();
    ArrayList<Book> getLivros();
}
