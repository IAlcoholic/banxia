<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p th:if="${parent.error}">
    用户名或密码错
</p>
<p th:if="${param.logout}">
    您已注销成功
</p>
<form th:action="@{/login}" method="post">
    <div><label> 用户名 : <input type="text" name="username"/> </label></div>
    <div><label> 密  码 : <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="登录"/></div>
</form>
</body>
</html>