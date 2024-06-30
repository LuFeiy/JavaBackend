<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Operations</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>User Operations</h1>

<h2>Get User</h2>
<input type="text" id="getUserById" placeholder="Enter User ID">
<button onclick="getUser()">Get User</button>
<p id="getUserResult"></p>

<h2>Create User</h2>
<input type="text" id="createUser" placeholder="Enter User Data">
<button onclick="createUser()">Create User</button>
<p id="createUserResult"></p>

<h2>Update User</h2>
<input type="text" id="updateUserId" placeholder="Enter User ID">
<input type="text" id="updateUserData" placeholder="Enter User Data">
<button onclick="updateUser()">Update User</button>
<p id="updateUserResult"></p>

<h2>Delete User</h2>
<input type="text" id="deleteUserId" placeholder="Enter User ID">
<button onclick="deleteUser()">Delete User</button>
<p id="deleteUserResult"></p>

<script>
    function getUser() {
        var userId = $('#getUserById').val();
        $.ajax({
            url: '/war/users/' + userId, // 修改了 URL，加上了应用上下文 "/war"
            type: 'GET',
            success: function(response) {
                $('#getUserResult').text(response);
            },
            error: function() {
                $('#getUserResult').text('Error fetching user.');
            }
        });
    }

    function createUser() {
        var userData = $('#createUser').val();
        $.ajax({
            url: '/war/users', // 修改了 URL，加上了应用上下文 "/war"
            type: 'POST',
            contentType: 'application/json',
            data: userData,
            success: function(response) {
                $('#createUserResult').text(response);
            },
            error: function() {
                $('#createUserResult').text('Error creating user.');
            }
        });
    }

    function updateUser() {
        var userId = $('#updateUserId').val();
        var userData = $('#updateUserData').val();
        $.ajax({
            url: '/war/users/' + userId, // 修改了 URL，加上了应用上下文 "/war"
            type: 'PUT',
            contentType: 'application/json',
            data: userData,
            success: function(response) {
                $('#updateUserResult').text(response);
            },
            error: function() {
                $('#updateUserResult').text('Error updating user.');
            }
        });
    }

    function deleteUser() {
        var userId = $('#deleteUserId').val();
        $.ajax({
            url: '/war/users/' + userId, // 修改了 URL，加上了应用上下文 "/war"
            type: 'DELETE',
            success: function(response) {
                $('#deleteUserResult').text(response);
            },
            error: function() {
                $('#deleteUserResult').text('Error deleting user.');
            }
        });
    }
</script>

</body>
</html>
