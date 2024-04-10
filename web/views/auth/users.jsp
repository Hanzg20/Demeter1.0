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
     <jsp:include page="/resources/layout/_css.jsp"/>
     <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
</head>
<body>
    <div class="main-container">
        <div class="main-row">
            <div class="main-section">
                    <h1>User List</h1>
                   <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <table border="2">
                                        <thead>
                                        <tr>
                                            <th>User ID</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Role ID</th>
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
                                                <!-- Add more columns if needed -->
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                  </table>
                                </div>
                            </div>
                        </div>
                    </div>
           </div>
   </div>
   </div>
</body>
</html>
