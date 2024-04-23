import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Author {
    private final String name;
    private final SortedSet<Book> books;

    public Author(String name){
        this.name = name;
        books = new TreeSet<>();
    }
    public String getName() {
        return name;
    }

    public List<Book> getBooks(){
        return new ArrayList<>(books);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

}
