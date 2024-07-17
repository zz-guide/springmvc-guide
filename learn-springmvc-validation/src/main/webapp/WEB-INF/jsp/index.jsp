<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 springmvc 参数接收和校验等</title>
</head>
<body>
<div>
    <h1>练习参数接收</h1>
    <div><a href="${pageContext.request.contextPath}/params/get">GET 传参</a></div>
    <br>
    <div><a href="${pageContext.request.contextPath}/params/post">POST 传参</a></div>
</div>
<br/>
<div>=========================================================</div>
<div>
    <h1>练习参数校验</h1>
    <div><a href="${pageContext.request.contextPath}/validation/get">GET 校验参数</a></div>
    <br>
    <div><a href="${pageContext.request.contextPath}/validation/post">POST 校验参数</a></div>
</div>
</body>
</html>