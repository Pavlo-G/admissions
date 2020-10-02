
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admission board app candidates </title>
    <#include "fragments/bootsrap-links.ftl"/>
</head>
<body>
<#include "fragments/nav-bar.ftl" />
<br>
<h4>Registered Candidates</h4>
<hr>
<#list all_candidates as candidate>
<div class="border-card">
    <div class="card-type-icon with-border">${candidate.getId()}</div>
    <div class="content-wrapper">
        <div class="label-group fixed">
            <p class="title">Name</p>
            <p class="caption">${candidate.getUsername()}</p>
        </div>
        <div class="min-gap"></div>
        <div class="label-group">
            <p class="title">Email</p>
            <p class="caption">${candidate.getEmail()}</p>
        </div>
        <div class="min-gap"></div>
        <div class="label-group">
            <p class="title">Role</p>
            <p class="caption">${candidate.getRole().name()}</p>
        </div>
        <div class="min-gap"></div>
        <div class="label-group">
            <p class="title">Status</p>
            <p class="caption">${candidate.getStatus().name()}</p>
        </div>
    </div>

    <div>
        <form method="get" action="/edit_candidate">
            <input type="hidden" name="faculty_id" value="${candidate.getId()}">
            <button type="submit" class="btn btn-primary">Edit candidate</button>
        </form>
    </div>
    <div>
        <form method="get" action="/block_candidate">
            <input type="hidden" name="faculty_id" value="${candidate.getId()}">
            <button type="submit" class="btn btn-primary">Block candidate</button>
        </form>
    </div>

</div>
</#list>

</body>
</html>
