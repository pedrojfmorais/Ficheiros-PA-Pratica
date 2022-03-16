package pt.isec.deis.pa.aula6.ex13;

import java.util.ArrayList;
import java.util.HashSet;

public class Library_HashSet {
    private HashSet<Book> livros;
    private final String nome;

    public Library_HashSet(String nome){
        this.nome = nome;
        this.livros = new HashSet<>();
    }

    public int addBook(String titulo, ArrayList<String> autores){
        Book novo = new Book(titulo, autores);
        livros.add(novo);
        return novo.getCodigo();
    }

    public Book findBook(int codigo){
        if(!livros.contains(Book.getDummyBook(codigo)))
            return null;

        for( var livro : livros){
            if(livro.equals(Book.getDummyBook(codigo)))
                return livro;
        }
        return null;
    }

    public boolean removeBook(int codigo){
        if(!livros.contains(Book.getDummyBook(codigo)))
            return false;

        for( var livro : livros){
            if(livro.equals(Book.getDummyBook(codigo))) {
                livros.remove(livro);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nome da Biblioteca: ").append(nome).append(System.lineSeparator());
        sb.append("Livros: ").append(System.lineSeparator());

        for(var livro : livros)
            sb.append(livro).append(System.lineSeparator());

        return sb.toString();
    }

    public String getName(){return nome;}
    public ArrayList<Book> getLivros() {return new ArrayList<>(this.livros);}
}
