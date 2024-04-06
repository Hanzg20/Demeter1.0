<%-- 
    Document   : userlist
    Created on : Mar 17, 2024, 6:18:10 PM
    Author     : hanzg
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Role ID</th>
                <th>Create Date</th>
                <!-- Add more columns if needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.roleId}</td>
                    <td>${user.createDate}</td>
                    <!-- Add more columns if needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
