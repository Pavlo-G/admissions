<head>
    <#import "../fragments/pager.ftl" as pager/>
    <#import "../fragments/items-per-page.ftl" as items_per_page/>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
    <#--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
    <#--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>-->
    <#--    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
</head>


<body>
<#include "../fragments/nav-bar.ftl" />
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
                            <h2 class="text-danger">Admission Requests </h2>
                        </div>
                        <#--                        <div class="col col-xs-6 text-right">-->
                        <#--                            <button type="button" class="btn btn-sm btn-primary btn-create">Create New</button>-->
                        <#--                        </div>-->
                    </div>
                </div>
                <div class="panel-body">
                    <@items_per_page.items url page/>
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>

                            <th>ID</th>
                            <th>From Candidate</th>
                            <th>To the Faculty</th>
                            <th>Status</th>
                            <th>Creation date and time</th>


                            <th align="center">Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.content as request>
                            <tr>

                                <td>${request.getId()}</td>
                                <td>${request.candidate.getUsername()}</td>
                                <td>${request.faculty.getName()}</td>
                                <td>${request.status.name()}</td>
                                <td>
                                    ${request.getCreationDateTime()}
                                </td>

                                <td align="center">
                                    <form
                                            action="/candidate/delete_request/${request.getId()}" method="post">
                                        <button class="btn btn-primary" type="submit">Delete request</button>
                                    </form>

                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager.pager url page/>
                </div>

            </div>

        </div>
    </div>
</div>


</body>