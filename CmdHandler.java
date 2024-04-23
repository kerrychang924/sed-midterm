import java.util.*;


public class CmdHandler {
    private Library library = new Library();
    private final int MAX_LIMIT = 1 << 32 - 1;

    private void error() {
        System.out.println("Error");
    }

    public void addUser(String type, String name, String booksLimit) {
        User user;
        if (!(type == "staff" || type == "borrower")) {
            System.err.println("Invalid user.");
            System.out.println("Error");
            return;
        }

        if (type == "staff") {
            user = new Staff(name, MAX_LIMIT);
        } else {
            user = new Borrower(name, Integer.parseInt(booksLimit));
        }

        this.library.addUser(user);
    }

    public void checkout(String staff_id, String[] book_ids, String user_id) {
        User staff = library.getUser(staff_id);
        User user = library.getUser(user_id);
        for (String id : book_ids) {
            Book book = library.getBook(id);
            staff.checkout(library, book, user);
        }
        return;
    }

    public void returnBook(String staff_id, String book_id) {
        User staff = library.getUser(staff_id);
        Book book = library.getBook(book_id);
        staff.returnBook(library, book);
        return;
    }
    public void addBook(String staff_id, String author_id, String subject_id) {
        User user;
        
        Author author =  library.getAuthor(author_id);
        if (author == null) {
            author = new Author(author_id);
        }
        
        Subject subject = library.getSubject(subject_id);
        if (subject == null) {
            subject = new Subject(subject_id);
        }

        if (staff_id == null) {
            Book book = new Book(author, subject);
            author.addBook(book);
            subject.addBook(book);
            library.addAuthor(author);
            library.addSubject(subject);
            library.addBook(book);
        }
        else {
            user = library.getUser(staff_id);
            user.addBook(library, author, subject);
        }
        return;
    }

    public void removeBook(String staff_id, String book_id) {
        User user = library.getUser(staff_id);
        Book book = library.getBook(book_id);
        if (user == null || book == null) {
            error();
            return;
        } else {
            user.removeBook(library, book);
        }
        return;
    }

    public List<Book> getBooksByAuthor(String staff_id, String author_id) {
        List<Book> bookList;
        User staff = library.getUser(staff_id);
        Author author = library.getAuthor(author_id);
        if (staff == null || author == null) {
            error();
            bookList = new ArrayList<>();
        } else {
            bookList = staff.getBooksByAuthor(library, author);
        }
        return bookList;
    }

    public List<Book> getBooksBySubject(String staff_id, String subject_id) {
        List<Book> bookList;
        User staff = library.getUser(staff_id);
        Subject subject = library.getSubject(subject_id);
        if (staff == null || subject == null) {
            error();
            bookList = new ArrayList<>();
        } else {
            bookList = staff.getBooksBySubject(library, subject);
        }
        return bookList;
    }
    public List<Book> getBooksByBorrower(String user1_id, String user2_id) {
        List<Book> bookList;
        User user1 = library.getUser(user1_id);
        User user2 = library.getUser(user2_id);
        if (user1 == null || user2 == null) {
            error();
            bookList = new ArrayList<>();
        } else {
            bookList = user1.getBooksByBorrower(library, user2);
        }
        return bookList;
    }
    public User findLastBorrower(String staff_id, String book_id) {
        User lastBorrower;
        User staff = library.getUser(staff_id);
        Book book = library.getBook(book_id);
        if (staff == null || book == null) {
            lastBorrower = null;
        } else {
            lastBorrower = staff.findLastBorrower(library, book);
        }
        return lastBorrower;
    }
}