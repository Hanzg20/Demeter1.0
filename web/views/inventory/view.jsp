<%-- 
    Document   : view
    Created on : Mar 31, 2024, 12:43:57 p.m.
    Author     : liyingguo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
<title>View Item</title>
</head>
<body>
     <div class="main-container">
        <div class="main-row">
            <div class="main-section">
                <h2>Surplus Item</h2>

                  <table class="item-table">
                    <tr>
                        <th>Field</th>
                        <th>Value</th>
                    </tr>
                    <tr>
                        <td>Item ID</td>
                        <td>${item.itemId}</td>
                    </tr>
                    <tr>
                        <td>Item Name</td>
                        <td>${item.itemName}</td>
                    </tr>
                    <tr>
                        <td>Unit</td>
                        <td>${item.unit}</td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td>${item.location}</td>
                    </tr>
                    <tr>
                        <td>Create Date</td>
                        <td>${item.createDate}</td>
                    </tr>
                    <tr>
                        <td>User</td>
                        <td>${item.userName}</td>
                    </tr>
                    <tr>
                        <td>Item Type</td>
                        <td>${item.itemType}</td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td>${item.quantity}</td>
                    </tr>
                    <tr>
                        <td>Expiry Date</td>
                        <td>${item.expirDate}</td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td>${item.price}</td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>${item.status}</td>
                    </tr>
                    <tr>
                        <td>Status Date</td>
                        <td>${item.statusDate}</td>
                    </tr>
                </table>
            </div>
         </div>
         <form method="post">
        <input type="hidden" name="itemId" value="${item.itemId}">
        <input type="submit" name="action" value="set as Near expiration">
        <input type="submit" name="action" value="set as Excess of demand">
    </form>
       </div>
    <!-- Delete and Flag Buttons within the same form -->
    
</body>
</html>
