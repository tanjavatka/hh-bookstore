package bookstrore.hw;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import bookstrore.hw.domain.Book;
import bookstrore.hw.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Test //
  public void createNewBook() {
    Book book = new Book(12962910, "Love More", "Loren Lovable", 2027, 19.99, null);
    bookRepository.save(book);
    assertThat(book.getId()).isNotNull();
  }

  @Test //
  public void deleteBook() {
    Book book = new Book(12962910, "Love Deeply", "Loren Lovable", 2026, 14.99, null);
    bookRepository.save(book);
    Long id = book.getId();
    bookRepository.deleteById(id);
    assertThat(bookRepository.findById(id)).isEmpty();
  }

  @Test
  public void findByTitleShouldReturnBook() {
    Book book = new Book(12965345, "Romantic RoadTrip", "Melody Romcan", 2020, 29.99, null);
    bookRepository.save(book);

    assertThat(bookRepository.findByTitle("Romantic RoadTrip"))
        .hasSize(1)
        .extracting(Book::getTitle)
        .contains("Romantic RoadTrip");
  }

}
