package pt.isec.pa.fichaExercicios.ex13.Model;

import java.util.ArrayList;

public interface ILibrary {
    int addBook(String titulo, ArrayList<String> autores);
    Book findBook(int codigo);
    boolean removeBook(int codigo);
    String getName();
    ArrayList<Book> getLivros();
}
