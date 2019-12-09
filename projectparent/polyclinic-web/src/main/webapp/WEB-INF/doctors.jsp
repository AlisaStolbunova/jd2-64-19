
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <head>
     <title>Doctors List</title>
 </head>
 <body>

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
 </body>
 </html>