package com.yuan.spring6.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }

    public void buyBookSlow(Integer bookId, Integer userId){
        bookService.buyBookSlow(bookId, userId);
    }
}
