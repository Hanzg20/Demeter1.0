<%-- 
    Document   : Profile
    Created on : Apr 6, 2024, 10:40:24 AM
    Author     : hanzg
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
</head>
<body>
  <div class="profile-container">
        <h1>User Registration</h1>
        <!-- Form to register a new user -->
             <form action="UserServlet" method="POST">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>
                <label for="role">Role Name:</label>
                <input type="number" id="role" name="roleId" required><br>
                <input type="submit" value="Register">
            </form>
         </div>
    </body>
</html>
