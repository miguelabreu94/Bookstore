package config;

import domain.Book;
import domain.BookCategories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.BookRepository;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book dramaBook = new Book(
                    "Crepusculo", BookCategories.DRAMA,"Stephanie Meyer",24.5,100);

            Book romanceBook = new Book(
                    "Diario Paixao",BookCategories.ROMANCE,"Nicholas Sparks",30.50,199);

            bookRepository.saveAll(List.of(dramaBook,romanceBook));
        };
    }

}
