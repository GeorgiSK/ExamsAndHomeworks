package problem_02;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        try {
            Scanner scanner = new Scanner(System.in);
            String author = scanner.nextLine();
            String title = scanner.nextLine();
            Double price = Double.parseDouble(scanner.nextLine());
            Book book = new Book(author,
                    title,
                    price);

            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author,
                    title,
                    price);

            Method[] bookDeclaredMethods = Book.class.getDeclaredMethods();
            Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();
            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException("Code duplication in GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

}

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        String[] names = author.trim().split("\\s+");

        if (names.length > 1 && Character.toString(names[1].charAt(0)).matches("\\d")) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}

class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}
