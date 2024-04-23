import java.util.*;

public class CmdHandler {
    private Library library = new Liberary();

    public void addUser(String type, String name, String booksLimit) {
        return;
    }

    public void checkout(String staff_id, String[] book_ids, String user_id) {
        return;
    }

    public void returnBook(String staff_id, String book_id) {
        return;
    }
    public void addBook(String staff_id, String author_id, String subject_id) {
        return;
    }
    public void removeBook(String staff_id, String book_id) {
        return;
    }
    public List<Book> getBooksByAuthor(String staff_id, String author_id) {
        return new ArrayList<Book>();
    }
    public List<Book> getBooksBySubject(String staff_id, String subject_id) {
        return new ArrayList<Book>();
    }
    public List<Book> getBooksByBorrower(String user_id, String user_id) {
        return new ArrayList<Book>();
    }
    public Borrower findLastBorrower(String staff_id, String book_id) {
        return new Borrower();
    }
}