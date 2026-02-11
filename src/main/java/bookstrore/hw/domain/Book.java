package bookstrore.hw.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int isbn;
  private String title;
  private String author;
  private int publicationYear;
  private double price;

  public Book() {
    this.isbn = 0;
    this.title = null;
    this.author = null;
    this.publicationYear = 0;
    this.price = 0.0;
  }

  public Book(String title, String author, int publicationYear, float price) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.price = price;
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

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  public int getIsbn() {
    return isbn;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Book: " + title + ", author: " + author + ", publication year: " + publicationYear + ", isbn -number: "
        + isbn
        + ", price: " + price + ".";
  }

}
