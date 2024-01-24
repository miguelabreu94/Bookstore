package controller;
import domain.Book;
import domain.BookCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
@ComponentScan(basePackages = "services")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/id/{id}")
    public Optional<Book> findBookByID(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/category/{category}")
    public List<Book> findBookByCategory(@PathVariable BookCategories category){
        return bookService.getBookByCategory(category);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
     }

    @PostMapping
     public void registerNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
     }

    @DeleteMapping(path = "/id/{bookId}")
    public void deleteBookById(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}