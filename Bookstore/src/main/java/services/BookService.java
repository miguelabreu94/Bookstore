package services;
import domain.Book;
import domain.BookCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookByCategory(BookCategories category){
        return bookRepository.getBookByCategory(category);
    }
    public Optional<Book> getBookById(final long bookId){
        return bookRepository.getBookById(bookId);
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
        System.out.println(book);
    }

    public void deleteBook(long bookId){
        boolean exists= bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

}
