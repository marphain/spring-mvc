<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="e" uri="/ETLagLib"%>
<%@ taglib prefix="t" uri="/Test"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>

</head>

<body style="background:url('/web/img/bg.PNG');position: absolute;width: 100%;height: 100%">
<!-- <div class="" id="" style="">
    <img alt="梧桐山" src="/web/img/wutong.jpg" style="">
</div -->

<jsp:useBean id="user" scope="page" class="marphain.web.bean.User" type="marphain.web.bean.User">
    <jsp:setProperty property="username" name="user" value="marphain"/>
    <jsp:setProperty property="password" name="user" value="123456"/>
    <jsp:setProperty property="sex" name="user" value="男"/>
</jsp:useBean>

<div>
   <form action="/web/RegisterServlet" method="post">
       <table border="1">
	       <thead>
		       <tr>
		           <td colspan="2" align="center">servlet注册</td>
		       </tr>
	       </thead>
	       <tbody>
	           <tr>
	               <td>用户名：</td>
	               <td><input type="text" name="userName"></td>
	           </tr>
	           <tr>
	               <td>密码：</td>
	               <td><input type="password" name="password"></td>
	           </tr>
	           <tr>
	               <td>性别：</td>
	               <td>
	                   <input type="radio" name="sex" checked="checked" value="male">male
	                   <input type="radio" name="sex" value="female">female
	               </td>
	           </tr>
	           <tr>
	               <td colspan="2" align="center">
	                   <input type="submit" value="注册">
	                   <input type="reset" value="重置">
	               </td>
	           </tr>
	       </tbody>
       </table>
   </form>
</div>
</body>
</html>