package pt.isec.pa.fichaExercicios.ex13.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Library_HashMap extends Library {

    private HashMap<Integer, Book> livros;

    public Library_HashMap(String nome) {
        super(nome);
        livros = new HashMap<>();
    }

    @Override
    public int addBook(String titulo, ArrayList<String> autores) {
        Book novo = new Book(titulo, autores);
        livros.put(novo.getCodigo(), novo);
        return novo.getCodigo();
    }

    @Override
    public Book findBook(int codigo) {
        return livros.get(codigo);
    }

    @Override
    public boolean removeBook(int codigo) {
        if (!livros.containsValue(Book.getDummyBook(codigo)))
            return false;

        livros.remove(codigo);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Livros: ").append(System.lineSeparator());

        for (var livro : livros.values())
            sb.append(livro).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public ArrayList<Book> getLivros() {
        return new ArrayList<>(this.livros.values());
    }
}
