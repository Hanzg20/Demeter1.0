<%-- 
    Document   : Item Listing 
    Created on : Mar 31, 2024, 11:39:26 a.m.
    UPdated on :Apri 6 ,2023
    Author     : Zhaoguo Hna
    
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <jsp:include page="/resources/layout/_css.jsp"/>
        <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
        <title>My Purchased Items</title>
    </head>
    <body>
        <form method="get">
            <!-- Filter form -->
        </form>
        <h3>My Purchased Items</h3>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <table border="1">
                                <tr>
                                    <th>Notification ID</th>
                                    <th>Message</th>
                                    <th>Timestamp</th>
                                    <th>Status</th>
                                </tr>

                                <!-- Use forEach tag to iterate over the list of Notification objects -->
                                <c:forEach var="notification" items="${viewModel.items}">
                                    <tr>
                                        <td><c:out value="${notification.notiId}" /></td>
                                        <td><c:out value="${notification.message}" /></td>
                                        <td><c:out value="${notification.timestamp}" /></td>
                                        <td><c:out value="${notification.status}" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <!-- Display message if no items are found -->
                            <c:if test="${empty viewModel.items}">
                                <tr>
                                    <td colspan="8">No notification items found</td>
                                </tr>
                            </c:if>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
