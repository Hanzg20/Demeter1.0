<%-- 
    Document   : Profile
    Created on : Apr 6, 2024, 10:40:24 AM
    Author     : hanzg
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
          <title>User Registration</title>
       </head>
<body>
        <div class="main-container">
          <div class="main-section">
                <h3>User Registration</h3>
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
       </div> 
 </body>
</html>
