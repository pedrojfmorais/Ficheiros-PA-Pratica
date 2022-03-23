package pt.isec.deis.pa.fichaExercicios.ex19.Model.Libraries;

import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.Book;

import java.util.ArrayList;

public abstract class Library implements ILibrary {
    private final String nome;

    public Library(String nome){
        this.nome = nome;
    }

    @Override
    public abstract int addBook(Book livro);

    @Override
    public abstract Book findBook(int codigo);
    @Override
    public abstract boolean removeBook(int codigo);

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nome da Biblioteca: ").append(nome).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public String getName(){return nome;}

    @Override
    public abstract ArrayList<Book> getLivros();

    public abstract String toStringSorted();
}

