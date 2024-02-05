package controller;
import domain.Book;
import domain.MyBookCart;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.BookService;
import services.MyBookCartService;

import java.util.List;

@RestController
@Controller
@RequestMapping(path = "api/v1/books")
@AllArgsConstructor
public class MyBookCartController {

    @Autowired
    private final MyBookCartService myBookCartService;

    @DeleteMapping("/deletemybooks/{id}")
    public String deleteMyBookCart(@PathVariable ("id") int id){
        myBookCartService.deleteById(id);
        return "myBook deleted";
    }



}
