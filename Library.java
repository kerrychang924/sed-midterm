import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, User> users;
    private final Map<String, Book> books;
    private final Map<String, Author> authors;
    private final Map<String, Subject> subjects;


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
        books.put(book.getName(), book);
    }

    public List<Book> getBooks(){
        return new ArrayList<>(books.values());
    }

    public Book getBook(String book_id){
        return books.get(book_id);
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

    public void addSubject(Subject subject){
        subjects.put(subject.getName(), subject);
    }

    public Subject getSubject(String subject_id){
        return subjects.get(subject_id);
    }
}
