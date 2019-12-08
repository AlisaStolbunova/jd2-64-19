<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>
     <title>Create Doctor</title>
 </head>
 <body>

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
      <label> PhoneNumber: <input type="number" name="phoneNumber"/> </label>
      <br>
     <input type="submit">
 </form>
 </body>
 </html>