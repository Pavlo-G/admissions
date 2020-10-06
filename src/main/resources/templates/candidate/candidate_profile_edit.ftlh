<#import "../fragments/error.ftl" as error>
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
        <h2 class="text-danger"><@spring.message "profile.edit.edit_profile"/></h2>
        <@error.error/>

        <table class="table table-bordered success">
            <form action="/api/candidate/update" method="post">
                <input type="hidden" id="id" class="form-control" name="id" value="${candidate.candidateProfile.id}">
                <thead>
                <tr>
                    <th><label for="username"><@spring.message "profile.edit.username"/></label></th>
                    <td>
                        <div>
                              ${candidate.username}
                        </div>
                    </td>
                </tr>

                <tr>

                    <th><label for="email"><@spring.message "profile.edit.email"/></label></th>

                    <td>
                        <div>
                            <input type="email" id="email" class="form-control" name="email"
                                   value="${candidate.candidateProfile.email}" required autofocus>
                        </div>
                    </td>
                </tr>

                <tr>
                    <th><label for="firstName"><@spring.message "profile.edit.first_name"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="firstName" class="form-control" name="firstName"
                                   value="${candidate.candidateProfile.firstName}" required autofocus>
                        </div>
                    </td>
                </tr>

                <tr>

                    <th><label for="lastName"><@spring.message "profile.edit.last_name"/></label></th>

                    <td>
                        <div>
                            <input type="text" id="lastName" class="form-control" name="lastName"
                                   value="${candidate.candidateProfile.lastName}">
                        </div>
                    </td>
                </tr>


                <tr>
                    <th><label for="address"><@spring.message "profile.edit.address"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="address" class="form-control" name="address"
                                   value="${candidate.candidateProfile.address}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="city"><@spring.message "profile.edit.city"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="city" class="form-control" name="city"
                                   value="${candidate.candidateProfile.city}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="region"><@spring.message "profile.edit.region"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="region" class="form-control" name="region"
                                   value=" ${candidate.candidateProfile.region}">
                        </div>

                    </td>
                </tr>
                <tr>
                    <th><label for="school"><@spring.message "profile.edit.school"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="school" class="form-control" name="school"
                                   value="${candidate.candidateProfile.school}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="phoneNumber"><@spring.message "profile.edit.phoneNumber"/></label></th>
                    <td>
                        <div>
                            <input type="tel" id="phoneNumber" class="form-control" name="phoneNumber"
                                   value="${candidate.candidateProfile.phoneNumber}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <div>
                            <button class="btn btn-primary "
                                    type="submit"><@spring.message "profile.edit.save"/></button>
                        </div>
                    </td>
                </tr>

                </thead>
            </form>
        </table>

    </div>
</div>
</body>