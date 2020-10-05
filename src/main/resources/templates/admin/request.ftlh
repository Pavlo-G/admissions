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
        <h2 class="text-danger">Request to the ${request.faculty.getName()} </h2>


        <table class="table table-bordered success">
            <thead>
            <tr>
                <th>First Name</th>
                <td>${request.candidate.candidateProfile.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${request.candidate.candidateProfile.lastName}</td>
            </tr>
            <tr>
                <th >Email</th>
                <td>${request.candidate.candidateProfile.email}</td>
            </tr>
            <tr>
                <th >Address</th>
                <td>${request.candidate.candidateProfile.address}</td>
            </tr>

            <tr>
                <th >City</th>
                <td>${request.candidate.candidateProfile.city}</td>
            </tr>
            <tr>
                <th >Region</th>
                <td>${request.candidate.candidateProfile.region}</td>
            </tr>
            <tr>
                <th >School</th>
                <td>${request.candidate.candidateProfile.school}</td>
            </tr>
            <tr>
                <th >Contact Number</th>
                <td>${request.candidate.candidateProfile.phoneNumber}</td>
            </tr>

            <tr>
                <th >Grade for ${request.faculty.getRequiredSubject1()} </th>
                <td>${request.getRequiredSubject1Grade()}</td>
            </tr>
            <tr>
                <th >Grade for ${request.faculty.getRequiredSubject2()}</th>
                <td>${request.getRequiredSubject2Grade()}</td>
            </tr>
            <tr>
                <th >Grade for ${request.faculty.getRequiredSubject3()}</th>
                <td>${request.getRequiredSubject3Grade()}</td>
            </tr>

            </thead>

        </table>

        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">

                <form action="/admin/request_approve" method="POST">
                    <input type="hidden" id="requestId" name="requestId" value="${request.getId()}">
                    <input type="hidden" id="facultyId" name="facultyId" value="${request.faculty.getId()}">
                    <button class="btn btn-primary mr-2" type="submit">Approve</button>
                </form>
                <form action="/admin/request_reject" method="POST">
                    <input type="hidden" id="requestId" name="requestId" value="${request.getId()}">
                    <input type="hidden" id="facultyId" name="facultyId" value="${request.faculty.getId()}">
                    <button class="btn btn-danger mr-2" type="submit">Reject</button>
                </form>
                <form action="/admin/requests_of_faculty/${request.faculty.getId()}" method="get">
                    <button class="btn btn-warning mr-2" type="submit"> Back</button>
                </form>

            </div>
        </div>
    </div>
</div>
</body>