<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Restful</title>
</head>
<body>
<div>
    <div>Restful</div>
    <div><a href="user/list">查看用户列表</a></div>
    <div><a href="user/1">根据id查看用户信息</a></div>
    <div>
        <div>新增用户信息</div>
        <form action="user/save" method="post">
            <label>用户名:
                <input type="text" name="username">
            </label>

            <label>密码:
                <input type="text" name="password">
            </label>

            <input type="submit" value="修改">
        </form>
    </div>

    <div>
        <div>修改用户信息</div>
        <form action="user/update" method="post">
            <!--put 请求需要增加一个隐藏域， 固定写法-->
            <input type="hidden" name="_method" value="put">
            <label>用户名:
                <input type="text" name="username">
            </label>

            <label>密码:
                <input type="text" name="password">
            </label>

            <input type="submit" value="修改">
        </form>
    </div>
    <div>
        <div><a href="javascript:void(0);" onclick="delUser()">根据id删除用户信息</a></div>
        <form id="deleteForm" method="post">
            <input type="hidden" name="_method" value="delete">
        </form>
    </div>

    <div>
        <div>原生 ServletApi 响应 ajax请求</div>
        <button onclick="sendAjaxRequest()">点我发送ajax请求</button>
        <div>响应:<span id="ajaxResponse"></span></div>
    </div>

    <div>
        <div>@ResponseBody 响应 ajax请求，返回字符串</div>
        <button onclick="sendAjaxRequest2()">点我发送ajax请求</button>
        <div>响应:<span id="ajaxResponse2"></span></div>
    </div>

    <div>
        <div>@ResponseBody 响应 ajax请求，返回实体类对象</div>
        <button onclick="sendAjaxRequest3()">点我发送ajax请求</button>
        <div>响应:<span id="ajaxResponse3"></span></div>
    </div>

    <div>
        <div>RestController 响应 ajax请求，返回字符串</div>
        <button onclick="sendRestAjaxRequest2()">点我发送ajax请求</button>
        <div>响应:<span id="restAjaxResponse2"></span></div>
    </div>

    <div>
        <div>RestController 响应 ajax请求，返回实体类</div>
        <button onclick="sendRestAjaxRequest3()">点我发送ajax请求</button>
        <div>响应:<span id="restAjaxResponse3"></span></div>
    </div>

    <div>
        <div>测试 RequestEntity</div>
        <button onclick="requestEntitySend()">点我发送ajax请求</button>
        <div>响应:<span id="requestEntityResponse"></span></div>
    </div>

    <div>
        <div>测试 ResponseEntity</div>
        <button onclick="responseEntitySend()">点我发送ajax请求</button>
        <div>响应:<span id="responseEntityResponse"></span></div>
    </div>

    <div>
        <div>测试 文件上传</div>
        <div><a href="file/uploadIndex">进入文件上传页面</a></div>
    </div>

    <div>
        <div>测试 文件下载</div>
        <div><a href="file/download">点击下载文件</a></div>
    </div>

    <div>
        <div>测试自定义异常</div>
        <div><a href="exception/test">点击触发异常</a></div>
    </div>
    <script>
        function delUser() {
            let deleteForm = document.getElementById("deleteForm");
            deleteForm.action = "user/1";
            deleteForm.submit();
        }

        function sendAjaxRequest() {
            fetch("ajax/ajax")
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("ajaxResponse").textContent = data.msg
                })
                .catch(error => console.error('Error:', error));
        }

        function sendAjaxRequest2() {
            fetch("ajax/ajax2")
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("ajaxResponse2").textContent = data.msg
                })
                .catch(error => console.error('Error:', error));
        }

        function sendAjaxRequest3() {
            fetch("ajax/ajax3")
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("ajaxResponse3").textContent = data.username + data.password
                })
                .catch(error => console.error('Error:', error));
        }

        function sendRestAjaxRequest2() {
            fetch("restAjax/ajax2")
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("restAjaxResponse2").textContent = data.msg
                })
                .catch(error => console.error('Error:', error));
        }

        function sendRestAjaxRequest3() {
            fetch("restAjax/ajax3")
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("restAjaxResponse3").textContent = data.username + data.password
                })
                .catch(error => console.error('Error:', error));
        }

        function requestEntitySend() {
            let formData = {username:"用户",password:"123456"};
            fetch("requestEntity/test", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json', // 如果发送JSON数据
                    // 或者如果是表单数据：
                    // 'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: JSON.stringify(formData),
            })
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("requestEntityResponse").textContent = data.msg
                })
                .catch(error => console.error('Error:', error));
        }

        function responseEntitySend() {
            fetch("responseEntity/2", {
                method: 'GET',
            })
                .then(response => response.json())
                .then((data) => {
                    console.log(data)
                    document.getElementById("responseEntityResponse").textContent = data
                })
                .catch(error => console.error('Error:', error));
        }

    </script>
</div>
</body>
</html>