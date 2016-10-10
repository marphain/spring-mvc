<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>DIV+CSS布局(盒子模型)</title>
<link href="/web/css/bootstrap.min.css" rel="stylesheet">
<link href="/web/css/first.css" rel="stylesheet">
<script type="text/javascript" src="/web/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="/web/js/bootstrap.min.js"></script>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="logo"><p>padding设置内容与边框的距离</p></div>
    </div>
    <div id="content">
        <div id="content_left">
            <ul>
                <li><a href="#">菜单1</a></li>
                <li><a href="#">菜单2</a></li>
                <li><a href="#">菜单3</a></li>
                <li><a href="#">菜单4</a></li>
                <div class="dropdown">
                    <a href="#">菜单5</a>
                    <div class="dropdown-context">
                        <a href="#" style="display: block;">子菜单1</a>
                        <a href="#" style="display: block;">子菜单2</a>
                        <a href="#" style="display: block;">子菜单3</a>
                    </div>
                </div>
                <li><a href="#">菜单6</a></li>
            </ul>
            <div id="audioId">
                <audio src="/web/audio/jiujielun.mp3" controls="controls"></audio>
            </div>
        </div>
        <div id="content_main">
            <video src="/web/video/mov_bbb.mp4" poster="/web/img/bg.PNG" controls="controls"
                style="position: relative; width: 100%; height: 100%">
            </video>
        </div>
    </div>
    <div class="clear"></div>
    <div id="footer">footer</div>
</div>
</body>
</html>