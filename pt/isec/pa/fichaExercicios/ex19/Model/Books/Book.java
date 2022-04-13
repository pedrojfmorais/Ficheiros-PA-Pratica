package pt.isec.pa.fichaExercicios.ex19.Model.Books;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book>{
    private static int countBooks;
    private final int codigo;
    private String titulo;
    private List<String> autores;

    static {
        countBooks = 1;
    }

    protected Book(String titulo, ArrayList<String> autores){
        codigo = countBooks++;
        this.titulo = titulo;
        this.autores = autores;
    }

    private Book(int codigo){
        this.codigo = codigo;
        this.titulo = null;
        this.autores = null;
    }

    public int getCodigo() {return codigo;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public ArrayList<String> getAutores() {return (ArrayList<String>) autores;}

    public void setAutores(ArrayList<String> autores) {this.autores = autores;}

    public static Book getDummyBook(int codigo){
        return new Book(codigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Codigo do livro: ").append(codigo).append(System.lineSeparator());
        sb.append("Titulo: ").append(titulo).append(System.lineSeparator());
        sb.append("Autores: ");
        for(var autor : autores) {
            sb.append(autor);
            if(autores.indexOf(autor) < autores.size() - 1)
                sb.append(", ");
        }
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return codigo == book.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public int compareTo(Book o) {
        return titulo.compareTo(o.titulo);
    }
}
