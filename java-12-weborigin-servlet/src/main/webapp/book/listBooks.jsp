<%@ page import="com.yuan.book.bean.Book" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    <% for (Book book : (List<Book>)request.getAttribute("bookList")) { %>
    <tr>
        <td><%= book.getIsbn() %></td>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><a href="book?command=delete&isbn=<%= book.getIsbn() %>">Delete</a></td>
    </tr>
    <% } %>
</table>
<a href="book?command=new">Add New Book</a>
</body>
</html>
