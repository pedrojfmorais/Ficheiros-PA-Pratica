package pt.isec.pa.ex13.Model;

import java.util.ArrayList;

public abstract class Library implements ILibrary {
    private final String nome;

    public Library(String nome){
        this.nome = nome;
    }

    @Override
    public abstract int addBook(String titulo, ArrayList<String> autores);

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
}

