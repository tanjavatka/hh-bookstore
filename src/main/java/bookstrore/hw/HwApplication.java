package bookstrore.hw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstrore.hw.domain.AppUser;
import bookstrore.hw.domain.AppUserRepository;
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
	public CommandLineRunner createDemoRows(BookRepository bookRepository, CategoryRepository categoryRepository,
			AppUserRepository appUserRepository) {
		return (args) -> {

			log.info("save a couple of categories and books");
			Category fiction = categoryRepository.save(new Category("Fiction"));
			Category comedy = categoryRepository.save(new Category("Comedy"));
			Category romance = categoryRepository.save(new Category("Romance"));
			Category drama = categoryRepository.save(new Category("Drama"));

			bookRepository.save(new Book(37829, "Harry Potter", "J.K.", 2000, 18.0, fiction));
			bookRepository.save(new Book(29749, "Summer", "Author", 2025, 14.0, romance));

			// KokeilijaUser12
			AppUser user1 = new AppUser("user", "$2a$12$jUzXUAJ85wXQYqB7xCQU9eSYC3F4Xv5k1TivjhZL0WSewuxJBBI1G",
					"user@user.com", "USER");

			// VartijaAdmin12
			AppUser user2 = new AppUser("admin", "$2a$12$y6MaotGuIXm/mmLu9dBlBOu4Uaw96Tpdh.oOruMQ84H113w/TEuKG",
					"admin@admin.com", "ADMIN");

			appUserRepository.save(user1);
			appUserRepository.save(user2);

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