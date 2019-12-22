<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <fmt:setLocale scope="session" value="${sessionScope.locale}"/>
 <fmt:setBundle basename="messages"/>

 <!DOCTYPE html>
 <html>
 <head>
     <meta charset="UTF-8">
     <title><fmt:message key="login.page.title"/></title>
 </head>
 <body>
 <%@include file="include/header.jsp"%>
 <%@include file="include/menu.jsp" %>

 <h3><fmt:message key="login.page.header"/></h3>
 <p style="color: red;">${errorString}</p>


 <form method="POST" action="${pageContext.request.contextPath}/login">
     <table border="0">
         <tr>
             <td><fmt:message key="login.page.user.name"/></td>
             <td><input type="text" name="userName" value="${user.userName}"/></td>
         </tr>
         <tr>
             <td><fmt:message key="login.page.user.password"/></td>
             <td><input type="password" name="password" value=""/></td>
         </tr>
         <tr>
             <td><fmt:message key="login.page.user.remember"/></td>
             <td><input type="checkbox" name="rememberMe" value="Y"/></td>
         </tr>
         <tr>
             <td colspan="2">
                 <input type="submit" value="<fmt:message key="login.page.submit"/>"/>
                 <a href="${pageContext.request.contextPath}/">Cancel</a>
             </td>
         </tr>
     </table>
 </form>

 <p style="color:blue;">Admin User: user1 password: admin123</p>
 <p style="color:blue;">Simple User: user2 password: 12345</p>

 <jsp:include page="include/footer.jsp"/>
 </body>
 </html>