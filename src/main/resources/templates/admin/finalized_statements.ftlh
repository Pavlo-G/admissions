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
<#--                <td align="center">-->
<#--                    <form class="form-inline my-2 my-lg-0"-->
<#--                          action="/admin/finalize/${faculty_statement[0].id}" method="get">-->
<#--                        <button class="btn btn-danger" type="submit">Finalize statement</button>-->
<#--                    </form>-->
<#--                </td>-->
                <br>
                <table class="table table-striped table-bordered table-list">
                    <thead>
                    <tr>

                        <th style="width: 14.28%">Statement id</th>
                        <th style="width: 14.28%">Author username</th>
                        <th style="width: 14.28%">Number of Enrolled Candidates</th>
                        <th style="width: 14.28%">Finalize date and time</th>

                    </tr>
                    </thead>
                    <tbody>
                    <#list   all_statements as statement>
                        <tr>

                            <td style="width: 14.28%">${statement.getId()}</td>
                            <td style="width: 14.28%">${statement.getAuthor()}  </td>
                            <td style="width: 14.28%">${statement.getEnrolledCandidates()?size}</td>
                            <td style="width: 14.28%">${statement.getCreationDateTime()}</td>



                            <#--                                <td align="center">-->
                            <#--                                    <form class="form-inline my-2 my-lg-0"-->
                            <#--                                          action="/admin/requests_of_faculty/${faculty.getId()}" method="get">-->
                            <#--                                        <button class="btn btn-primary" type="submit">edit</button>-->
                            <#--                                    </form>-->
                            <#--                                </td>-->

                        </tr>

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