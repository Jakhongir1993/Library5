public class LibraryController {
    private final AuthService authService;
    private final BookService bookService;
    private final MenuHandler menuHandler;
    private User currentUser=null;

    public LibraryController(AuthService authService, BookService bookService, MenuHandler menuHandler) {
        this.authService = authService;
        this.bookService = bookService;
        this.menuHandler = menuHandler;
    }

    public void start(){
        while (true){
            if(currentUser==null){
                currentUser=menuHandler.showAuthMenu();
            }else {
                currentUser=menuHandler.showMainMenu(currentUser);
            }
        }
    }
}
