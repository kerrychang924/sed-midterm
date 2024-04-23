public class CmdHandler {
    private Library library;
    public void addUser(type: String, name: String, booksLimit: String)
    + checkout(staff_id: String, book_ids: String[], user_id: String): void
    + returnBook(staff_id: String, book_id: String): void
    + addBook(staff_id: String, author_id: String, subject_id: String): void
    + removeBook(staff_id: String, book_id: String): void
    + getBooksByAuthor(staff_id: String, author_id: String): List<Book>
    + getBooksBySubject(staff_id: String, subject_id: String): List<Book>
    + getBooksByBorrower(user_id: String, user_id: String): List<Book>
    + findLastBorrower(staff_id: String, book_id: String): Borrower
}