package pt.isec.pa.ex13.Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Library_HashSet extends Library {

    HashSet<Book> livros;

    public Library_HashSet(String nome) {
        super(nome);
        livros = new HashSet<>();
    }

    @Override
    public int addBook(String titulo, ArrayList<String> autores) {
        Book novo = new Book(titulo, autores);
        livros.add(novo);
        return novo.getCodigo();
    }

    @Override
    public Book findBook(int codigo) {
        if (!livros.contains(Book.getDummyBook(codigo)))
            return null;

        for (var livro : livros) {
            if (livro.equals(Book.getDummyBook(codigo)))
                return livro;
        }
        return null;
    }

    @Override
    public boolean removeBook(int codigo) {
        if (!livros.contains(Book.getDummyBook(codigo)))
            return false;

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
        return new ArrayList<>(this.livros);
    }
}
