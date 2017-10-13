<%-- 
    Document   : roles
    Created on : Oct 13, 2017, 1:53:43 PM
    Author     : nileshjayanandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles</title>
        <link rel="stylesheet" href="https://bootswatch.com/united/bootstrap.css"/>
    </head>
    <body>
        <div class="container">
            
             <h1>Roles</h1>
             
             <table class="table table-hover table-striped">
                 <thead>
                    <th>ID</th>
                    <th>Role Name</th>
                 </thead>
                 <tbody>
                     <c:forEach var="role" items="${roles}">
                         <tr>
                             <td> <c:out value="${role.getId()}"></c:out> </td>
                              <td> <c:out value="${role.getTitle()}"></c:out> </td>
                         </tr>
                     </c:forEach>
                 </tbody>
                 
             </table>
        </div>  
       
    </body>
</html>
