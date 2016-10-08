<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>sayHello</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
</head>
<body>
    <div class="container">
	    <p>${context}</p>
	    <div class="row">
	        <div class="col-xs-9 col-sm-7 col-md-8 col-lg-6" style="background-color: red">网格系统</div>
	        <div class="col-xs-3 col-sm-5 col-md-2 col-lg-4 col-md-offset-1" style="background: gray"><a href="http://www.baidu.com">百度</a></div>
	    </div>
	    
	    <div class="row">
	        <div class="col-xs-12">
	            <div class="row">
	                <div class="col-xs-6" style="background-color: gray">1</div>
	                <div class="col-xs-6">2</div>
	            </div>
	            <div class="row">
	                <div class="col-xs-6">3</div>
	                <div class="col-xs-6" style="background-color: gray">4</div>
	            </div>
	        </div>
	    </div>
	    
	    <img class="img-responsive" src="${pageContext.request.contextPath}/img/bg-top.png" alt="响应式" >
    </div>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>