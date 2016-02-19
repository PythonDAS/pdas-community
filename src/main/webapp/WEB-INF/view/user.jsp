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
    <h1>${count}</h1>
    <h1>${userList}</h1>
    <h1>${userList.get(1)}</h1>
    <h1>${userList.get(1).name}</h1>
    <h1>${user}</h1>
    <h1>${user.pass}</h1>
    </form>
</div>
</body>
</html>
