import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private String password;
    private String role;
    private List<Book> borrowedBooks;


    public User(String name, String userId, String password, String role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.borrowedBooks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public List<Book> getBorrowedBooks(){
        return borrowedBooks();
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

}
