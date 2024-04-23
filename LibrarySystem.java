import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class LibrarySystem {
    private static final CmdHandler handler = new CmdHandler();

    public static void main(String[] args) {
        String filePath = args[0];
        String staffId;
        String[] tokens;
        List<Book> books;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isBookInfo = true;
            int inputBookCount = 0;
            int inputUserCount = 0;
            while ((line = reader.readLine()) != null) {
                tokens = line.split("\\s+");
                //用tokens長度=1判斷 (1)接下來吃書本資訊(2)接下來吃user資訊
                if(tokens.length == 1){
                    if(isBookInfo){
                        isBookInfo = false;
                        try {
                            inputBookCount = Integer.parseInt(tokens[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: not an integer " + tokens[0]);
                        }
                        while ((line = reader.readLine()) != null && inputBookCount > 0) {
                            tokens = line.split("\\s+");
                            inputBookCount -= 1;
                            handler.addBook(null ,tokens[0], tokens[1]);
                            if(inputBookCount == 0){
                                break;
                            }
                        }
                    }else{
                        isBookInfo = true;
                        try {
                            inputUserCount = Integer.parseInt(tokens[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: not an integer " + tokens[0]);
                        }
                        while ((line = reader.readLine()) != null && inputUserCount > 0) {
                            tokens = line.split("\\s+");
                            inputUserCount -= 1;
                            if(tokens.length == 2){ //staff
                                handler.addUser(tokens[0], tokens[1], null);
                                if(inputUserCount == 0){
                                    break;
                                }
                            }else{ // borrower
                                handler.addUser(tokens[0], tokens[1], tokens[2]);
                                if(inputUserCount == 0){
                                    break;
                                }
                            }
                        }
                    }
                }else{
                    switch (tokens[1]){
                        case "addBook":
                            staffId = tokens[0];
                            if((line = reader.readLine()) != null){
                                tokens = line.split("\\s+");
                                handler.addBook(staffId ,tokens[0], tokens[1]);
                            }
                            break;
                        case "removeBook":
                            handler.removeBook(tokens[0], tokens[2]);
                            break;
                        case "checkout":
                            staffId = tokens[0];
                            String borrowerId = tokens[2];
                            if((line = reader.readLine()) != null){
                                tokens = line.split("\\s+");
                                handler.checkout(staffId, tokens, borrowerId);
                            }
                            break;
                        case "return":
                            handler.returnBook(tokens[0], tokens[2]);
                            break;
                        case "listAuthor":
                            books = handler.getBooksByAuthor(tokens[0], tokens[2]);
                            for(Book book : books){
                                System.out.println("ID: " + book.getName() + " Author: " + book.getAuthor().getName() + " Subject: " +  book.getSubject().getName());
                            }
                            break;
                        case "listSubject":
                            books = handler.getBooksBySubject(tokens[0], tokens[2]);
                            for(Book book : books){
                                System.out.println("ID: " + book.getName() + " Author: " + book.getAuthor().getName() + " Subject: " +  book.getSubject().getName());
                            }
                            break;
                        case "findChecked":
                            books = handler.getBooksByBorrower(tokens[0], tokens[2]);
                            for(Book book : books){
                                System.out.println("ID: " + book.getName() + " Author: " + book.getAuthor().getName() + " Subject: " + book.getSubject().getName());
                            }
                            break;
                        case "Borrower":
                            User user = handler.findLastBorrower(tokens[0], tokens[2]);
                            if(user != null){
                                System.out.println("User: " + user.getName());
                            }
                            break;
                    }
                }
            }
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}