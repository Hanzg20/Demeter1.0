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
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
          <title>Edit Subscription</title>
       </head>
<body>
        <a href="javascript:history.back()">Back to Subscription List</a>
        <div class="main-container">
                <div class="main-section">
                <h3>Edit Subscription</h3>
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
                    <br><br>
                    <input type="submit" value="Update">
               </form>
          </div>          
         </div> 
    </div>
</body>
<jsp:include page="/resources/layout/_script.jsp"/>
<script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js"></script>
<script>
  <jsp:include page="/resources/layout/_script.jsp"/>
  <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
</script>

</html>
