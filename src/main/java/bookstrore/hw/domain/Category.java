package bookstrore.hw.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long categoryId;
  private String name;

  // Category OneToMany Book
  // cascade ALL => poistaa kaikki tiedot kategoriasta / kirjalistasta jos
  // kirjalistan / kategorian poistaa
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  // @JsonIgnoreProperties =>
  // json -käsittelyssä ohitetaan kategorian kirjojen kategoria tiedot.
  // Vain kirjan tiedot otetaan.
  @JsonIgnoreProperties("category")
  private List<Book> books;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Category ID: " + categoryId + ", name: " + name + ".";
  }

}
