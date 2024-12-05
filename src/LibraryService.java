import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private DatabaseService databaseService;
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public LibraryService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void addBook(Book book){
        books.add(book);
        databaseService.save(book);
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean userExists(String name, String userId){
        String lowerName = name.toLowerCase();
        String lowerUserId = userId.toLowerCase();
        for(User user: users){
            if(user.getName().toLowerCase().equals(lowerName) || user.getUserId().toLowerCase().equals(lowerUserId)){
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book findBookByTitle(String title){
        String lowerTitle = title.toLowerCase();
        for(Book book:books){
            if(book.getTitle().toLowerCase().equals(lowerTitle)){
                return book;
            }
        }
        return null;
    }
    public User findUserByName(String name){
        String lowerName = name.toLowerCase();
        for(User user:users){
            if(user.getName().toLowerCase().equals(lowerName)){
                return user;
            }
        }
        return null;
    }

    public  void  borrowBook(String bookTitle, User user){
        Book book = findBookByTitle(bookTitle);
        if(book !=null && user !=null && !book.getIsBorrowed()){
            book.borrowBook(book);
        }else{
            System.out.println("Kitob topilmadi");
        }
    }
    public  void  returnBook(String bookTitle, User user){
        Book book = findBookByTitle(bookTitle);
        if(book !=null && user !=null && !book.getIsBorrowed()){
            book.returnBook();
            user.returnBook(book);
        }else{
            System.out.println("Kitobni olmagansiz");
        }
    }


}
