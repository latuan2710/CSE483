package app;

import java.util.List;

import app.model.Book;
import app.model.Borrower;
import app.model.Record;

public class BusinessLogicTier {

    private DatabaseLayer database;

    public BusinessLogicTier() {
        this.database = new DatabaseLayer();
    }

    public boolean registerBook(String title, String author, String genre, int quantity) {
        try {
            Book book = database.findBookByTitle(title);

            if (book != null) {
                book.setAvailableQuantity(book.getAvailableQuantity() + quantity);
            } else {
                book = new Book(title, author, genre, quantity);
                database.addBook(book);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean registerBorrower(String name, String address, String email, String phone) {
        try {
            Borrower borrower = database.findBorrowerByName(name);

            if (borrower != null) {
                return false;
            } else {
                borrower = new Borrower(name, address, email, phone);
                database.addBorrower(borrower);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrowBook(String bookTitle, String borrowerName) {
        try {
            Book book = database.findBookByTitle(bookTitle);
            Borrower borrower = database.findBorrowerByName(borrowerName);

            if (book == null || borrower == null) {
                return false;
            }

            if (book.getAvailableQuantity() > 0) {
                book.setAvailableQuantity(book.getAvailableQuantity() - 1);
            } else {
                return false;
            }

            database.addRecord(new Record(borrowerName, bookTitle));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeBook(int bookId) {
        return database.removeBookById(bookId);
    }

    public boolean removeBorrower(int borrowerId) {
        return database.removeBorrowerById(borrowerId);
    }

    public boolean removeRecord(int recordId) {
        return database.removeRecordById(recordId);
    }

    public List<Borrower> getAllBorrowers() {
        return database.getAllBorrowers();
    }

    public List<Book> getAllBooks() {
        return database.getAllBooks();
    }

    public List<Record> getAllRecords() {
        return database.getAllRecords();
    }
}
