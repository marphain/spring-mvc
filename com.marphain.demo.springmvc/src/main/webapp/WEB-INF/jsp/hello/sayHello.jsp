<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>sayHello</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
</head>
<body>
    <p>${context}</p>
    <div class="container">
	    <a href="http://www.baidu.com">百度</a>
    </div>
    <img class="img-responsive" src="${pageContext.request.contextPath}/img/bg-top.png" alt="响应式" >
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>