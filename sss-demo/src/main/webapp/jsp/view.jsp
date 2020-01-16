<%--
  Created by IntelliJ IDEA.
  User: wangjin
  Date: 2020/1/15
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/new.html">添加</a>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td>phone</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${resumeList}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.address}</td>
            <td>${l.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/delete?id=${l.id}">删除</a>
                <a href="${pageContext.request.contextPath}/premodify?id=${l.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
