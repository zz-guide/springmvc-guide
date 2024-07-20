<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>练习 GET 校验参数</title>
</head>
<body>
    <div>
        <div>实体类接收</div>

        <br />
        <div>Number</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNumber?min=1">min</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNumber?max=1">max</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNumber?dig=1">dig</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNumber?decimalMax=1">decimalMax</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNumber?decimalMin=1">decimalMin</a></div>

        <br />
        <div>@NotBlank</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotBlank?username=用户123">必传，非空</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotBlank">不传</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotBlank?username=%20">传入空格字符串(%20认为是空格)，抛异常</a></div>

        <br />
        <div>@NotEmpty</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotEmpty?name=用户123">必传，非空</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotEmpty?name=">不传</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotEmpty?name=%20">传入空格字符串(%20认为是空格)，正常接收</a></div>

        <br />
        <div>@AssertTrue @AssertFalse</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testAssert?trueBoolean=true">trueBoolean</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testAssert?falseBoolean=false">falseBoolean</a></div>

        <br />
        <div>@Past @Future</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testDate?testPast=2024-07-20">@Past 传入一个过去的日期</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testDate?testFuture=2024-07-20">@Future 传入一个将来的日期</a></div>

        <br />
        <div>@Email</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testEmail?email=373045134@qq.com">合格的email</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testEmail?email=xxx.com">不合格的mail</a></div>

        <br />
        <div>@Pattern</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testPattern?testPattern=123">合法Pattern</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testPattern?testPattern=xx">不合法Pattern</a></div>

        <br />
        <div>@Length</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testLength?testLength=12345">合法Length</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testLength?testLength=%20%20%20%20%20">不合法Length(空占长度)</a></div>

        <br />
        <div>@Size</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testSize?testSize=12345">合法Size</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testSize?testSize=">不合法Size(空占长度)</a></div>

        <br />
        <div>@Range</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testRange?testRange=4">合法Range</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testRange?testRange=6">不合法Range</a></div>

        <br />
        <div>@Null</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNull?testNull=可传参">null, 可传参（不报错）</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNull?testNull=">null, 可不传（不报错）</a></div>

        <br />
        <div>@NotNull</div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotNull?testNotNull=不为null">必传</a></div>
        <div> <a href="${pageContext.request.contextPath}/validation/get/testNotNull?testNotNull=">不传</a></div>
    </div>
    <br />
    <div>
        <div>不推荐使用多个形参校验接收，冗余且繁琐，推荐使用实体类接收</div>
    </div>
</body>
</html>