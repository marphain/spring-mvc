<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>

</head>

<body>
    <form action="uploadFile" enctype="multipart/form-data" method="post">
        <input type="file" name="uploadFile" multiple="multiple">
        <input type="submit" name="提交">
    </form>
</body>
</html>