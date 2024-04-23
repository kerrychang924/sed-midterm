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
        // check user limit
        if(user.getBorrowedBooks().size() > user.getBooksLimit()){
          System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
        }

        // check book borrow, status true === available
        if(book.getStatus() == false){
          System.out.println("Can not check out since the book is checked out");
        }

        user.addBorrowedBook(book);
        // checkout logic
        book.setStatus(false);
        book.setBorrower(user);
    }

    @Override
    public void returnBook(Library library, Book book) {
      // check book borrow, status true === available
      if(book.getStatus() == true){
        System.out.println("Can not return since the book isn't checked out");
      }
      User user = book.getBorrower();
      user.removeBorrowedBook(book);
      book.setStatus(true);
    }

    @Override
    public void addBook(Library library, Author author, Subject subject) {
      // no checking
      Book book = new Book(author, subject);
      library.addBook(book); 

      // add author
      author.addBook(book);
      if(library.getAuthor(author.getName()) == null){
        library.addAuthor(author);
      }
      
      // add subject
      subject.addBook(book);
      if(library.getSubject(subject.getName()) == null){
        library.addSubject(subject);
      }
    }

    @Override
    public void removeBook(Library library, Book book) {
      // if the book not exist?
      library.removeBook(book.getName()); 
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
      return user.getBorrowedBooks();
    }

    @Override
    public User findLastBorrower(Library library, Book book) {
      return book.getBorrower();
    }
}