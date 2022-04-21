package pt.isec.pa.aula15.biblio.ui;

import pt.isec.pa.aula15.biblio.model.LibraryManager;
import pt.isec.pa.aula15.biblio.model.books.Book;
import pt.isec.pa.aula15.biblio.model.books.OldBook;
import pt.isec.pa.aula15.biblio.model.books.RecentBook;
import pt.isec.pa.aula15.biblio.model.library.Library;
import pt.isec.pa.utils.PAInput;

import java.io.IOException;
import java.util.ArrayList;

public class LibraryUI {
    LibraryManager lib;
    public LibraryUI(LibraryManager lib) {
        this.lib = lib;
    }

    void addBook() {
        int type = PAInput.chooseOption("Book type","Old Book","Recent book","Cancel operation");
        if (type == 3 || type < 1)
            return;
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

        int id = switch (type) {
            case 1 -> {
               int nr_copies = PAInput.readInt("Number of copies: ");
               yield lib.addBook(new OldBook(title,authors,nr_copies));
            }
            case 2 -> {
                String isbn = PAInput.readString("ISBN: ",false);
                double cost = PAInput.readNumber("Cost: ");
                yield lib.addBook(new RecentBook(title,authors,isbn,cost));
            }
            default -> -1;
        };
        if (id<0)
            System.out.println("Error adding this new book");
        else
            System.out.printf("The ID of this new book is: %d\n",id);
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
            switch (PAInput.chooseOption("LibraryList Manager - "+lib.getName(),
                    "Add new book","Search book","Remove book","Show books",
                    "Import", "Export", "Save", "Load", "Quit")) {
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
                    System.out.println("toString:");
                    System.out.println(lib.toString());
                    System.out.println("\noSort1:");
                    System.out.println(lib.toStringOtherOrder());
                    break;
                case 5:
                    lib.addBookFromFile(PAInput.readString("Insira o nome do ficheiro: ", false));
                    break;
                case 6:
                    try {
                        lib.exportToTextFile(PAInput.readString("Insira o nome do ficheiro: ", false));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    if(!lib.save())
                        System.out.println("Não foi possivel guardar a biblioteca!");
                    break;
                case 8:
                    if(!lib.load())
                        System.out.println("Não foi possivel carregar a biblioteca!");
                    break;
                case 9:
                    return;
            }
        }
    }

}
