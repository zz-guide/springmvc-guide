<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 springmvc POST请求方式 参数校验</title>
</head>
<body>
<div>
    <div>
        <div>application/json 方式</div>
        <div>1. <button onclick="handleClick1()">基本类型，非必传，不设置默认值, </button></div>
    </div>

    <div>2. <button onclick="handleClick2()">基本类型，非必传， 设置了默认值, application/json</button></div>
    <div>3. <button onclick="handleClick3()">基本类型，必传, application/json</button></div>
    <div>3. <button onclick="handleClick4()">实体对象映射参数, application/json</button></div>
    <div>3. <button onclick="handleClick5()">实体对象映射参数,application/x-www-form-urlencoded</button></div>
    <script>
        function handleClick5(){
            const params = new URLSearchParams();
            params.append('name', '用户5');
            params.append('id', '5');
            console.log("param:", params.toString())
            fetch("${pageContext.request.contextPath}/params/post/require", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: params.toString(),
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }
        function handleClick2(){
            const params = new URLSearchParams();
            params.append('name', '用户5');
            params.append('id', '5');
            console.log("param:", params.toString())
            fetch("${pageContext.request.contextPath}/params/post/noRequire", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: params.toString(),
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }
        function handleClick3(){
            const params = new URLSearchParams();
            params.append('name', '用户5');
            params.append('id', '5');
            console.log("param:", params.toString())
            fetch("${pageContext.request.contextPath}/params/post/noRequire", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: params.toString(),
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }
    </script>
</div>
</body>
</html>