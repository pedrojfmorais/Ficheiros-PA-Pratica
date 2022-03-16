package pt.isec.deis.pa.aula6.ex13;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> livros;
    private final String nome;

    public Library(String nome){
        this.nome = nome;
        this.livros = new HashMap<>();
    }

    public int addBook(String titulo, ArrayList<String> autores){
        Book novo = new Book(titulo, autores);
        livros.put(novo.getCodigo(), novo);
        return novo.getCodigo();
    }

    public Book findBook(int codigo){
        return livros.get(codigo);
    }

    public boolean removeBook(int codigo){
        if(!livros.containsValue(Book.getDummyBook(codigo)))
            return false;

        livros.remove(codigo);
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nome da Biblioteca: ").append(nome).append(System.lineSeparator());
        sb.append("Livros: ").append(System.lineSeparator());

        for(var livro : livros.values())
            sb.append(livro).append(System.lineSeparator());

        return sb.toString();
    }

    public String getName(){return nome;}
    public ArrayList<Book> getLivros() {return new ArrayList<>(this.livros.values());}
}
