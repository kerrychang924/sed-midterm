import java.util.List;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.TreeSet;

public class Borrower implements User {
  private String name;
  private int booksLimit;
  private SortedSet<Book> borrowedBooks;
  

  public Borrower(String name, int booksLimit) {
      this.name = name;
      this.booksLimit = booksLimit;
      this.borrowedBooks = new TreeSet<>();
  }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBooksLimit() {
        return booksLimit;
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
      System.out.println("Borrower can not check out the books");
    }

    @Override
    public void returnBook(Library library, Book book) {
      System.out.println("Borrower can not return book");
    }

    @Override
    public void addBook(Library library, Author author, Subject subject) {
      System.out.println("Borrower can not add book");
    }

    @Override
    public void removeBook(Library library, Book book) {
      System.out.println("Borrower can not remove book");
    }

    @Override
    public List<Book> getBooksByAuthor(Library library, Author author) {
      return author.getBooks();
    }

    @Override
    public List<Book> getBooksBySubject(Library library, Subject subject) {
      return subject.getBooks();
    }

    @Override
    public List<Book> getBooksByBorrower(Library library, User user) {
      if(user == this) return user.getBorrowedBooks();
      else{
        System.out.println("Borrower can not find books checked out by other users");
        return null;
      } 
    }

    @Override
    public User findLastBorrower(Library library, Book book) {
        System.out.println("Borrower can not find borrower");
        return null;
    }
}