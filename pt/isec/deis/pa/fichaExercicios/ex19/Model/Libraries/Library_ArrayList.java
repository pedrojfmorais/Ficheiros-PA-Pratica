package pt.isec.deis.pa.fichaExercicios.ex19.Model.Libraries;

import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.Book;
import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.BookComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Library_ArrayList extends Library {

    ArrayList<Book> livros;

    public Library_ArrayList(String nome) {
        super(nome);
        livros = new ArrayList<>();
    }

    @Override
    public int addBook(Book livro) {
        livros.add(livro);
        return livro.getCodigo();
    }

    @Override
    public Book findBook(int codigo) {
        int index = livros.indexOf(Book.getDummyBook(codigo));
        if (index == -1)
            return null;
        return livros.get(index);
    }

    @Override
    public boolean removeBook(int codigo) {
        for (var livro : livros) {
            if (livro.equals(Book.getDummyBook(codigo))) {
                livros.remove(livro);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Livros: ").append(System.lineSeparator());

        for (var livro : livros)
            sb.append(livro).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public ArrayList<Book> getLivros() {
        return this.livros;
    }

    @Override
    public String toStringSorted(){
        ArrayList<Book> sortBooks = new ArrayList<>(livros);
        //Collections.sort(sortBooks);
        sortBooks.sort(new BookComparator());
        return sortBooks.toString();
    }
}
