package bookstrore.hw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstrore.hw.domain.Book;
import bookstrore.hw.domain.BookRepository;

@SpringBootApplication
public class HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository) {
		return (args) -> {

			bookRepository.save(new Book("Harry Potter", "J.K.", 2000, 18));
			bookRepository.save(new Book("Summer", "Author", 2025, 14));
		};
	}

}

// this.title = title;
// this.author = author;
// this.publicationYear = publicationYear;
// this.isbn = isbn;
// this.price = price;