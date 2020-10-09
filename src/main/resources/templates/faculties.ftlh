<#import "fragments/pager.ftl" as pager/>
<#import "fragments/items-per-page.ftl" as items_per_page/>
<head>

    <link rel="stylesheet" href="css/stylesheet.css">

    <#include "fragments/bootsrap-links.ftl"/>
</head>


<body>
<#include "fragments/nav-bar.ftl" />
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
            <@items_per_page.items url page/>
            <table class="table table-bordered">
                <thead>
                <tr>


                    <th>
                        Name
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=name,ASC">&#8593</a>
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=name,DESC">&#8595</a>
                    </th>
                    <th>Description</th>
                    <th>Budget Capacity
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=budgetCapacity,ASC">&#8593</a>
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=budgetCapacity,DESC">&#8595</a>
                    </th>
                    <th>Total Capacity
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=totalCapacity,ASC">&#8593</a>
                        <a href="${springMacroRequestContext.requestUri}?page=${page.getNumber()}&size=${page.size}&sort=totalCapacity,DESC">&#8595</a>
                    </th>
                    <th>Submit request</th>

                </tr>
                </thead>
                <tbody>

                <#list page.content as faculty>
                    <tr>
                        <td>${faculty.getName()}</td>
                        <td>${faculty.getDescription()}</td>
                        <td>${faculty.getBudgetCapacity()}</td>
                        <td>${faculty.getTotalCapacity()}</td>
                        <td>
                            <#if isAdmin>
                            <#else >
                                <#if faculty.admissionOpen>
                                    <form method="Get" action="/candidate/submit_request_form">
                                        <input type="hidden" name="id" value="${faculty.id}">
                                        <input type="hidden" name="name" value="${faculty.name}">
                                        <input type="hidden" name="requiredSubject1"
                                               value="${faculty.requiredSubject1}">
                                        <input type="hidden" name="requiredSubject2"
                                               value="${faculty.requiredSubject2}">
                                        <input type="hidden" name="requiredSubject3"
                                               value="${faculty.requiredSubject3}">
                                        <input type="hidden" name="admissionOpen"
                                               value="${faculty.admissionOpen?string}">
                                        <button type="submit" class="btn btn-primary btn-sm">Send admission request
                                        </button>
                                    </form>
                                </#if>
                            </#if>

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