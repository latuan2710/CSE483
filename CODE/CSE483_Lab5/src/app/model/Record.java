package app.model;

public class Record {

    private static int nextId = 1;
    private int id;
    private String borrowerName;
    private String borrowedBookName;

    public Record(String borrowerName, String borrowedBookName) {
        this.id = nextId++;
        this.borrowerName = borrowerName;
        this.borrowedBookName = borrowedBookName;
    }

    public int getId() {
        return id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowedBookName() {
        return borrowedBookName;
    }

    public void setBorrowedBookName(String borrowedBookName) {
        this.borrowedBookName = borrowedBookName;
    }

}
