
<head>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
    <title>Candidate Profile</title>
</head>


<body>
<#include "../fragments/nav-bar.ftl" />
<br>

<div class="container">
    <div class="row">
        <h2 class="text-danger"><@spring.message "navbar.my_profile"/></h2>
        <form class="form-inline ml-auto my-2 my-lg-0"
                action="/api/candidate/edit/${candidate.getId()}" method="get">
            <button class="btn btn-primary " type="submit"><@spring.message "profile.edit.edit_profile"/></button>
        </form>

        <table class="table table-bordered success">
            <thead>
            <tr>
                <th><@spring.message "profile.edit.username"/></th>
                <td>${candidate.username}</td>
            </tr>
            <tr>
                <th class="info"><@spring.message "profile.edit.email"/></th>
                <td>${candidate.candidateProfile.email}</td>
            </tr>
            <tr>
                <th><@spring.message "profile.edit.first_name"/></th>
                <td>${candidate.candidateProfile.firstName}</td>
            </tr>
            <tr>
                <th class="info"><@spring.message "profile.edit.last_name"/></th>
                <td>${candidate.candidateProfile.lastName}</td>
            </tr>

            <tr>
                <th class="info"><@spring.message "profile.edit.address"/></th>
                <td>${candidate.candidateProfile.address}</td>
            </tr>
            <tr>
                <th class="info"><@spring.message "profile.edit.city"/></th>
                <td>${candidate.candidateProfile.city}</td>
            </tr>

            <tr>
                <th class="info"><@spring.message "profile.edit.region"/></th>
                <td>${candidate.candidateProfile.region}</td>
            </tr>
            <tr>
                <th class="info"><@spring.message "profile.edit.region"/></th>
                <td>${candidate.candidateProfile.school}</td>
            </tr>
            <tr>
                <th class="info"><@spring.message "profile.edit.phoneNumber"/></th>
                <td>${candidate.candidateProfile.phoneNumber}</td>
            </tr>

            </thead>

        </table>
    </div>
</div>
</body>