package app.model;

import java.util.ArrayList;
import java.util.List;

public class Borrower {

    private static int nextId = 1;
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    public Borrower(String name, String address, String email, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void addBorrowedBooks(Book borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }

}
