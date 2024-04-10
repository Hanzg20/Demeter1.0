
<%-- 
    Document   : User Listing 
    Created on : Apri 9 ,2023
    Author     : Liying Guo
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/resources/layout/_css.jsp"/>
        <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
    </head>    
    <body>
        <nav>
            <ul>
                <li><a href="claims">my claims</a></li>
            </ul>
        </nav>

        <H2> User List</H2>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <table>
                                <thead>
                                    <tr>
                                        <th>User ID</th>
                                        <th>User Name</th>
                                        <th>Role</th>
                                        <th>Email</th> 
                                 
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${viewModel.items}" var="user">
                                        <tr>
                                            <td>${user.userId}</td>
                                            <td>${user.name}</td>
                                            <td>${user.roleName}</td>
                                            <td>${user.email}</td>
                              
                                            <td>
                                                <form action="EditUserServlet" method="get">
                                                    <a href="edit?id=${user.userId}">Edit</a>
                                                    <input type="submit" value="Edit">
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="/resources/layout/_script.jsp"/>
    <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
</html>
