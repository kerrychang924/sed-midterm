public class Book implements Comparable<Book>{
    private String name;
    private boolean status;
    private Author author;
    private Subject subject;
    private User borrower;

    private static int book_count = 0;

    public Book(Author author, Subject subject) {
        this.name = String.valueOf(book_count);
        book_count++;
        status = true;
        this.author = author;
        this.subject = subject;
        borrower = null;
    }

    public static int getBook_count() {
        return book_count;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.getName());
    }
}
