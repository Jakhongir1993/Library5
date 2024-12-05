import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        LibraryService libraryService = new LibraryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService(libraryService, scanner);
        AuthService authService = new AuthService(libraryService, scanner);
        MenuHandler menuHandler = new MenuHandler(authService, bookService, scanner);
        LibraryController libraryController = new LibraryController(authService, bookService,menuHandler);
        libraryController.start();



    }
}