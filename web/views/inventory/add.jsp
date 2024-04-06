<%-- 
    Document   : add
    Created on : Mar 31, 2024, 11:08:33 a.m.
    Author     : liyingguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="AddItemServlet" method="post">
            <label for="itemName">Item Name:</label><br>
            <input type="text" id="itemName" name="itemName"><br><br>

            <label for="unit">Unit:</label><br>
            <input type="text" id="unit" name="unit"><br><br>

            <label for="locationId">Location ID:</label><br>
            <input type="text" id="locationId" name="locationId"><br><br>

            <label for="createDate">Create Date:</label><br>
            <input type="date" id="createDate" name="createDate"><br><br>

            <label for="userId">User ID:</label><br>
            <input type="text" id="userId" name="userId"><br><br>

            <label for="itemTypeId">Item Type ID:</label><br>
            <input type="text" id="itemTypeId" name="itemTypeId"><br><br>

            <label for="quantity">Quantity:</label><br>
            <input type="number" id="quantity" name="quantity"><br><br>

            <label for="expirDate">Expiry Date:</label><br>
            <input type="date" id="expirDate" name="expirDate"><br><br>

            <label for="price">Price:</label><br>
            <input type="number" id="price" name="price"><br><br>

            <label for="status">Status:</label><br>
            <input type="text" id="status" name="status"><br><br>

            <label for="statusDate">Status Date:</label><br>
            <input type="date" id="statusDate" name="statusDate"><br><br>

            <input type="submit" value="Add Item">
        </form>
    </body>
        <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
    <script>
          <jsp:include page="/resources/layout/_script.jsp"/>
           <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
           
</script>
</html>
