<head>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
    <title>Request Approval form</title>
</head>


<body>
<#include "../fragments/nav-bar-admin.ftlh" />
<br>

<div class="container">
    <div class="row">
        <h2 class="text-danger"><@spring.message "admin.requests_of_faculty.to_the_faculty"/> ${request.faculty.getNameEn()} </h2>


        <table class="table table-bordered success">
            <thead>
            <tr>
                <th><@spring.message "profile.edit.first_name"/></th>
                <td>${request.candidate.candidateProfile.firstName}</td>
            </tr>
            <tr>
                <th><@spring.message "profile.edit.last_name"/></th>
                <td>${request.candidate.candidateProfile.lastName}</td>
            </tr>
            <tr>
                <th ><@spring.message "profile.edit.email"/></th>
                <td>${request.candidate.candidateProfile.email}</td>
            </tr>
            <tr>
                <th ><@spring.message "profile.edit.address"/></th>
                <td>${request.candidate.candidateProfile.address}</td>
            </tr>

            <tr>
                <th ><@spring.message "profile.edit.city"/></th>
                <td>${request.candidate.candidateProfile.city}</td>
            </tr>
            <tr>
                <th ><@spring.message "profile.edit.region"/></th>
                <td>${request.candidate.candidateProfile.region}</td>
            </tr>
            <tr>
                <th ><@spring.message "profile.edit.school"/></th>
                <td>${request.candidate.candidateProfile.school}</td>
            </tr>
            <tr>
                <th ><@spring.message "profile.edit.phoneNumber"/></th>
                <td>${request.candidate.candidateProfile.phoneNumber}</td>
            </tr>

            <tr>
                <th ><@spring.message "candidate.admission.requests.grade.for"/>  ${request.faculty.getRequiredSubject1En()} </th>
                <td>${request.getRequiredSubject1Grade()}</td>
            </tr>
            <tr>
                <th ><@spring.message "candidate.admission.requests.grade.for"/> ${request.faculty.getRequiredSubject2En()}</th>
                <td>${request.getRequiredSubject2Grade()}</td>
            </tr>
            <tr>
                <th ><@spring.message "candidate.admission.requests.grade.for"/> ${request.faculty.getRequiredSubject3En()}</th>
                <td>${request.getRequiredSubject3Grade()}</td>
            </tr>

            </thead>

        </table>

        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">

                <form action="/admin/request_update" method="POST">
                    <input type="hidden" id="id" name="id" value="${request.getId()}">
                    <input type="hidden" id="facultyId" name="facultyId" value="${request.faculty.id}">
                    <input type="hidden" id="admissionRequestStatus" name="admissionRequestStatus" value="APPROVED">
                    <button class="btn btn-primary mr-2" type="submit"><@spring.message "admin.check_request.approve"/></button>
                </form>
                <form action="/admin/request_update" method="POST">
                    <input type="hidden" id="id" name="id" value="${request.getId()}">
                    <input type="hidden" id="facultyId" name="facultyId" value="${request.faculty.id}">
                    <input type="hidden" id="admissionRequestStatus" name="admissionRequestStatus" value="REJECTED">
                    <button class="btn btn-danger mr-2" type="submit"><@spring.message "admin.check_request.reject"/></button>
                </form>
                <form action="/admin/requests_of_faculty/${request.faculty.getId()}" method="get">
                    <button class="btn btn-warning mr-2" type="submit"> <@spring.message "admin.check_request.back"/></button>
                </form>

            </div>
        </div>
    </div>
</div>
</body>