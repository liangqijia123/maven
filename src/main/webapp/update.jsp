<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/9
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">

    <form action="/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        姓名:<input type="text" name="name" value="${user.name}"><br>
        性别:<input type="text" name="sex"value="${user.sex}"><br>
        年龄:<input type="text" name="age"value="${user.age}"><br>
        <input type="submit" value="提交">
    </form>

</div>
</body>
</html>
