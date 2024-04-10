<%-- 
    Document   : claim
    Created on : Mar 31, 2024, 11:49:32 a.m.
    Author     : liyingguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donation - claim</title>
    </head>
    <body>
        <h1>Claim an item!</h1>
        <table border="1">
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Listing Date:</td>
                <td><c:out value="${item.listingDate}" /></td>
            </tr>
            <tr>
                <td>Item Name:</td>
                <td><c:out value="${item.itemName}" /></td>
            </tr>
            <tr>
                <td>Unit:</td>
                <td><c:out value="${item.unit}" /></td>
            </tr>
            <tr>
                <td>Item Type Name:</td>
                <td><c:out value="${item.itemTypeName}" /></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><c:out value="${item.quantity}" /></td>
            </tr>
            <tr>
                <td>Expiry Date:</td>
                <td><c:out value="${item.expirDate}" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><c:out value="${item.address}" /></td>
            </tr>
        </table>
        <form method="post">
            <label for="amount">Amount:</label>
            <input type="number" id="quantity" name="quantity" required><br><br>
            <input type="submit" name="action" value="claim">
        </form>
    </body>
    
    <jsp:include page="/resources/layout/_script.jsp"/>
    <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
    <script>
          <jsp:include page="/resources/layout/_script.jsp"/>
           <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
</script>
</html>
