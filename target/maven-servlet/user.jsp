<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/9
  Time: 12:47
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
<div>
    <table border="1" align="center" width="50%" >
        <a href="update.jsp">新增</a>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${ulist}">
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.sex}</th>
            <th>${user.age}</th>
            <th><a href="deleteById?id=${user.id}">删除</a> |<a href="findById?id=${user.id}">更新</a> </th>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
