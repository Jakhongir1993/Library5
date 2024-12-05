import java.util.Scanner;

public class MenuHandler {
    private final AuthService authService;
    private final BookService bookService;
    private final Scanner scanner;

    public MenuHandler(AuthService authService, BookService bookService, Scanner scanner) {
        this.authService = authService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    public User showAuthMenu(){
        System.out.println("Kutubxonani boshqarish tizimiga xush kelibsiz");
        System.out.println("1. Kirish");
        System.out.println("2. Ruyxatdan utish");
        System.out.println("3. Chiqish");
        int choice = getChoice();

        switch (choice){
            case 1: return authService.registerUser();
            case 2: return authService.loginUser();
            case 3:
                System.out.println("Xayr salomat buling");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Iltimos notugri raqam kiritingiz, qaytadan urinip kuring");
                return null;
        }
    }
    public User showMainMenu(User user){
        System.out.println("Kutub xona boshqarish tizimi");
        System.out.println("1. Kitob qushish");
        if(!user.getRole().equals("Mehmon")){
            System.out.println("2. Kitob olish");
            System.out.println("3. Kitob qaytarish");
        }
        System.out.println("4. Barcha kitoblar");
        System.out.println("5. Chiqish");
        int choice = getChoice();
        switch (choice) {
            case 1:
                bookService.addBook();
                break;
            case 2:
                if (!user.getRole().equals("Mehmon")) {
                    bookService.borrowBook(user);
                } else {
                    System.out.println("Mehmon kitob ololmaydi");
                }
                break;
            case 3:
                if (!user.getRole().equals("Mehmon")) {
                    bookService.returnBook(user);
                } else {
                    System.out.println("Mehmon kitob ololmaydi");
                }
                break;
            case 4:
                bookService.displayAllBooks();
                break;
            case 5:
                System.out.println("Siz tizimda chiqmagansiz " + user.getName() + "...");
                return null;
            default:
                System.out.println("Iltimos qaytadan urinip kuring");
        }
                return user;

    }

    private int getChoice(){
        System.out.println("Tanlang: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
