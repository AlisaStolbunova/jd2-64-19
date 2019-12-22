<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

 <!DOCTYPE html>


<html>
<body>

 <%@include file="WEB-INF/include/menu.jsp" %>
<h2>Clinic</h2>
 <jsp:include page="WEB-INF/include/footer.jsp"/>
</body>
</html>
