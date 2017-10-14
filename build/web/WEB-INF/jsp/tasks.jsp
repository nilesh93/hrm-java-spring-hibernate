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
        <h1>Tasks  
            <button class="btn btn-info pull-right" style="margin-top:1%" data-toggle="modal" data-target="#addModal"> 
                Add Task</button></h1>
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
    <th>Task Description</th>
    <th style="width:90px">Actions</th>
</thead>
<tbody>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td> <c:out value="${task.getId()}"></c:out> </td>
            <td> <c:out value="${task.getDescription()}"></c:out> </td>
                <td>  
                    <button type="button" class="btn btn-xs btn-default btn-block" onclick="edit(${task.getId()}, '${task.getDescription()}')"> EDIT </button>
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
                <h4 class="modal-title">Add Task</h4>
            </div>
            <form class="form-horizontal" action="task.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="POST">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Description</label>
                        <div class="col-md-8">
                            <textarea type="text" name="desc" class="form-control"></textarea>
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
                <h4 class="modal-title">Edit Task</h4>
            </div>
            <form class="form-horizontal" action="task.htm"  method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="PUT">
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label">Task ID</label>
                        <div class="col-md-8">
                            <input type="text" name="id" id="taskid" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-md-4 control-label"> Description</label>
                        <div class="col-md-8">
                            <textarea type="text" name="desc" id="desc" class="form-control"></textarea>
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





<script>

    function edit(id, desc) {
      
        $("#desc").val(desc);
        $("#taskid").val(id);
        $("#editModal").modal("show");
    }

</script>

<%@include file="footer.jsp" %>