import java.util.List;

public interface User {
    String getName();
    List<Book> getBorrowedBooks();
    int getBooksLimit();
    void addBorrowedBook(Book book);
    void removeBorrowedBook(Book book);

    // Library methods
    void checkout(Library library, Book book, User user);
    void returnBook(Library library, Book book);
    void addBook(Library library, Author author, Subject subject);
    void removeBook(Library library, Book book);
    List<Book> getBooksByAuthor(Library library, Author author);
    List<Book> getBooksBySubject(Library library, Subject subject);
    List<Book> getBooksByBorrower(Library library, User user);
    User findLastBorrower(Library library, Book book);
}