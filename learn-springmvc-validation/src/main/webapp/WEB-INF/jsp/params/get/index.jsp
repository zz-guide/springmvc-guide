<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 GET 接收参数</title>
</head>
<body>
    <div>
        <div> <a href="${pageContext.request.contextPath}/params/get/noRequireAndNoDefaultValue">参数 非必传，无默认值</a></div>
        <div> <a href="${pageContext.request.contextPath}/params/get/noRequire">参数 非必传，有默认值</a></div>
        <div> <a href="${pageContext.request.contextPath}/params/get/require?name=用户&id=123">参数 必传</a></div>
        <div> <a href="${pageContext.request.contextPath}/params/get/pojo?username=account&id=12">参数 实体类接收</a></div>
    </div>
</body>
</html>