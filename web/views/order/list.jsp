<%-- 
    Document   : Item Listing 
    Created on : Mar 31, 2024, 11:39:26 a.m.
    UPdated on :Apri 6 ,2023
    Author     : Zhaoguo Hna
    
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/resources/layout/_css.jsp"/>
    <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
    <title>My Purchased Items</title>
</head>
<body>
    <form method="get">
        <!-- Filter form -->
    </form>
    <h3>My Purchased Items</h3>
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <table border="2">
                            <tr>
                                <th>Listing ID</th>
                                <th>Item ID</th>
                                <th>Item Name</th>
                                <th>Unit</th>
                                <th>Type</th>
                                <th>Listing Date</th>
                                <th>Quantity</th>
                                <th>Expiry Date</th>
                                <th>Location</th>
                                <th>Discount </th>
                                <th>Order Date</th>
                            </tr>
                            <c:forEach items="${viewModel.items}" var="item">
                                <tr>
                                    <!-- Displaying item details -->
                                    <td><c:out value="${item.listingId}" /></td>
                                    <td><c:out value="${item.itemId}" /></td>
                                    <td><c:out value="${item.itemName}" /></td>
                                    <td><c:out value="${item.unit}" /></td>
                                    <td><c:out value="${item.itemTypeName}" /></td>
                                    <td>
                                        <fmt:formatDate value="${item.listingDate}" pattern="MM-dd-yyyy" />
                                    </td>
                                    <td><c:out value="${item.quantity}" /></td>
                                    <!-- Formatting Expiry Date -->
                                    <td>
                                        <fmt:formatDate value="${item.expirDate}" pattern="MM-dd-yyyy" />
                                    </td>
                                    <td><c:out value="${item.address}" /></td>
                                    <!-- Formatting discount rate as percentage -->
                                   
                                        <td> <fmt:formatNumber value="${item.discountRate}" type="percent" /> </td>
                                    
                                     <td>
                                        <fmt:formatDate value="${item.tranDate}" pattern="MM-dd-yyyy HH:mm:ss" />
                                    </td>
                               
                                </tr>
                            </c:forEach>
                            <!-- Display message if no items are found -->
                            <c:if test="${empty viewModel.items}">
                                <tr>
                                    <td colspan="8">No purchased items found</td>
                                </tr>
                            </c:if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
