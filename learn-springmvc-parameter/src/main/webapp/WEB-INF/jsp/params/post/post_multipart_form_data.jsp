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
    <div>1. <button onclick="handleClick1()">FormData 参数，必传，实体类接收 </button></div>
    <div>2. <button onclick="handleClick2()">FormData 参数，非必传，实体类接收</button></div>
    <div>3. <button onclick="handleClick3()">FormData 参数，必传，多个形参接收</button></div>
    <script>
        function handleClick1(){
            const formData = new FormData();
            formData.append('id', '1');
            formData.append('username', '用户1');

            fetch("${pageContext.request.contextPath}/params/post/formData/require", {
                method: 'POST',
                body: formData,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick2(){
            const formData = new FormData();

            fetch("${pageContext.request.contextPath}/params/post/formData/require", {
                method: 'POST',
                body: formData,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }

        function handleClick3(){
            const formData = new FormData();
            formData.append('id', '1');
            formData.append('username', '用户1');

            fetch("${pageContext.request.contextPath}/params/post/formData/require", {
                method: 'POST',
                body: formData,
            }).then((resp) => {
                console.log("resp:", resp)
            })
        }
    </script>
</div>
</body>
</html>