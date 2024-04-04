<%-- 
    Document   : home.jsp
    Created on : Mar 24, 2024, 11:50:30 PM
    Author     : hanzg
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Demeter</title>
    <%@ include file="/WEB-INF/style.jsp" %>
</head>

<%@ include file="/views/Common/header.jsp" %>

<h3>My Dashboard</h3>

<div>
	<div>Name${sessionScope.self.id} </div>
	<div>Id ${sessionScope.self.name}</div>
	<div> Email${sessionScope.self.email}</div>
	<div>Role ${sessionScope.self.sex}</div>
	<div>
	  my job <br/>
	   <textarea rows="5" cols="50" readonly="readonly">${sessionScope.self.intro}</textarea>
    </div>
</div>	

<div>
	<a href="${pageContext.request.contextPath}/change_info" target="_self">>change_info</a><br/>
	<a href="${pageContext.request.contextPath}/change_pass" target="_self">>change_pass</a>
</div>

<%@ include file="/views/Common/footer.jsp" %>
</html>