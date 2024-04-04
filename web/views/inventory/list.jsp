<%-- 
    Document   : inventoryItems
    Created on : Mar. 23, 2024, 10:38:28 a.m.
    Author     : Glily
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
        <div class="hr-line-dashed"></div>
            <form  class="form-horizontal" method="post" action="/SongUtilServlet?state=query">
             <input type="text" name="queryInfo"/>
            <div class="btn btn-primary">
            <input type="submit" value="查询" style="background: #1AB394;border: 0px;color: #FFF7FB;"/>
              </div>
      </form>
          <nav>
            <ul>
              <li><a href="add">add</a></li>
              <li><a href="edit">edit</a></li>
              <li><a href="view">view/delete</a></li>
            </ul>
          </nav>
        <h1>Inventory works!</h1>
       <div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table border="1" cellspacing="0" width="100%">
            <tr>
                <th>Item Id</th>
                <th>Item Name</th>
                <th>Unit</th>
                <th>Location Id</th>
                <th>Create Date</th>
                <th>User Id</th>
                <th>Item Type</th>
                <th>Quantity</th>
                <th>Expiry Date</th>
                <th>Item Price</th>
                <th>Item Status</th>
                <th>Status Date</th>
            </tr>
            
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.getItemId()}</td>
                    <td>${item.getItemName()}</td>
                    <td>${item.getUnit()}</td>
                    <td>${item.getLocationId()}</td>
                    <td>${item.getCreateDate()}</td>
                    <td>${item.getUserId()}</td>
                    <td>${item.getItemType()}</td>
                    <td>${item.getQuantity()}</td>
                    <td>${item.getExpirDate()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getStatus()}</td>
                    <td>${item.getStatusDate()}</td>
                </tr>
                </c:forEach> 
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
  <script src="${ctx}/resources/js/datapicker/bootstrap-datepicker.js">
</script>

</html>
