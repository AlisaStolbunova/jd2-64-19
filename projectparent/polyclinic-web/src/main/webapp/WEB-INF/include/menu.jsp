<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

 <div style="padding: 5px;">

     <a href="${pageContext.request.contextPath}/home"><fmt:message key="menu.page.home"/></a>
     |
     <a href="${pageContext.request.contextPath}/doctorsList"><fmt:message key="menu.page.dl"/></a>
     |
     <a href="${pageContext.request.contextPath}/userInfo"><fmt:message key="menu.page.akkInfo"/></a>
     |
     <a href="${pageContext.request.contextPath}/login"><fmt:message key="menu.page.login"/></a>

 </div>