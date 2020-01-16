<%--
  Created by IntelliJ IDEA.
  User: wangjin
  Date: 2020/1/16
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改</title>
</head>
<body>
<form id="update" action="http://localhost:8080/update" method="post">
    <div>
        <jsp:useBean id="resume" scope="request" type="com.jin.demo.sss.pojo.Resume"/>
        <p>id<input type="text" id="id" name="id" value="${resume.id}" readonly="readonly"/></p>
        <p>姓名<input type="text" id="name" name="name" value="${resume.name}"/></p>
        <p>地址<input type="text" id="address" name="address" value="${resume.address}"/></p>
        <p>手机<input type="text" id="phone" name="phone" value="${resume.phone}"/></p>
        <input type="submit" value="提交">

    </div>
</form>
</body>
</html>
