<%--https://stackoverflow.com/questions/4928271/how-to-install-jstl-it-fails-with-the-absolute-uri-cannot-be-resolved-or-una --%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page import="businesslayer.AuthorsBusinessLogic"%>
<%@page import="java.util.List" %>
<%@page import="model.Author" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% AuthorsBusinessLogic authorService = new AuthorsBusinessLogic();
    List<Author> authors = authorService.getAllAuthors(); %>
--%>

<html>
    <head>
        <title>User List</title>
    </head>
    <body>
        <h2>User List</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% List<Author> authors = (List<Author>) request.getAttribute("authors");
                for (Author author : authors) {%>
                <tr>
                    <td><%= author.getAuthorID()%></td>
                    <td><%= author.getFirstName()%></td>
                    <td><%= author.getLastName()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
