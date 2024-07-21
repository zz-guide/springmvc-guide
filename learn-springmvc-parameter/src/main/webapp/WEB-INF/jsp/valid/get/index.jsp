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
    <title>练习 GET 校验参数 @Valid</title>
</head>
<body>
<div>
    <div>实体类接收</div>

    <br/>
    <div>Number</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNumber?min=1">min</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNumber?max=1">max</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNumber?dig=1">dig</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNumber?decimalMax=1">decimalMax</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNumber?decimalMin=1">decimalMin</a></div>

    <br/>
    <div>@NotBlank</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotBlank?username=用户123">必传，非空</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotBlank">不传</a></div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testNotBlank?username=%20">传入空格字符串(%20认为是空格)，抛异常</a>
    </div>

    <br/>
    <div>@NotEmpty</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotEmpty?name=用户123">必传，非空</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotEmpty?name=">不传</a></div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testNotEmpty?name=%20">传入空格字符串(%20认为是空格)，正常接收</a>
    </div>

    <br/>
    <div>@AssertTrue @AssertFalse</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testAssert?trueBoolean=true">trueBoolean</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testAssert?falseBoolean=false">falseBoolean</a>
    </div>

    <br/>
    <div>@Email</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testEmail?email=373045134@qq.com">合格的email</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testEmail?email=xxx.com">不合格的mail</a></div>

    <br/>
    <div>@Pattern</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPattern?testPattern=123">合法Pattern</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPattern?testPattern=xx">不合法Pattern</a></div>

    <br/>
    <div>@Length</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testLength?testLength=12345">合法Length</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testLength?testLength=%20%20%20%20%20">不合法Length(空占长度)</a>
    </div>

    <br/>
    <div>@Size</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testSize?testSize=12345">合法Size</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testSize?testSize=">不合法Size(空占长度)</a></div>

    <br/>
    <div>@Range</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testRange?testRange=4">合法Range</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testRange?testRange=6">不合法Range</a></div>

    <br/>
    <div>@Null</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNull?testNull=xx">不传参数, 校验成功</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNull?testNull=ss">传了参数，校验成功</a></div>

    <br/>
    <div>@NotNull</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotNull?testNotNull=xx">传递了参数，校验成功</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNotNull?testNotNull=">不传参数，校验失败</a>
    </div>

    <br/>
    <div>@Positive</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPositive?testPositive=2">传入大于0，校验成功</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPositive?testPositive=-2">传入小于0，校验失败</a>
    </div>

    <br/>
    <div>@PositiveOrZero</div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPositiveOrZero?testPositiveOrZero=2">传入大于0，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPositiveOrZero?testPositiveOrZero=0">传入等于0，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPositiveOrZero?testPositiveOrZero=-2">传入小于0，校验失败</a>
    </div>

    <br/>
    <div>@Negative</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNegative?testNegative=-2">传入小于0，校验成功</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testNegative?testNegative=2">传入大于0，校验失败</a>
    </div>

    <br/>
    <div>@NegativeOrZeroVao</div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testNegativeOrZero?testNegativeOrZero=-2">传入小于0，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testNegativeOrZero?testNegativeOrZero=0">传入等于0，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testNegativeOrZero?testNegativeOrZero=2">传入大于0，校验失败</a>
    </div>

    <br/>
    <div>@Future</div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testFuture?testFuture=2200-07-20">传入将来日期，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testFuture?testFuture=2024-07-20">传入过去日期，校验失败</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testFuture?testFuture=${requestScope.today}">传入today日期，校验失败</a>
    </div>

    <br/>
    <div>@FutureOrPresent</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testFutureOrPresent?testFutureOrPresent=2200-07-20">传入将来日期，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testFutureOrPresent?testFutureOrPresent=${requestScope.today}">传入today日期，校验成功</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testFutureOrPresent?testFutureOrPresent=2024-07-20">传入过去日期，校验失败</a>
    </div>

    <br/>
    <div>@Past</div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPast?testPast=2024-07-20">传入过去日期，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPast?testPast=2200-07-20">传入将来日期，校验失败</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPast?testPast=${requestScope.today}">传入today日期，校验失败</a>
    </div>

    <br/>
    <div>@PastOrPresent</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPastOrPresent?testPastOrPresent=2024-07-20">传入过去日期，校验成功</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/valid/get/testPastOrPresent?testPastOrPresent=${requestScope.today}">传入today日期，校验成功</a>
    </div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testPastOrPresent?testPastOrPresent=2200-07-20">传入将来日期，校验失败</a>
    </div>

    <br/>
    <div>@URL</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testUrl?testUrl=http://www.baidu.com">传入url，校验成功</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testUrl?testUrl=123.com">非url，校验失败</a></div>

    <br/>
    <div>参数别名</div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testAlias?name=呵呵">本名参数接收，校验成功</a></div>
    <div><a href="${pageContext.request.contextPath}/valid/get/testAlias?name_alias=哈哈">别名参数接收，校验成功</a></div>
</div>
<br/>
<div>
    <div>不推荐使用多个形参校验接收，冗余且繁琐，推荐使用实体类接收</div>
</div>
</body>
</html>