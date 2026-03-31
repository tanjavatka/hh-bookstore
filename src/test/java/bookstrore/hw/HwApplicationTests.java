package bookstrore.hw;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstrore.hw.web.BookController;

@SpringBootTest
class HwApplicationTests {

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
	}

}
