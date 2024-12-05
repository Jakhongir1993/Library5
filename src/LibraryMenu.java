import java.util.Scanner;

public class LibraryMenu {
    public void displayMenyu(){
        System.out.println("Library Management System");
        System.out.println("1. Add book");
        System.out.println("2. Borrow book");
        System.out.println("3. Return book");
        System.out.println("4. View all books");
        System.out.println("5. Logout");
    }

    public int getChoice(Scanner scanner){
        System.out.print("Tanlang");
        while (!scanner.hasNextInt()){
            System.out.println("Raqam kiritng");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
