package com.yuan.book.controller;


import com.yuan.book.bean.Book;
import com.yuan.book.dao.BookDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;



@WebServlet("/book")
public class BookController extends HttpServlet {
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO(); // 简化示例，实际上应该使用依赖注入
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            action = "list"; // 如果没有提供 'command' 参数，或者它是空的，我们默认设置为 'list'
        }

        System.out.println("command:" + action);

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listBook = bookDAO.selectAllBooks();
        request.setAttribute("bookList", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listBooks.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/newBook.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Book newBook = new Book(isbn, title, author);
        bookDAO.insertBook(newBook);
        response.sendRedirect("book");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        bookDAO.deleteBook(isbn);
        response.sendRedirect("book");
    }
}
