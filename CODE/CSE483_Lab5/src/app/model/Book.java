package app.model;

public class Book {

    private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private String genre;
    private int availableQuantity;

    public Book(String title, String author, String genre, int availableQuantity) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableQuantity = availableQuantity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

}
