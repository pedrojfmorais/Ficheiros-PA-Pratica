package pt.isec.pa.fichaExercicios.ex13.Model;

import java.util.ArrayList;

public class Library_ArrayList extends Library {

    ArrayList<Book> livros;

    public Library_ArrayList(String nome) {
        super(nome);
        livros = new ArrayList<>();
    }

    @Override
    public int addBook(String titulo, ArrayList<String> autores) {
        Book novo = new Book(titulo, autores);
        livros.add(novo);
        return novo.getCodigo();
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
}
