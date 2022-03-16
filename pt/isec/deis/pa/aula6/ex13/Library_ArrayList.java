package pt.isec.deis.pa.aula6.ex13;

import java.util.ArrayList;

public class Library_ArrayList {
    private ArrayList<Book> livros;
    private final String nome;

    public Library_ArrayList(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public int addBook(String titulo, ArrayList<String> autores){
        Book novo = new Book(titulo, autores);
        livros.add(novo);
        return novo.getCodigo();
    }

    public Book findBook(int codigo){
        for( var livro : livros){
            if(livro.equals(Book.getDummyBook(codigo)))
                return livro;
        }
        return null;
    }

    public Book findBook_2(int codigo){
        int index = livros.indexOf(Book.getDummyBook(codigo));
        if(index == -1)
            return null;
        return livros.get(index);
    }

    public boolean removeBook(int codigo){
        for( var livro : livros){
            if(livro.equals(Book.getDummyBook(codigo))) {
                livros.remove(livro);
                return true;
            }
        }
        return false;
    }

    public boolean removeBook_2(int codigo){
        int index = livros.indexOf(Book.getDummyBook(codigo));
        if(index == -1)
            return false;
        livros.remove(index);
        return true;
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
    public ArrayList<Book> getLivros() {return livros;}
}
