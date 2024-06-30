<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<h1>Add New Book</h1>
<form action="book" method="post">
    <table>
        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" required></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><input type="text" name="author" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
                <input type="hidden" name="command" value="insert">
            </td>
        </tr>
    </table>
</form>
<a href="book">Back to Book List</a>
</body>
</html>
