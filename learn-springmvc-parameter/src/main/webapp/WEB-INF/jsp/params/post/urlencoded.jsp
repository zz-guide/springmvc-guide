<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>>POST application/x-www-form-urlencoded 请求方式</title>
</head>
<body>
<div>
    <div><button onclick="handleClick1()">必传，实体类接收</button></div>
    <div><button onclick="handleClick2()">请求体 为null，实体类接收</button></div>
    <div><button onclick="handleClick3()">请求体 为 空字符串，实体类接收</button></div>
    <div><button onclick="handleClick4()">请求体 必传，多个形参接收</button></div>
    <script>
        function handleClick1(){
            const params = new URLSearchParams();
            params.append('username', '用户1');
            params.append('id', '1');
            console.log("param:", params.toString())

            fetch("${pageContext.request.contextPath}/params/post/urlEncoded/require", {
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
            fetch("${pageContext.request.contextPath}/params/post/urlEncoded/noRequire", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: null, // 或者这里直接不写，效果一样
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick3(){
            fetch("${pageContext.request.contextPath}/params/post/urlEncoded/noRequire", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: "",
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick4(){
            const params = new URLSearchParams();
            params.append('username', '用户123');
            params.append('id', '145');
            console.log("param:", params.toString())

            // url上的参数会覆盖 URLSearchParams定义的参数
            fetch("${pageContext.request.contextPath}/params/post/urlEncoded/multiParams?username=222&id=444", {
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