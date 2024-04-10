<%-- 
    Document   : Edit User
    Created on : Mar 31, 2024, 11:08:50 a.m.
    Author     : Liying Guo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
        <title>Inventory-Edit Item</title>
    </head>
    <body>
        <a href="javascript:history.back()">Back to Items List</a>
        <div class="main-container">
            <div class="main-section">    
                <h3>User Management</h3>
                <form action="UpdateUserServlet" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${user.name}"><br><br>

                    <label for="roleName">Role Name:</label>
                    <input type="text" id="roleName" name="roleName" value="${user.roleName}"><br><br>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${user.email}"><br><br>

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="${user.password}"><br><br>

                    <input type="submit" value="Update">
                </form>
            </div>
        </div>
    </body>
</script>
</html>
