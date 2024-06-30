package com.yuan.book.dao;


import com.yuan.book.bean.Book;

import java.util.ArrayList;
import java.util.List;

// 这是一个简化的示例。在实际应用中，您应该从数据库中获取数据。
public class BookDAO {
    private static final List<Book> books = new ArrayList<>();

    public List<Book> selectAllBooks() {
        return books;
    }

    public void insertBook(Book book) {
        books.add(book);
    }

    public void deleteBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }
}
