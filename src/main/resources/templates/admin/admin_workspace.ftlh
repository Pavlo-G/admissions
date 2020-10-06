<head>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">

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
                        <div class="col col-xs-1">
                            <h3 class="panel-title">Faculties</h3>
                        </div>
                        <div class="col col-xs-1 text-center">
                            <form action="/admin/faculty/add" method="get">
                                <button type="submit" class="btn btn-sm btn-primary btn-create">Create New Faculty
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body h-100 row align-items-center" >
                    <table class="table table-striped table-bordered table-list">
                        <thead class="col-md-10 col-md-offset-1">
                        <tr>
                            <th style="width: 10%">Name</th>
                            <th style="width: 5%">New Requests</th>
                            <th style="width: 5%">Approved Requests</th>
                            <th style="width: 5%">Rejected Requests</th>
                            <th style="width: 5%">Budget Capacity</th>
                            <th style="width: 5%">Total Capacity</th>
                            <th style="width: 13%">Work With Requests</th>
                            <th style="width: 13%">Block/Unblock Registration</th>
                            <th style="width: 13%">Edit Faculty</th>
                            <th style="width: 13%">Delete Faculty</th>
                            <th style="width: 13%">Statement</th>

                        </tr>
                        </thead>
                        <tbody>

                        <#list faculties_list as faculty>
                            <tr>


                                <td >${faculty.getName()}</td>
                                <td >${faculty.numberOfRequestsNew()}</td>
                                <td >${faculty.numberOfRequestsApproved()}</td>
                                <td >${faculty.numberOfRequestsRejected()}</td>
                                <td >${faculty.budgetCapacity}</td>
                                <td >${faculty.totalCapacity}</td>
                                <td>
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">
                                        <button class="btn btn-primary btn-xs" type="submit">Requests</button>
                                    </form>
                                </td>
                                <td >
                                    <#if faculty.admissionOpen>
                                        <form class="form-inline my-2 my-lg-0"
                                              action="/admin/block_reg/${faculty.getId()}" method="get">
                                            <button class="btn btn-warning btn-xs" type="submit">Block</button>
                                        </form>
                                    <#else>
                                        <form class="form-inline my-2 my-lg-0"
                                              action="/admin/unblock_reg/${faculty.getId()}" method="get">
                                            <button class="btn btn-success btn-xs" type="submit">Unblock</button>
                                        </form>
                                    </#if>
                                </td>

                                <td >
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/faculty/edit/${faculty.getId()}" method="get">
                                        <button class="btn btn-primary btn-xs" type="submit">Edit</button>
                                    </form>
                                </td>
                                <td class="col-lg-11 col-centered">
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/faculties/delete/${faculty.getId()}" method="post">
                                        <button class="btn btn-danger btn-xs" type="submit">Delete</button>
                                    </form>
                                </td>
                                <td class="col-lg-11 col-centered">
                                    <form class="form-inline my-2 my-lg-0"
                                          action="/admin/statement/faculty/${faculty.id}" method="get">
                                        <button class="btn btn-primary btn-xs" type="submit">Statement</button>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <br>
                </div>
            </div>

        </div>
    </div>
</div>


</body>