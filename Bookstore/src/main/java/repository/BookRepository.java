package repository;
import domain.Book;
import domain.BookCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> getBookById(long id);
    List<Book> getBookByCategory(BookCategories category);
}
