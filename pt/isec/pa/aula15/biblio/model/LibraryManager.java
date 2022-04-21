package pt.isec.pa.aula15.biblio.model;

import pt.isec.pa.apoio_poe.model.data.ApoioPOE;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeState;
import pt.isec.pa.aula15.biblio.model.books.Book;
import pt.isec.pa.aula15.biblio.model.books.OldBook;
import pt.isec.pa.aula15.biblio.model.books.RecentBook;
import pt.isec.pa.aula15.biblio.model.library.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private Library library;

    public LibraryManager(String nome){
        library = new Library(nome);
    }

    public String getName(){return library.getName();}

    public void setName(String name) {
        library.setName(name);
    }

    public int addBook(Book book) {
        return library.addBook(book);
    }

    public Book findBook(int id) {
        return library.findBook(id);
    }

    public boolean removeBook(int id) {
        return library.removeBook(id);
    }

    @Override
    public String toString() {
        return library.toString();
    }

    public String toStringOtherOrder() {
        return library.toStringOtherOrder();
    }

    public void exportToTextFile(String filename) throws IOException{

        if(filename.isBlank())
            return;

        try(PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter(filename)))
        ){

            pw.println("Library name: " + getName());

            StringBuilder sb = new StringBuilder();

            for(var livro : library.getBooks()){
                String [] classLivro = livro.getClass().toString().split("\\.");

                if(livro instanceof OldBook)
                    sb.append("*Old Book* ");
                else if(livro instanceof RecentBook)
                    sb.append("*Recent Book* ");

                sb.append(livro.getId()).append(",'");
                sb.append(livro.getTitle()).append("', ");

                for (var autor : livro.getAuthors())
                    sb.append(autor).append(", ");

                if(livro instanceof OldBook ob){
                    sb.append("#Copies:").append(ob.getNr_copies()).append(System.lineSeparator());
                } else if (livro instanceof RecentBook rb) {
                    sb.append("isbn: ").append(rb.getIsbn()).append(", ");
                    sb.append("cost: ").append(rb.getCost()).append(System.lineSeparator());
                }
            }
            pw.write(sb.toString());
        }
    }

    public boolean addBookFromFile(String filename){

        if(filename.isBlank())
            return false;

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while((line = br.readLine()) != null){
                String [] params = line.split(",");

                if(params[0].contains("Old Book")) {

                    ArrayList<String> authors = new ArrayList<>();
                    for (int i = 2; i <= params.length-2; i++)
                        authors.add(params[i].trim());

                    OldBook newBook = new OldBook(
                            params[1].substring(1, params[1].length()-1),
                            authors,
                            Integer.parseInt(params[params.length-1].substring(9))
                    );

                    library.addBook(newBook);

                } else if(params[0].contains("Recent Book")){

                    ArrayList<String> authors = new ArrayList<>();
                    for (int i = 2; i <= params.length-3; i++)
                        authors.add(params[i].trim());

                    RecentBook newBook = new RecentBook(
                            params[1].substring(1, params[1].length()-1),
                            authors,
                            params[params.length-2].substring(7),
                            Double.parseDouble(params[params.length-1].substring(7))
                    );

                    library.addBook(newBook);
                }
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean load(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save"))){

            library = (Library) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean save(){
        try(ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("save"))){

            oos.writeObject(library);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
