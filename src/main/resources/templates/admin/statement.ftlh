<head>

    <link rel="stylesheet" href="css/stylesheet.css">

    <#include "../fragments/bootsrap-links.ftl"/>
</head>


<body>
<#include "/fragments/nav-bar-admin.ftlh" />
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

                    </div>
                </div>
                <#list statementList as statementFaculty>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-list">
                            <thead>
                            <tr>

                                <th style="width: 14.28%">Faculty Name</th>
                                <th style="width: 14.28%">Candidate Name</th>
                                <th style="width: 14.28%">Candidate Email</th>
                                <th style="width: 14.28%">Candidate Contact Number</th>
                                <th style="width: 14.28%">Candidate Grade</th>
                                <th style="width: 14.28%">Budget/Contract</th>
                                <th style="width: 14.28%">Send Email</th>

                            </tr>
                            </thead>
                            <tbody>

                            <#list statementFaculty as statement>
                                <tr>

                                    <td style="width: 14.28%">${statement.faculty.getName()}</td>
                                    <td style="width: 14.28%">${statement.candidate.candidateProfile.firstName} ${statement.candidate.candidateProfile.lastName} </td>
                                    <td style="width: 14.28%">${statement.candidate.candidateProfile.email}</td>
                                    <td style="width: 14.28%">${statement.candidate.candidateProfile.phoneNumber}</td>
                                    <td style="width: 14.28%">${statement.getSumOfGrades()}</td>
                                    <td style="width: 14.28%">
                                        <#assign index=statement_index
                                        capacity =statement.faculty.getBudgetCapacity()
                                        />
                                        <#if ( index lt  capacity) >
                                            Budget(${index})
                                        <#else>
                                            Contract(${index})
                                        </#if>

                                    </td>

                                    <td style="width: 14.28%">
                                        <form method="get" action="/candidate/submit_request">
                                            <input type="hidden" name="faculty_id" value="">
                                            <button type="submit" class="btn btn-primary btn-xs">Email</button>
                                        </form>
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
                </#list>
            </div>

        </div>
    </div>
</div>


</body>