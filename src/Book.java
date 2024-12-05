public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public boolean setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public void borrow(){
        if(!isBorrowed){
            isBorrowed=true;
            System.out.println("Kitob olindi");
        }else{
            System.out.println("Kitob allaqachon olingan");
        }
    }

    public void returnBook(){
        if(isBorrowed){
            isBorrowed = false;
            System.out.println("Kitob qaytarildi");
        }else{
            System.out.println("Kitob qaytarilmagan");
        }
    }


}
