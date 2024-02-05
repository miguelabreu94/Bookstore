package services;

import domain.MyBookCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MyBookCartRepository;

import java.util.List;

@Service
public class MyBookCartService {

    @Autowired
    private MyBookCartRepository myBook;

    public void saveMyBooks(MyBookCart book){
        myBook.save(book);
    }

    public List<MyBookCart> getMyBooks(){
       return myBook.findAll();
    }

    public void deleteById(Integer id){
        myBook.deleteById(id);
    }

}
