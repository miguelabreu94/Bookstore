package controller;
import domain.Book;
import domain.BookCategories;
import domain.MyBookCart;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import services.BookService;
import services.MyBookCartService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/books")
@ComponentScan(basePackages = "services")
public class BookController {

    private final BookService bookService;
    private final MyBookCartService myBookCartService;

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

    @PutMapping("{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book){
        book.setId(id);
        return bookService.editBook(book);
    }
    @RequestMapping("/mybooks/{id}")
    public String saveMyBook(@PathVariable("id") int id){
        Book b = bookService.getBookById(id).orElseThrow();
        MyBookCart mb = new MyBookCart(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookCartService.saveMyBooks(mb);
        return "myBook saved";
    }
    @GetMapping("/mybooks")
    public List<MyBookCart> getMyBooks(){
        return myBookCartService.getMyBooks();
    }


}