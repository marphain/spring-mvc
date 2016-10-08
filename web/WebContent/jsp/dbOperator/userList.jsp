<!DOCTYPE html>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%! String[] columns = null;%>
<%
try
{
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "123456";
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url, user, password);
    
    String sql = "select * from user";
    PreparedStatement ps = connection.prepareStatement(sql);
    
    ResultSet result = ps.executeQuery();
    ResultSetMetaData rsmd = result.getMetaData();
    columns = new String[rsmd.getColumnCount()];
    for(int i = 0; i < columns.length; i++)
    {
        columns[i] = rsmd.getColumnName(i + 1);
    }
    request.setAttribute("columns", columns);
    ps.close();
}
catch (ClassNotFoundException e)
{
    e.printStackTrace();
}
catch (SQLException e)
{
    e.printStackTrace();
}
%>

<table border="1">
    <thead>
	    <tr><c:forEach items="${columns }" var="column">
	        <td>${column}</td>
	    </c:forEach></tr>
    </thead>
    <tbody></tbody>
</table>
</body>
</html>