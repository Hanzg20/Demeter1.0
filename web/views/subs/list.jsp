<%-- 
    Document   : Subscription List
    Created on : Mar. 23, 2024, 10:38:28 a.m.
    Author     : zhaoguo Han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
      <jsp:include page="/resources/layout/_css.jsp"/>
       <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
   <head>
    <meta charset="UTF-8">
    <title>Edit Subscription</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"], select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Edit Subscription</h2>
    <form method="post" action="/subs/edit">
        <input type="hidden" name="id" value="${subscription.subsId}">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" value="${subscription.userId}">
        <label for="notiMethod">Notification Method:</label>
        <input type="text" id="notiMethod" name="notiMethod" value="${subscription.notiMethod}">
        <label for="itemLocation">Item Location:</label>
        <input type="text" id="itemLocation" name="itemLocation" value="${subscription.itemLocation}">
        <label for="itemPrice">Item Price:</label>
        <input type="text" id="itemPrice" name="itemPrice" value="${subscription.itemPrice}">
        <label for="itemTypeId">Item Type ID:</label>
        <input type="text" id="itemTypeId" name="itemTypeId" value="${subscription.itemTypeId}">
        <input type="submit" value="Update">
    </form>
</body>
<jsp:include page="/resources/layout/_script.jsp"/>
<script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
<script>
  <jsp:include page="/resources/layout/_script.jsp"/>
  <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
</script>

</html>
