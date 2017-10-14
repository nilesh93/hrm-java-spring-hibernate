<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <c:out value="${page}"></c:out></title>
        <link rel="stylesheet" href="https://bootswatch.com/flatly/bootstrap.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="index.htm" class="navbar-brand" href="javascript:void()">HRM</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">

 
                    <ul class="nav navbar-nav navbar-right">
                        <li class="${page == 'role' ? 'active' : ''}">
                             <a  href="roles.htm">Roles</a>
                        </li>
                         <li class="${page == 'task' ? 'active' : ''}">
                             <a  href="tasks.htm">Tasks</a>
                        </li>
                         <li class="${page == 'employee' ? 'active' : ''}">
                             <a  href="employee.htm">Employees</a>
                        </li>
                         
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">