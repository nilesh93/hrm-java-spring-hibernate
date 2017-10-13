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
        
        <div class="modal" id="addModal">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">Add Role</h4>
                </div>
                <div class="modal-body">
                  <form class="form-horizontal">
                      </form> 
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save changes</button>
                </div>
              </div>
            </div>
          </div>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
    </body>
</html>
