<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>

  <fmt:setLocale scope="session" value="${sessionScope.locale}"/>
  <fmt:setBundle basename="messages"/>

 <html>
 <head>
     <title><fmt:message key="doctors.page.title"/></title>
 </head>
 <body>

  <%@include file="include/header.jsp" %>
  <%@include file="include/menu.jsp" %>

  <h3><fmt:message key="doctors.page.header"/></h3>

 <table>
     <tr>
         <td>Id</td>
         <td>Name</td>
         <td>Post</td>
         <td>Department</td>
         <td>Section</td>
         <td>Office</td>
         <td>PhoneNumber</td>
     </tr>
     <c:forEach items="${doctorsList}" var="doctor">
         <tr>
             <td><c:out value="${doctor.id}"/></td>
             <td><c:out value="${doctor.name}"/></td>
             <td><c:out value="${doctor.post}"/></td>
             <td><c:out value="${doctor.department}"/></td>
             <td><c:out value="${doctor.section}"/></td>
             <td><c:out value="${doctor.office}"/></td>
             <td><c:out value="${doctor.phoneNumber}"/></td>
         </tr>
     </c:forEach>
 </table>

 <a:auth path="">
      <a href="${pageContext.request.contextPath}/doctorCreate">
      <fmt:message key="doctors.page.create"/></a>
 </a:auth>


  <jsp:include page="include/footer.jsp"/>
 </body>
 </html>