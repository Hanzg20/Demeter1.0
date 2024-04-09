<%-- 
    Document   : Item Listing 
    Created on : Mar 31, 2024, 11:39:26 a.m.
    UPdated on :Apri 6 ,2023
    Author     : Zhaoguo Hna
    
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
                <li><a href="orders">My Orders  </a></li>
            </ul>
        </nav>

        <form method="get">
            <label for="itemTypeFilter">Item Type:</label>
            <select id="itemTypeFilter" name="itemType">
                <option value="">All</option>
                <c:forEach items="${viewModel.typeOptions}" var="type">
                    <option value="${type.itemTypeId}" ${param.itemType eq type.itemTypeId ? 'selected' : ''}>${type.itemTypeName}</option>
                </c:forEach>
            </select>

            <label for="expireDaysFilter">Expire Date (Within):</label>
            <select id="expireDaysFilter" name="expireDays">
                <option value="" ${empty param.expireDays ? 'selected' : ''}>Any</option>
                <option value="1" ${param.expireDays eq '1' ? 'selected' : ''}>1 day</option>
                <option value="7" ${param.expireDays eq '7' ? 'selected' : ''}>7 days</option>
                <option value="30" ${param.expireDays eq '30' ? 'selected' : ''}>30 days</option>
                <option value="60" ${param.expireDays eq '60' ? 'selected' : ''}>60 days</option>
            </select>

            <input type="submit" value="Apply Filter">
        </form>
        <H2> Available to purchase</H2>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <table border="1">
                                <tr>
                                    <th>Listing Date</th>
                                    <th>tranDate</th>
                                    <th>Item Name</th>
                                    <th>Unit</th>
                                    <th>Item Type Name</th>
                                    <th>Quantity</th>
                                    <th>Expiry Date</th>
                                    <th>Address</th>
                                    <th>Discount Rate</th>
                                    <th>Action</th>
                                </tr>
                                <c:forEach items="${viewModel.items}" var="item">
                                    <tr>
                                        <td><c:out value="${item.listingDate}" /></td>
                                        <td><c:out value="${item.tranDate}" /></td>
                                        <td><c:out value="${item.itemName}" /></td>
                                        <td><c:out value="${item.unit}" /></td>
                                        <td><c:out value="${item.itemTypeName}" /></td>
                                        <td><c:out value="${item.quantity}" /></td>
                                        <td><c:out value="${item.expirDate}" /></td>
                                        <td><c:out value="${item.address}" /></td>
                                        <td><c:out value="${item.discountRate}" /></td>
                                        <td>
                                            <a href="order?id=${item.listingId}">Order</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty viewModel.items}">
                                    <tr>
                                        <td colspan="8">No items found</td>
                                    </tr>
                                </c:if>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="/resources/layout/_script.jsp"/>
    <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
    <script>
        <jsp:include page="/resources/layout/_script.jsp"/>
    < script src = "${ctx}/resources/js/datapicker/bootstrap-datepicker.js" >
    </script>

</html>
