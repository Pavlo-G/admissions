
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
        <h2 class="text-danger">Candidate Profile</h2>
        <form class="form-inline ml-auto my-2 my-lg-0"
                action="/api/candidate/edit/${candidate.getId()}" method="get">
            <button class="btn btn-primary " type="submit">Edit Details</button>
        </form>

        <table class="table table-bordered success">
            <thead>
            <tr>
                <th>Username</th>
                <td>${candidate.username}</td>
            </tr>
            <tr>
                <th class="info">Email</th>
                <td>${candidate.candidateProfile.email}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${candidate.candidateProfile.firstName}</td>
            </tr>
            <tr>
                <th class="info">Last Name</th>
                <td>${candidate.candidateProfile.lastName}</td>
            </tr>

            <tr>
                <th class="info">Address</th>
                <td>${candidate.candidateProfile.address}</td>
            </tr>
            <tr>
                <th class="info">City</th>
                <td>${candidate.candidateProfile.city}</td>
            </tr>

            <tr>
                <th class="info">Region</th>
                <td>${candidate.candidateProfile.region}</td>
            </tr>
            <tr>
                <th class="info">School</th>
                <td>${candidate.candidateProfile.school}</td>
            </tr>
            <tr>
                <th class="info">Phone number</th>
                <td>${candidate.candidateProfile.phoneNumber}</td>
            </tr>

            </thead>

        </table>
    </div>
</div>
</body>