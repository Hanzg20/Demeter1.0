<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="icon" type="image/png" href="${ctx}/resources/img/favicon.ico">
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/userlogin/component.css" />
    <!--[if IE]>
    <!--<script src="js/html5.js"></script>-->
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
              <h3> Food Waste Peduce Platform </h3>
                <form  method="post" id="form1">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input type="email" name="email" class="text" style="color: #FFFFFF !important" type="text" placeholder="email">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="password">
                    </div>
                    <div class="act-but submit" href="javascript:;" style="color: #FFFFFF">
                        <input type="button" value="login" id="button1" style="background: #0096E6;border: 0px;color: #FFF7FB;"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
</body>
<script src="${ctx}/resources/js/userlogin/TweenLite.min.js"></script>
<script src="${ctx}/resources/js/userlogin/EasePack.min.js"></script>
<script src="${ctx}/resources/js/userlogin/rAF.js"></script>
<script src="${ctx}/resources/js/userlogin/demo-1.js"></script>
<script src="${ctx}/resources/js/jquery/jquery-3.2.1.js"></script>
<script src="${ctx}/resources/js/layer/layer.min.js"></script>
</html>
