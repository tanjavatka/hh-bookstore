package bookstrore.hw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstrore.hw.domain.Book;
import bookstrore.hw.domain.BookRepository;
import bookstrore.hw.domain.Category;
import bookstrore.hw.domain.CategoryRepository;

@SpringBootApplication
public class HwApplication {

	private static final Logger log = LoggerFactory.getLogger(HwApplication.class); // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(HwApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("save a couple of categories and books");
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Drama"));

			bookRepository.save(new Book("Harry Potter", "J.K.", 2000, 18));
			bookRepository.save(new Book("Summer", "Author", 2025, 14));

			log.info("fetch all books and categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

// this.title = title;
// this.author = author;
// this.publicationYear = publicationYear;
// this.isbn = isbn;
// this.price = price;