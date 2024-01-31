package config;

import domain.AppUser;
import domain.AppUserRole;
import domain.Book;
import domain.BookCategories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.AppUserRepository;
import repository.BookRepository;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository, AppUserRepository repo){
        return args -> {
            Book dramaBook = new Book(
                    "Crepusculo", BookCategories.DRAMA,"Stephanie Meyer",24.5,100);

            Book romanceBook = new Book(
                    "Diario Paixao",BookCategories.ROMANCE,"Nicholas Sparks",30.50,199);

            bookRepository.saveAll(List.of(dramaBook,romanceBook));

            AppUser user1 = new AppUser("justino@gmail.com", "1234", AppUserRole.ADMIN);
            AppUser user2 = new AppUser("gg@hotmail.com", "1234", AppUserRole.ADMIN);
            AppUser user3 = new AppUser("possa@hotmail.com", "1234", AppUserRole.USER);
            AppUser user4 = new AppUser("caracas@hotmail.com", "1234", AppUserRole.USER);

            repo.saveAll(List.of(user1, user2, user3, user4));
            System.out.println("Sample database initialized");
        };
    }

}
