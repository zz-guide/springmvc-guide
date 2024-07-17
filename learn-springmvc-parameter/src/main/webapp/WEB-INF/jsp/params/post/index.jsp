<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 POST 接收参数</title>
</head>
<body>
<div>
    <div><a href="${pageContext.request.contextPath}/params/post/post_application_json">application/json 接收</a></div>
    <div><a href="${pageContext.request.contextPath}/params/post/post_multipart_form_data">multipart/form-data 接收</a></div>
    <div><a href="${pageContext.request.contextPath}/params/post/post_urlencoded">application/x-www-form-urlencoded 接收</a></div>
</div>
</body>
</html>