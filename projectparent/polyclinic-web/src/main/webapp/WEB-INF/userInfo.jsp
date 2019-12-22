<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <fmt:setLocale scope="session" value="${sessionScope.locale}"/>
 <fmt:setBundle basename="messages"/>

 <!DOCTYPE html>
 <html lang="${param.lang}">
 <head>
     <meta charset="UTF-8">
     <title><fmt:message key="userInfo.page.title"/></title>
 </head>

 <body>

 <%@include file="include/header.jsp" %>
 <%@include file="include/menu.jsp" %>

<h3><fmt:message key="userInfo.page.header"/></h3>

 <ul>
     <li><fmt:message key="userInfo.page.username"/> - ${user.userName}</li>
     <li><fmt:message key="userInfo.page.lastlogin"/> - ${cookie['last_login'].getValue()}</li>
 </ul>

 <jsp:include page="include/footer.jsp"/>

 </body>
 </html>