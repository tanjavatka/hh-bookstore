package bookstrore.hw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstrore.hw.domain.Book;
import bookstrore.hw.domain.BookRepository;
import bookstrore.hw.domain.CategoryRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

  private BookRepository bookRepository;
  private CategoryRepository categoryRepository;

  public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  }

  @GetMapping("/index")
  public String getBook() {

    return "bookstore"; // bookstore.html
  }

  // List all books from db
  @GetMapping("/booklist")
  public String getBooks(Model model) {

    model.addAttribute("books", bookRepository.findAll());

    return "booklist"; // booklist.html
  }

  // Delete a Book
  @GetMapping("/delete/{id}")
  public String deleteBook(@PathVariable("id") int isbn, Model model) {

    bookRepository.deleteById(isbn);

    return "redirect:/booklist"; // booklist.html
  }

  // Add a new Book
  @RequestMapping("/add")
  public String addBook(Model model) {

    model.addAttribute("book", new Book());
    model.addAttribute("categories", categoryRepository.findAll());

    return "addbook"; // addbook.html
  }

  // Save a new Book
  @PostMapping("/save")
  public String saveBook(Book book) {

    bookRepository.save(book);

    return "redirect:/booklist"; // booklist.html
  }

  // Edit a Book
  @RequestMapping("/edit/{id}")
  public String editBook(@PathVariable("id") int isbn, Model model) {

    model.addAttribute("book", bookRepository.findById(isbn));

    return "editBook"; // editBook.html
  }

}
