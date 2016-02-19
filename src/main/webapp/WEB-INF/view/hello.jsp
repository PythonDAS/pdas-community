<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 2016. 2. 14.
  Time: 오후 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value="/resources/bower/bootstrap/dist/css/bootstrap.min.css" /> ">
</head>
<body>
<div class="container">
    <h1>인사말: ${greeting}</h1>
    <form action="/member" method="post">
        이메일: <input type="text" name="email"/>
        이름: <input type="text" name="name"/>
        암호: <input type="text" name="pass"/>
        암호확인: <input type="text" name="confirmPass"/>
        <input type="submit" value="확인">
    </form>
</div>
</body>
</html>
