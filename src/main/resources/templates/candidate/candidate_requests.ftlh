

<html lang="en">
<head>
    <meta charset="UTF-8">
    <#include "../fragments/bootsrap-links.ftl"/>
</head>
<body translate="no">
<#include "../fragments/nav-bar.ftl"/>
<br>
<h4>Submitted admission requests</h4>
<hr>

<#list requests_list as request>
    <div class="border-card">
        <div class="card-type-icon with-border">${request.getId()}</div>

        <div class="content-wrapper">
            <div class="label-group fixed">
                <p class="title">From User</p>
                <p class="caption">${username}  </p>
            </div>
            <div class="min-gap"></div>

            <div class="label-group fixed">
                <p class="title">To faculty</p>
                <p class="caption">${request.faculty.getName()}</p>
            </div>

            <div class="min-gap"></div>
            <div class="label-group">
                <p class="title">Status</p>
                <p class="caption">${request.status}</p>
            </div>
        </div>
        <div>
            <form method="post" action="/candidate/delete_request/${request.getId()}">
                <button type="submit" class="btn btn-primary">Delete request</button>
            </form>
        </div>
    </div>
<#else >
    <h4>No active requests </h4>
</#list>

</body>
</html>
