<%-- 
    Document   : tasks
    Created on : Oct 13, 2017, 1:53:43 PM
    Author     : nileshjayanandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>


<div class="row">
    <div class="col-md-12">
        <h1>Employees  
            <button class="btn btn-info pull-right" style="margin-top:1%" data-toggle="modal" data-target="#addModal"> 
                Add Employee</button></h1>
    </div>

</div>
<br>
<c:if test="${flag}">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Success!</strong> <c:out value="${message}"></c:out>.
        </div>
</c:if>
<br>
<table class="table table-hover table-striped table-condensed">
    <thead>
    <th>ID</th>
    <th>Employee Description</th>
    <th>Role</th>
    <th style="width:90px">Actions</th>
    
</thead>
<tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td> <c:out value="${employee.getId()}"></c:out> </td>
            <td> <c:out value="${employee.getName()}"></c:out> </td>
             <td>  <c:out value="${employee.getRole().getTitle()}"></c:out> </td>
                <td>  
                    <a  href="eview.htm?id=${employee.getId()}" 
                    class="btn btn-xs btn-default btn-block" > View </a>
            </td>
           
        </tr>
    </c:forEach>
</tbody>

</table>


<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add Employee</h4>
            </div>
            <form class="form-horizontal" action="employee.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="POST">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Employee Name</label>
                        <div class="col-md-8">
                            <input type="text" name="name" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Employee Role</label>
                        <div class="col-md-8">
                            <select type="text" name="role" class="form-control">
                                <option value="0" selected>No Role</option>
                                <c:forEach var="role" items="${roles}">
                                    <c:if test="${role.getEmployee() == null}">
                                        <option value="${role.getId()}"> <c:out value="${role.getTitle()}"></c:out> </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form> 
        </div>
    </div>
</div>


 

<%@include file="footer.jsp" %>