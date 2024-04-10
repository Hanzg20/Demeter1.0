<%-- 
    Document   : purchase
    Created on : Mar 31, 2024, 11:45:09 a.m.
    Author     : liyingguo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
        <title>Inventory-Add Item</title>
    </head>
    <body>
        <a href="javascript:history.back()">Back to sale</a>
           <div class="main-container">
            <div class="main-section">
                   <h3>Item Information</h3>
                    <table>
                        <tr>
                            <td>Listing Date:</td>
                           <td><fmt:formatDate value="${item.listingDate}" pattern="MM-dd-yyyy" /> </td>               
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
                            <td>Item Type </td>
                            <td><c:out value="${item.itemTypeName}" /></td>
                        </tr>
                        <tr>
                            <td>Quantity:</td>
                            <td><c:out value="${item.quantity}" /></td>
                        </tr>
                        <tr>
                            <td>Expiry Date:</td>
                             <td><fmt:formatDate value="${item.expirDate}" pattern="MM-dd-yyyy" />  </td>         
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><c:out value="${item.address}" /></td>
                        </tr>
                        <tr>
                            <td>Discount Rate:</td>
                           <td> <fmt:formatNumber value="${item.discountRate}" type="percent" /> </td>
                        </tr>
                    </table>
                  </div>     
                        
                    <form method="post">
                        <label for="amount">Amount:</label>
                        <input type="number" id="quantity" name="quantity" required><br><br>
                        <input type="submit" name="action" value="Buy">
                    </form>
        </div> 
</body>
 
</html>
