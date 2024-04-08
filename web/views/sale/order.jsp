<%-- 
    Document   : purchase
    Created on : Mar 31, 2024, 11:45:09 a.m.
    Author     : liyingguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction Page</title>
    </head>
    <body>
        <h1>Purchase item!</h1>
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
            <tr>
                <td>Discount Rate:</td>
                <td><c:out value="${item.discountRate}" /></td>
            </tr>
        </table>
    </body>
        <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
    <script>
          <jsp:include page="/resources/layout/_script.jsp"/>
           <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
</script>
</html>
