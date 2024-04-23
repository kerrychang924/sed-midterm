import java.util.List;
import java.util.SortedSet;
import java.util.ArrayList;

public class Staff implements User {
    private String name;
    private int booksLimit;
    private SortedSet<Book> borrowedBooks;
    

    public Staff(String name, int booksLimit) {
        this.name = name;
        this.booksLimit = booksLimit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    @Override
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public void checkout(Library library, Book book, User user) {
        // 實現借書邏輯
    }

    @Override
    public void returnBook(Library library, Book book) {
        // 實現還書邏輯
    }

    @Override
    public void addBook(Library library, Author author, Subject subject) {
        // 實現添加書籍邏輯
    }

    @Override
    public void removeBook(Library library, Book book) {
        // 實現移除書籍邏輯
    }

    @Override
    public List<Book> getBooksByAuthor(Library library, Author author) {
        // 實現根據作者查詢書籍邏輯
        return new ArrayList<>();
    }

    @Override
    public List<Book> getBooksBySubject(Library library, Subject subject) {
        // 實現根據主題查詢書籍邏輯
        return new ArrayList<>();
    }

    @Override
    public List<Book> getBooksByBorrower(Library library, User user) {
        // 實現根據借閱者查詢書籍邏輯
        return new ArrayList<>();
    }

    @Override
    public User findLastBorrower(Library library, Book book) {
        // 實現查找最後一個借閱者的邏輯
        return null;
    }
}