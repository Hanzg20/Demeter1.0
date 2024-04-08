<%-- 
    Document   : add
    Created on : Mar 31, 2024, 11:08:33 a.m.
    Author     : ZhAOGUO HAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory-Add Item</title>
          <jsp:include page="/resources/layout/_css.jsp"/>
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
          <title>Add Subscription</title>
       </head>
<body>
    <div class="container">
        <a href="javascript:history.back()">Back to Subscription List</a>
        <h2>Add Subscription</h2>
        <form method="post" action="SubsControllerServlet">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
            
            <label for="notiMethod">Notification Method:</label>
            <input type="text" id="notiMethod" name="notiMethod" required>
            
            <label for="itemLocation">Item Location:</label>
            <select id="itemLocation" name="itemLocation" required>
                <option value="Location1">Location1</option>
                <option value="Location2">Location2</option>
                <!-- Add more options as needed -->
            </select>
            
            <label for="itemPrice">Item Price:</label>
            <input type="text" id="itemPrice" name="itemPrice" required>
            
            <label for="itemTypeId">Item Type ID:</label>
            <select id="itemTypeId" name="itemTypeId" required>
                <option value="1">Type 1</option>
                <option value="2">Type 2</option>
                <!-- Add more options as needed -->
            </select>
            
            <input type="submit" value="Add Subscription">
        </form>
    </div>
</body>
</html>
