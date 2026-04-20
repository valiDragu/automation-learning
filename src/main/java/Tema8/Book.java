package Tema8;

public class Book {
    private String title;
    private String author;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getTitle() {
        System.out.println("Book title: " + title);
    }

    public void getAuthor() {
        System.out.println("Author: " + author);
    }

    public static void main() {
        Book book = new Book();
        book.setTitle("The name of the wind");
        book.setAuthor("Patrick Rothfuss");

        book.getTitle();
        book.getAuthor();
    }
}
