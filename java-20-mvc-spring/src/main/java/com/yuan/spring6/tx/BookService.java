package com.yuan.spring6.tx;

public interface BookService {
    void buyBook(Integer bookId, Integer userId);
    void buyBookSlow(Integer bookId, Integer userId);
}
