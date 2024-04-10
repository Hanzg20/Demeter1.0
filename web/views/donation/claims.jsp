<%-- 
    Document   : My Cliams 
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
            
         <a href="javascript:history.back()">Back to On Donation</a>
        <form method="get">
            <label for="itemTypeFilter">Item Type:</label>
            <select id="itemTypeFilter" name="itemType">
                <option value="">All</option>
                <c:forEach items="${viewModel.typeOptions}" var="type">
                    <option value="${type.itemTypeId}" ${param.itemType eq type.itemTypeId ? 'selected' : ''}>${type.itemTypeName}</option>
                </c:forEach>
            </select>
            
             <label for="statusFilter">Location</label>
            <select id="statusFilter" name="status">
                <option value="">All</option>
                <c:forEach var="option" items="${viewModel.statusOptions}">
                   <option value="${option.symbol}" ${param.status eq option.symbol ? 'selected' : ''}>${option.text}</option>
               </c:forEach>
            </select>
       
            <label for="tranDateFilter">Claim Date (Within):</label>
            <select id="tranDateFilter" name="tranDateDays">
                <option value="" ${empty param.tranDateDays ? 'selected' : ''}>Any</option>
                <option value="1" ${param.tranDateDays eq '1' ? 'selected' : ''}>1 day</option>
                <option value="7" ${param.tranDateDays eq '7' ? 'selected' : ''}>7 days</option>
                <option value="30" ${param.tranDateDays eq '30' ? 'selected' : ''}>30 days</option>
                <option value="60" ${param.tranDateDays eq '60' ? 'selected' : ''}>60 days</option>
            </select>

            <input type="submit" value="Apply Filter">
        </form>
            
        <H2> My Claim List </H2>
       <div class="wrapper wrapper-content">
        <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table border="2">
                        <thead>
                            <tr>
                                <th>Item ID</th>
                                <th>Item Name</th>
                                <th>Unit</th>
                                <th>Location</th>
                                <th>Create Date</th>
                                <th>Provider</th>
                                <th>Item Type</th>
                                <th>Claim Quantity</th>
                                <th>Expire Date</th>
                                <th>Price</th>
                                <th>Status</th>
                                <th>Claim Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${viewModel.items}" var="item">
                                <tr>
                                    <td>${item.itemId}</td>
                                    <td>${item.itemName}</td>
                                    <td>${item.unit}</td>
                                    <td>${item.location}</td>
                                    <td>${item.createDate}</td>
                                    <td>${item.userName}</td>
                                    <td>${item.itemType}</td>
                                    <td>${item.quantity}</td>
                                    <td>${item.expirDate}</td>
                                    <td>${item.price}</td>
                                    <td>${item.status}</td>
                                    <td>${item.statusDate}</td>
                                    <td>
                                        <a href="donate?id=${item.itemId}">delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
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