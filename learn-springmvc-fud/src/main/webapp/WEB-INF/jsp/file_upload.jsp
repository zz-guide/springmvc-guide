<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文件上传</title>
</head>
<body>
<div>
    <h1>文件上传，测试参数</h1>
    <form action="${pageContext.request.contextPath}/file/upload/t1" method="post" enctype="multipart/form-data">
        <label for="file">选择文件：
            <input type="file" id="file" name="file" accept=".jpg, .jpeg, .png, .gif">
        </label>

        <input type="submit" value="上传">
    </form>
</div>
<br />
<div>============================================================================================================</div>
<div>
    <h1>文件上传一：servlet原生输入输出流读写</h1>
    <form action="${pageContext.request.contextPath}/file/upload/t2" method="post" enctype="multipart/form-data">
        <label for="file2">选择文件：
            <input type="file" id="file2" name="file2" accept=".jpg, .jpeg, .png, .gif">
        </label>

        <input type="submit" value="上传">
    </form>
</div>
<br />
<div>
    <h1>文件上传二：springmvc提供transfer()方式保存</h1>
    <form action="${pageContext.request.contextPath}/file/upload/t3" method="post" enctype="multipart/form-data">
        <label for="file3">选择文件：
            <input type="file" id="file3" name="file3" accept=".jpg, .jpeg, .png, .gif">
        </label>

        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>