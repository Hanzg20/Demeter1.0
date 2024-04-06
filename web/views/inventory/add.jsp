<%-- 
    Document   : add
    Created on : Mar 31, 2024, 11:08:33 a.m.
    Author     : liyingguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory-Add Item</title>
          <jsp:include page="/resources/layout/_css.jsp"/>
          <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
    </head>
    <body>
        <h2>Add Item</h2>
        <form method="post">
            <label for="itemName">Item Name:</label><br>
            <input type="text" id="itemName" name="itemName"><br><br>

            <label for="unit">Unit:</label><br>
            <input type="text" id="unit" name="unit"><br><br>

            <label for="locationId">Location:</label><br>
            <select id="locationId" name="locationId">
                <c:forEach var="location" items="${viewModel.locations}">
                    <option value="${location.locationId}">${location.address}</option>
                </c:forEach>
            </select><br><br>

            <label for="createDate">Create Date:</label><br>
            <input type="datetime-local" id="createDate" name="createDate"><br><br>

            <label for="userId">User:</label><br>
            <select id="userId" name="userId">
                <c:forEach var="user" items="${viewModel.users}">
                    <option value="${user.userId}">${user.name}</option>
                </c:forEach>
            </select><br><br>
            
            <label for="itemTypeId">Item Type:</label><br>
            <select id="itemTypeId" name="itemTypeId">
                <c:forEach var="type" items="${viewModel.types}">
                    <option value="${type.itemTypeId}">${type.itemTypeName}</option>
                </c:forEach>
            </select><br><br>

            <label for="quantity">Quantity:</label><br>
            <input type="number" id="quantity" name="quantity"><br><br>

            <label for="expirDate">Expiry Date:</label><br>
            <input type="datetime-local" id="expirDate" name="expirDate"><br><br>

            <label for="price">Price:</label><br>
            <input type="number" id="price" name="price" step="any"><br><br>

            <label for="status">Status:</label><br>
            <select id="status" name="status">
                <c:forEach var="option" items="${viewModel.statusOptions}">
                   <option value="${option.symbol}" ${option.symbol eq "A" ? 'selected' : ''}>${option.text}</option>
               </c:forEach>
            </select><br><br>
            
            <label for="statusDate">Status Date:</label><br>
            <input type="datetime-local" id="statusDate" name="statusDate"><br><br>

            <input type="submit" value="Add Item">
        </form>
    </body>
        <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
    <script>
          <jsp:include page="/resources/layout/_script.jsp"/>
           <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
           
</script>
</html>
