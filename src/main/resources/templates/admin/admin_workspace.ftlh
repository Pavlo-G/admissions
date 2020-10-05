<head>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
    <#--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
    <#--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>-->
    <#--    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
</head>


<body>
<#include "../fragments/nav-bar-admin.ftlh" />
<br>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet'
      type='text/css'>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Faculties</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <form action="/admin/faculty/add" method="get">
                                <button type="submit" class="btn btn-sm btn-primary btn-create">Create New</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>

                            <th>ID</th>
                            <th>Name</th>
                            <th>New Requests</th>
                            <th>Approved Requests</th>
                            <th>Rejected Requests</th>
                            <th>Total</th>
                            <th>Work With Requests</th>
                            <th>Edit Faculty</th>
                            <th>Delete Faculty</th>

                        </tr>
                        </thead>
                        <tbody>

                        <#list faculties_list as faculty>
                            <tr>

                                <td>${faculty.getId()}</td>
                                <td>${faculty.getName()}</td>
                                <td>${faculty.numberOfRequestsNew()}</td>
                                <td>${faculty.numberOfRequestsApproved()}</td>
                                <td>${faculty.numberOfRequestsRejected()}</td>
                                <td>${faculty.numberOfRequests()}</td>
                                <td>
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">
                                        <button class="btn btn-primary" type="submit">Requests</button>
                                    </form>
                                </td>

                                <td align="center">
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/faculty/edit/${faculty.getId()}" method="get">
                                        <button class="btn btn-primary" type="submit">Edit</button>
                                    </form>
                                </td>
                                <td align="center">
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/faculties/delete/${faculty.getId()}" method="post">
                                        <button class="btn btn-danger" type="submit">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>

                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col col-xs-4">Page 1 of 5
                        </div>
                        <div class="col col-xs-8">
                            <ul class="pagination hidden-xs pull-right">
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                            </ul>
                            <ul class="pagination visible-xs pull-right">
                                <li><a href="#">«</a></li>
                                <li><a href="#">»</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


</body>