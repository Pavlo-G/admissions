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
                        <div class="col col-xs-6">
                            <h3 class="panel-title">All candidates</h3>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>

                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Status</th>
                            <#--                            <th>Action</th>-->
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list all_candidates as candidate>
                            <tr>

                                <td>${candidate.getId()}</td>
                                <td>${candidate.getUsername()}</td>
                                <td>${candidate.candidateProfile.email}</td>
                                <td>${candidate.getRole().name()}</td>
                                <td>${candidate.getCandidateStatus().name()}</td>
                                <#--                                <td>-->
                                <#--                                    <form-->
                                <#--                                            action="/admin/candidate/${candidate.getId()}" method="get">-->
                                <#--                                        <button class="btn btn-primary" type="submit">Check request</button>-->
                                <#--                                    </form>-->
                                <#--                                </td>-->

                                <td align="center">
                                    <form action="/admin/candidate/${candidate.getId()}" method="get">
                                        <button class="btn btn-primary" type="submit"> Edit</button>
                                    </form>

                                </td>

                                <td align="center">
                                    <form action="/admin/candidate/delete/${candidate.getId()}" method="post">
                                        <button class="btn btn-danger" type="submit"> Delete</button>
                                    </form>

                                </td>
                            </tr>
                        <#else >
                            <h2>No Candidates Available</h2>
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