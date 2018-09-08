<%--
  Created by IntelliJ IDEA.
  User: Mikro
  Date: 2018/8/23
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查询所有账户</h1>

<c:forEach items="${list}" var="account">
    ${account.id}
    ${account.name}
    ${account.money}

</c:forEach>
</body>
</html>
