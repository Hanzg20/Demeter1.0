<%-- 
    Document   : register
    Created on : Mar 19, 2024, 2:39:34 p.m.
    Author     : liyingguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
        <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
        <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/normalize.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/demo.css" />

        <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/component.css" />
          <!--[if IE]>
         <!--<script src="js/html5.js"></script>-->
          <![endif]-->
    </head>

    <body>
        <h1>User Registration</h1>
    
        <!-- Form to register a new user -->
        <form action="UserServlet" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <label for="role">Role ID:</label>
            <input type="number" id="role" name="roleId" required><br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
