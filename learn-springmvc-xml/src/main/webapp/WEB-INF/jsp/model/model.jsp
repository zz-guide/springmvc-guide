<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Model 接口传参</title>
</head>
<body>
    <div>
        <div>model.addAllAttributes(map) 传参到视图</div>
        <div>id: ${id}</div>
    </div>

    <div>
        <div>model.addAttribute() 传参到视图</div>
        <div>账号: ${username}</div>
    </div>
</body>
</html>