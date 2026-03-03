package bookstrore.hw.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstrore.hw.domain.Book;
import bookstrore.hw.domain.BookRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class BookRestController {

  private BookRepository bookRepository;

  // constructor injection
  public BookRestController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  // RESTful service to get all books
  @GetMapping("/books")
  public @ResponseBody List<Book> findAllBooksRest() {
    return (List<Book>) bookRepository.findAll();
  }

  // RESTful service to get book by id
  @GetMapping("/books/{id}")
  public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "isbn") Integer isbn) {
    return bookRepository.findById(isbn);
  }

  // RESTful service to save new book
  @PostMapping(value = "/books")
  public @ResponseBody Book saveBookRest(@RequestBody Book book) {
    return bookRepository.save(book);
  }
}
