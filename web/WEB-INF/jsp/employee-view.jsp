<%-- 
    Document   : roles
    Created on : Oct 13, 2017, 1:53:43 PM
    Author     : nileshjayanandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>


<div class="row">
    <div class="col-md-6">
         
         <h3   >Employee Information</h3>
         <hr>
            <div class="panel  ">
               
                <div class="panel-body">
                    <table class="table table-hover" style="font-size: 127%;">
                         <tr>
                            <td>EMPLOYEE ID</td>
                            <td><c:out value="${employee.getId()}"></c:out>  </td>
                        </tr>
                        <tr>
                            <td>NAME</td>
                            <td><c:out value="${employee.getName()}"></c:out>  </td>
                        </tr>
                         <tr>
                            <td>ROLE</td>
                            <td> <span class="label label-info"> <c:out value="${employee.getRole().getTitle()}"></c:out> </span></td>
                        </tr>
                         <tr>
                            <td>TASKS ASSIGNED</td>
                            <td> <c:out value="${employee.getTasks().size()}"></c:out></td>
                        </tr>
                    </table>
                </div>
            </div>


            <button class="btn btn-info " style="margin-top:1%" 
                    data-toggle="modal" data-target="#editModal"> EDIT</button>
            <button class="btn btn-default " style="margin-top:1%" 
                    data-toggle="modal" data-target="#changeRole"> Change Role</button>

            <button class="btn btn-success " style="margin-top:1%" 
                    data-toggle="modal" data-target="#addTask"> Add Task</button>
        </div>

    </div>
    <br>
    <div class="row">

        <div class="col-md-12">
            <h3>Task List</h3>
            <hr>
            <table class="table table-hover table-striped table-condensed">
                <thead>
                <th>ID</th>
                <th>Task Description</th>
                <th style="width:90px">Actions</th>
                </thead>
                <tbody>
                <c:forEach var="task" items="${employee.getTasks()}">
                    <tr>
                        <td> <c:out value="${task.getId()}"></c:out> </td>
                        <td> <c:out value="${task.getDescription()}"></c:out> </td>
                            <td> 
                                <button type="button" class="btn btn-xs btn-danger" 
                                        onclick="remove(${task.getId()})"> Remove </button>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

    </div>
</div>

<div class="modal fade" id="changeRole">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Change Employee Role</h4>
            </div>
            <form class="form-horizontal" action="eview.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="CHANGE_ROLE">
                    <input type="hidden" name="id" value="${employee.getId()}">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Select Role</label>
                        <div class="col-md-8">
                            <select type="text" name="role" class="form-control">
                                <option value="0" ${employee.getRole() == null? 'selected':''}>No Role</option>
                                <c:if test="${employee.getRole() != null}">
                                    <option value="${employee.getRole().getId()}" selected><c:out value="${employee.getRole().getTitle()}"></c:out></option>
                                </c:if>
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

<div class="modal fade" id="editModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Edit Employee</h4>
            </div>
            <form class="form-horizontal" action="eview.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="PATCH">

                    <input type="hidden" name="id" value="${employee.getId()}">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Employee Name</label>
                        <div class="col-md-8">
                            <input type="text" name="name" value="${employee.getName()}" class="form-control">
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

<div class="modal fade" id="addTask">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add Employee Task</h4>
            </div>
            <form class="form-horizontal" action="eview.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="ADD_TASK">
                    <input type="hidden" name="id" value="${employee.getId()}">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Select Task</label>
                        <div class="col-md-8">
                            <select type="text" name="task" class="form-control">
                                <option value="0"  >Select Task</option>

                                <c:forEach var="task" items="${tasks}">

                                    <option value="${task.getId()}"> <c:out value="${task.getDescription()}"></c:out> </option>

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

<div class="modal fade" id="taskDelete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Confirm Action</h4>
            </div>
            <form class="form-horizontal" action="eview.htm"  method="post">
                <div class="modal-body">
                    <p>Are you sure you want to remove this task from this employee?</p>
                    <input type="hidden" name="_method" value="REMOVE_TASK">

                    <input type="hidden" name="id" value="${employee.getId()}">
                    <input type="hidden" name="task" id="taskid">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Remove</button>
                </div>
            </form> 
        </div>
    </div>
</div>

<script>

    function remove(id) {

        $("#taskid").val(id);
        $("#taskDelete").modal("show");
    }

</script>                    
<%@include file="footer.jsp" %>