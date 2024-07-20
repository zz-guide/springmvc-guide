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
    <div>
        <a href="${pageContext.request.contextPath}/params/post/application_json">application/json 接收</a>
        <div>json字符串形式提交<div>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/params/post/multipart_form_data">multipart/form-data 接收</a>
        <div>multipart/form-data：表单数据被编码为一条消息，页上的每个控件对应消息中的一个部分</div>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/params/post/urlencoded">application/x-www-form-urlencoded 接收</a>
        <div>application/x-www-form-urlencoded：表单数据被编码为名称/值对，这是标准的编码格式，也是默认的</div>
    </div>
</div>
</body>
</html>