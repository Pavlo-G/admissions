<head>

    <link rel="stylesheet" href="css/stylesheet.css">

    <#include "fragments/bootsrap-links.ftl"/>
</head>


<body>
<#include "/fragments/nav-bar.ftl" />
<br>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet'
      type='text/css'>

<div class="container">
    <div class="row">
<#--        <div class="col-md-10 col-md-offset-1">-->

<#--            <div class="panel panel-default panel-table">-->
<#--                <div class="panel-heading">-->
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Faculties</h3>
                        </div>

                    </div>
<#--                </div>-->
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>


                            <th>Name</th>
                            <th>Description</th>
                            <th>Budget Capacity</th>
                            <th>Total Capacity</th>
                            <th>Submit request</th>

                        </tr>
                        </thead>
                        <tbody>

                        <#list all_faculties as faculty>
                            <tr>
                                <td>${faculty.getName()}</td>
                                <td>${faculty.getDescription()}</td>
                                <td>${faculty.getBudgetCapacity()}</td>
                                <td>${faculty.getTotalCapacity()}</td>
                                <td>
                                    <#if isAdmin>
                                    <#else >
                                        <#if faculty.admissionOpen>
                                        <form method="get" action="/candidate/submit_request">
                                            <input type="hidden" name="faculty_id" value="${faculty.getId()}">
                                            <button type="submit" class="btn btn-primary btn-sm">Send admission request
                                            </button>
                                        </form>
                                        </#if>
                                    </#if>

                                </td>


                                <#--                                <td align="center">-->
                                <#--                                    <form class="form-inline my-2 my-lg-0"-->
                                <#--                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">-->
                                <#--                                        <button class="btn btn-primary" type="submit">edit</button>-->
                                <#--                                    </form>-->
                                <#--                                </td>-->
                                <#--                                <td align="center">-->
                                <#--                                    <form class="form-inline my-2 my-lg-0"-->
                                <#--                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">-->
                                <#--                                        <button class="btn btn-danger" type="submit">delete</button>-->
                                <#--                                    </form>-->
                                <#--                                </td>-->
                            </tr>
                        </#list>
                        </tbody>
                    </table>

                </div>

            </div>

        </div>
    </div>
</div>


</body>