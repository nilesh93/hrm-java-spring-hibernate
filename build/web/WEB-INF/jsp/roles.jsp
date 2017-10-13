<%-- 
    Document   : roles
    Created on : Oct 13, 2017, 1:53:43 PM
    Author     : nileshjayanandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>


<div class="row">
    <div class="col-md-8">
        <h1>Roles</h1>
    </div>
    <div class="col-md-4">
        <button class="btn btn-default"  data-toggle="modal" data-target="#addModal"> Add Role</button>
    </div>
</div>
<br>
<c:if test="${flag}"></c:if>
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Success!</strong> <c:out value="${message}"></c:out>.
    </div>
    <br>
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


<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add Role</h4>
            </div>
            <form class="form-horizontal" action="role.htm"  method="post">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="" class="col-md-4 control">Role Name</label>
                        <div class="col-md-8">
                            <input type="text" name="title" class="form-control">
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
                <h4 class="modal-title">Edit Role</h4>
            </div>
            <form class="form-horizontal" action="role.htm"  method="put">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="" class="col-md-4 control">ID</label>
                        <div class="col-md-8">
                            <input type="text" name="id" id="roleid" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-md-4 control">Role Name</label>
                        <div class="col-md-8">
                            <input type="text" name="title" id="rolename" class="form-control">
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

    function edit(id, name) {
        $("#rolename").val(name);
        $("#roleid").val(id);
        $("#editModal").modal("show");
    }

</script>

<%@include file="footer.jsp" %>