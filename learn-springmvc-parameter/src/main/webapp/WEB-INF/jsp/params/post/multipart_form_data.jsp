<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>POST multipart/form-data 请求方式</title>
</head>
<body>
<div>
    <div><button onclick="handleClick1()">必传，多个形参接收 </button></div>
    <div><button onclick="handleClick2()">必传，实体类接收</button></div>
    <div><button onclick="handleClick3()">非必传，实体类接收</button></div>
    <script>
        function handleClick1(){
            const formData = new FormData();
            formData.append('id', '1');
            formData.append('username', '用户1');

            fetch("${pageContext.request.contextPath}/params/post/formData/multiParams", {
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
                body: formData,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick2(){
            const formData = new FormData();
            formData.append('id', '2');
            formData.append('username', '用户2');

            fetch("${pageContext.request.contextPath}/params/post/formData/require", {
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
                body: formData,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick3(){
            fetch("${pageContext.request.contextPath}/params/post/formData/noRequire", {
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
                body: null,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }
    </script>
</div>
</body>
</html>