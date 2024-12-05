import java.util.Scanner;

public class AuthService {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public AuthService(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    public User registerUser(){
        System.out.println("Ismingizni kiriting ");
        String name = scanner.nextLine();
        System.out.println("ID raqamingizni kiriting");

        String userId = scanner.nextLine();
        if(libraryService.userExists(name, userId)){
            System.out.println("Bu username yoki id orqali allaqachon ruyxatdan utilgan iltimos qaytadan urinip kuring");
            return null;
        }else {
            System.out.println("Parolni kiriting");
            String password = scanner.nextLine();
            String role;
            while (true){
                System.out.println("Student yoki Mehmon?:");
                role = scanner.nextLine();
                if(role.equals("Student") || role.equals("Mehmon")){
                    break;
                }else{
                    System.out.println("Talaba yoki mehmon dep kiriting");
                }
            }

            User user = new User(userId, name, role, password);
            libraryService.addUser(user);
            System.out.println("Ruyxatdan utildi");
            return user;
        }
    }
    public User loginUser(){
        System.out.println("Kirish uchun ismingizni kiriting");
        String name = scanner.nextLine();
        User user = libraryService.findUserByName(name);
        if(user != null){
            System.out.println("Parolni kiriting");
            String password = scanner.nextLine();
            if(user.getPassword().equals(password)){
                System.out.println("xush kelibsiz");
                return user;
            }else{
                System.out.println("Parol xato qaytadan kiriting");
                return null;
            }
        }else {
            System.out.println("Ruyxatdan utmagan");

        }
        return null;
    }

    public void resetPassword(User user){
        if(user==null){
            System.out.println("Ruyxatdan utmagan");
            return;
        }
        System.out.println("Hozirgi parolingizni kiriting");
        String oldPassword = scanner.nextLine();
        if(user.getUserId().equals(oldPassword)){
            System.out.println("Yangi parolni kiriting");
            String newPassword = scanner.nextLine();
            user.setPassword();
            System.out.println("Parol muvofiqiyatli yangilandi");
        }else{
            System.out.println("Parol xato, qaytadan urinip kuring");
        }
    }
}
