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
  </head>
<body>
    <h2>Subscription List</h2>
 <div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table border="2">
                        <thead>
                            <tr>
                                <th>Subscriber</th>
                                <th>Notification Method</th>
                                <th> Location</th>
                                <th> Price range</th>
                                <th>Item Type </th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%-- Loop through each subscription and display its details --%>
                      <c:forEach items="${viewModel.subscriptions}" var="subscription">
                            <tr>
                                <td>${subscription.userId}</td>
                                <td>${subscription.notiMethod}</td>
                                <td>${subscription.itemLocation}</td>
                                <td>${subscription.itemPrice}</td>
                                <td>${subscription.itemTypeId}</td>
                                <td>
                                    <a href="edit?id=${subscription.subsId}">Edit</a>
                                    <a href="delete?id=${subscription.subsId}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <a href="add">Add New Subscription</a>
    </div>
</div>
</body>
</html>

</html>
