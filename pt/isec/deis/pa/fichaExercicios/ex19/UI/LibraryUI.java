package pt.isec.deis.pa.fichaExercicios.ex19.UI;

import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.Book;
import pt.isec.deis.pa.fichaExercicios.ex19.Model.Libraries.Library;
import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.OldBook;
import pt.isec.deis.pa.fichaExercicios.ex19.Model.Books.RecentBook;
import pt.isec.deis.pa.utils.PAInput;

import java.util.ArrayList;

public class LibraryUI {
    Library lib;
    public LibraryUI(Library lib) {
        this.lib = lib;
    }

    void addBook() {
        int tipoLivro;
        do {
            tipoLivro = PAInput.readInt("Tipo de Livros:\n 1 - OldBook\n 2 - RecentBook\n");
        } while(tipoLivro != 1 && tipoLivro != 2);

        String title = PAInput.readString("Book title: ",false);
        String author;
        ArrayList<String> authors = new ArrayList<>();
        do {
            author = PAInput.readString("Name of one author [\'exit\' to finish]: ",false);
            if (author!=null && !author.equalsIgnoreCase("exit"))
                authors.add(author);
        } while (!author.equalsIgnoreCase("exit"));
        if (authors.isEmpty())
            authors.add("Author unknown");

        switch (tipoLivro) {
            case 1 -> {
                int copias = PAInput.readInt("Number of copies: ");
                lib.addBook(new OldBook(title, authors, copias));
            }
            case 2 -> {
                String ISBN = PAInput.readString("Book ISBN: ", false);
                double preco = PAInput.readNumber("Book price:");
                lib.addBook(new RecentBook(title, authors, ISBN, preco));
            }
            default -> {
            }
        }
    }

    void findBook() {
        int bookId = PAInput.readInt("ID of the book to search: ");
        Book book = lib.findBook(bookId);
        if (book == null)
            System.out.println("Book not found");
        else
            System.out.println("Book found: "+book);
    }

    void removeBook() {
        int codigo = PAInput.readInt("ID of the book to remove: ");
        boolean deleted = lib.removeBook(codigo);
        if (!deleted)
            System.out.println("Book not found");
        else
            System.out.println("Book deleted");
    }

    public void start() {
        while (true) {
            switch (PAInput.chooseOption("Library Manager - "+lib.getName(),
                    "Add new book","Search book","Remove book","Show books","Show books sorted",
                    "Quit")) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    System.out.println(lib.toString());
                    break;
                case 5:
                    System.out.println(lib.toStringSorted());
                    break;
                case 6:
                    return;
            }
        }
    }

}
