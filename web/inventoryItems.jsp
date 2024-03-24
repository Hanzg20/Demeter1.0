<%-- 
    Document   : inventoryItems
    Created on : Mar. 23, 2024, 10:38:28 a.m.
    Author     : Glily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>Item Id</th>
                <th>Item Name</th>
                <th>Unit</th>
                <th>Location Id</th>
                <th>Create Date</th>
                <th>User Id</th>
                <th>Item Type</th>
                <th>Quantity</th>
                <th>Expiry Date</th>
                <th>Item Price</th>
                <th>Item Status</th>
                <th>Status Date</th>
            </tr>
            
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.getItemId()}</td>
                    <td>${item.getItemName()}</td>
                    <td>${item.getUnit()}</td>
                    <td>${item.getLocationId()}</td>
                    <td>${item.getCreateDate()}</td>
                    <td>${item.getUserId()}</td>
                    <td>${item.getItemType()}</td>
                    <td>${item.getQuantity()}</td>
                    <td>${item.getExpirDate()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getStatus()}</td>
                    <td>${item.getStatusDate()}</td>
                </tr>
            </c:forEach>
            

            
        </table>   
    </body>
</html>
