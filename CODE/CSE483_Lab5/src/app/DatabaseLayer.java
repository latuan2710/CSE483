package app;

import java.util.ArrayList;
import java.util.List;

import app.model.Book;
import app.model.Borrower;
import app.model.Record;

public class DatabaseLayer {

    private List<Borrower> borrowers;
    private List<Book> books;
    private List<Record> records;

    public DatabaseLayer() {
        this.borrowers = new ArrayList<>();
        this.books = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Borrower findBorrowerByName(String name) {
        for (Borrower borrower : borrowers) {
            if (borrower.getName().equals(name)) {
                return borrower;
            }
        }
        return null;
    }

    public boolean removeBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean removeBorrowerById(int borrowerId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getId() == borrowerId) {
                borrowers.remove(borrower);
                return true;
            }
        }
        return false;
    }

    public boolean removeRecordById(int recordId) {
        for (Record record : records) {
            if (record.getId() == recordId) {
                records.remove(record);
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBorrower(Borrower borrower) {
        this.borrowers.add(borrower);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Borrower> getAllBorrowers() {
        return borrowers;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Record> getAllRecords() {
        return records;
    }
}
