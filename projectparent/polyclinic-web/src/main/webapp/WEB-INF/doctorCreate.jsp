<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <fmt:setLocale scope="session" value="${sessionScope.locale}"/>
  <fmt:setBundle basename="messages"/>

 <html>
 <head>
     <title><fmt:message key="doctorCreate.page.title"/></title>
 </head>
 <body>

   <%@include file="include/header.jsp" %>
   <%@include file="include/menu.jsp" %>

 <form method="post" action="${pageContext.request.contextPath}/doctorCreate">
     <label> Name: <input type="text" name="name"/> </label>
     <br>
     <label> Post: <input type="text" name="post"/> </label>
     <br>
     <label> Department: <input type="text" name="department"/> </label>
      <br>
      <label> Section: <input type="number" name="section"/> </label>
      <br>
      <label> Office: <input type="number" name="office"/> </label>
      <br>
      <label> PhoneNumber: <input type="text" name="phoneNumber"/> </label>
      <br>
     <input type="submit">
 </form>

   <jsp:include page="include/footer.jsp"/>
 </body>
 </html>