<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>DIV+CSS布局</title>
<link href="/web/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/web/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/web/js/jquery-1.12.1.min.js"></script>
<style type="text/css">
#container{
    width: 900px;
    margin: 0 auto;
    background: #CF3;
}
#header{
    height: 50px;
    background: #093;
}
#logo{
    padding-bottom: 20px;
    padding-left: 20px;
    padding-top: 20px;
}
#content{
    height: 600px;
    margin-top: 20px;
    background: #0FF;
}
#content_left{
    width: 300px;
    height: 500px;
    margin: 20px;
    float: left;
    background: #90C;
}
#content_main{
    width: 500px;
    height: 500px;
    margin: 20px;
    float: left;
    background: #000;
}
#footer{
    height: 50px;
    margin-top: 20px;
    background: #90C;    
}
#audioId{
    height: 30px;
    margin-top: 470px;
    background: #FFF;
}
.clear{
    clear: both;
}
/* body{
    background: url('/web/img/wutong.jpg');
    background-position: center;
    background-repeat: no-repeat;
} */
</style>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="logo">padding设置内容与边框的距离</div>
    </div>
    <div id="content">
        <div id="content_left">
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