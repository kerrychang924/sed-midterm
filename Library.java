import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, User> users;
    private final Map<String, Book> books;
    private final Map<String, Author> authors;
    private Map<String, Subject> subjects;

    private static int book_count = 0;

    public Library(){
        users = new HashMap<>();
        books = new HashMap<>();
        authors = new HashMap<>();
        subjects = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getName(), user);
    }

    public User getUser(String userName){
        return users.get(userName);
    }

    public List<User> getUsers(){
        return new ArrayList<>(users.values());
    }

    public void addBook(Book book){
        Library.book_count = Book.getBook_count();
        books.put(Integer.toString(Library.book_count), book);
    }

    public List<Book> getBooks(){
        return new ArrayList<>(books.values());
    }

    public Book removeBook(String bookName){
        Book removedBook = books.get(bookName);
        if(removedBook == null){
            return null;
        }
        books.remove(bookName);
        return removedBook;
    }

    public void addAuthor(Author author){
        authors.put(author.getName(), author);
    }

    public Author getAuthor(String author_id){
        return authors.get(author_id);
    }

    public void addSubject(Author author){
        subjects.put(author.getName(), author);
    }

    public Author getSubject(String subject_id){
        return subjects.get(subject_id);
    }
}
