<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>系统内部首页</title>
</head>
<body>
    消息:${msg}
<div>
    <div>功能列表</div>
    <div><a href="home">测试空路由</a></div>
    <div><a href="home/index">进入内部系统首页</a></div>

    <div><a href="model/model">测试Model接口传参到视图</a></div>
    <div><a href="model/model2">测试ModelMap接口传参到视图</a></div>
    <div><a href="model/model3">测试Map接口传参到视图</a></div>

    <div><a href="view/view">测试 controller 返回字符串 当做视图</a></div>
    <div><a href="view/view2">测试 controller 返回ModalAndView 当做视图</a></div>

    <div><a href="domain/session">测试 HttpSession 域 传参</a></div>
    <div><a href="domain/session2">测试 @SessionAttributes 传参</a></div>
    <div><a href="domain/application">测试 application 传参</a></div>

    <div><a href="forward/index">测试 forward</a></div>
    <div><a href="forward/index2">测试 forward2 转发到 controller</a></div>

    <div><a href="redirect/index">测试 redirect</a></div>
    <div><a href="redirect/index2">测试 redirect2</a></div>
    <div><a href="redirect/index3">测试 redirect3 重定向到外网地址</a></div>

    <div><a href="page">测试 mvc:view-controller </a></div>
</div>
</body>
</html>