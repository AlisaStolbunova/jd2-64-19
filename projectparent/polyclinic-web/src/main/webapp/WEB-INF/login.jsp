<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
<title>Login page </title>
</head>
<body>
<jsp:include file="WEB-INF/include/header.jsp"/>
<%@ include file="WEB-INF/include/menu.jsp"%>

<c:if test="${not empty errorMessage}">
<div style =" color: red">${errorMessage}</div>
</c:if>

<form method ="post" action="${pageContext.request.contextPath}/login">
<table>
<tr>
<td><label for="userName">User name</label></td>
<td><input id="userName" type ="text" name="userName"></td>
</tr>
<tr>
<td><label for="password">Password</label></td>
<td><input id="password" type ="password" name="password"></td>
</tr>
<tr>
<td colspan="2"><input type = "submit"></td>

</tr>
<table>

<jsp:include page="WEB-INF/include/footer.jsp"/>
</body>
</html>