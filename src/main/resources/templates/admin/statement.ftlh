<head>

    <link rel="stylesheet" href="css/stylesheet.css">

    <#include "../fragments/bootsrap-links.ftl"/>
</head>


<body>
<#include "../fragments/nav-bar-admin.ftlh" />
<br>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel-body">
                <#if faculty_statement?size!=0>
                <td align="center">

                    <form class="form-inline my-2 my-lg-0"
                          action="/admin/statement/finalize" method="Post">
                        <input type ="hidden"name="id" id="id" value="${faculty_id}">
                        <button class="btn btn-danger" type="submit">Finalize statement</button>
                    </form>

                </td>
                <br>
                <table class="table table-striped table-bordered table-list">
                    <thead>
                    <tr>

                        <th style="width: 14.28%">Faculty Name</th>
                        <th style="width: 14.28%">Candidate Name</th>
                        <th style="width: 14.28%">Candidate Email</th>
                        <th style="width: 14.28%">Candidate Contact Number</th>
                        <th style="width: 14.28%">Candidate Grade</th>
                        <th style="width: 14.28%">Budget/Contract</th>

                    </tr>
                    </thead>
                    <tbody>
                    </#if>
                    <#list   faculty_statement as statement>
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
                                    Budget
                                <#else>
                                    Contract
                                </#if>

                            </td>


                            <#--                                <td align="center">-->
                            <#--                                    <form class="form-inline my-2 my-lg-0"-->
                            <#--                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">-->
                            <#--                                        <button class="btn btn-primary" type="submit">edit</button>-->
                            <#--                                    </form>-->
                            <#--                                </td>-->

                        </tr>
                        <#else >
                        <h2>No active requests to prepare the statement</h2>
                    </#list>
                    </tbody>

                </table>




            </div>

        </div>
<#--        <#else >-->
<#--        <h2>Choose Faculty To Show Statement</h2>-->
<#--        </#if>-->

    </div>
</div>


</body>