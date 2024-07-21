<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    request.setAttribute("today", today);
%>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 GET 校验参数 @Validated</title>
</head>
<body>
<div>
    <div>实体类接收</div>

    <br/>
    <div>Number</div>
    <div><a href="${pageContext.request.contextPath}/validation/get/testNumber?min=1">min</a></div>

</div>
</body>
</html>