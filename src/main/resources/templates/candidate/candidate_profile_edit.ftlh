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
                <input type="hidden" id="id" class="form-control" name="id" value="<#if candidateProfileDTO??>${candidateProfileDTO.id}<#else>${candidate.candidateProfile.id}</#if>"/>

                <thead>
                <tr>
                    <th><label for="username"><@spring.message "profile.edit.username"/></label></th>
                    <td>
                        <div>
                            <#if candidateProfileDTO??>${username}<#else>${candidate.username}</#if>
                        </div>
                    </td>
                </tr>

                <tr>

                    <th><label for="email"><@spring.message "profile.edit.email"/></label></th>

                    <td>
                        <div>
                            <input type="email" id="email"
                                   class="form-control ${(emailError??)?string('is-invalid', '')}" name="email"
                                   value=" <#if candidateProfileDTO??>${candidateProfileDTO.email}<#else>${candidate.candidateProfile.email}</#if>"
                                   autofocus/>

                            <#if emailError??>
                                <div class="invalid-feedback">
                                    ${emailError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>

                <tr>
                    <th><label for="firstName"><@spring.message "profile.edit.first_name"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="firstName"
                                   class="form-control ${(firstNameError??)?string('is-invalid', '')}"
                                   name="firstName"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.firstName}<#else>${candidate.candidateProfile.firstName} </#if>"/>
                            <#if firstNameError??>
                                <div class="invalid-feedback">
                                    ${firstNameError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>

                <tr>

                    <th><label for="lastName"><@spring.message "profile.edit.last_name"/></label></th>

                    <td>
                        <div>
                            <input type="text" id="lastName"
                                   class="form-control ${(lastNameError??)?string('is-invalid', '')}" name="lastName"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.lastName}<#else>${candidate.candidateProfile.lastName}</#if>"/>
                            <#if lastNameError??>
                                <div class="invalid-feedback">
                                    ${lastNameError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>


                <tr>
                    <th><label for="address"><@spring.message "profile.edit.address"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="address"
                                   class="form-control ${(addressError??)?string('is-invalid', '')}" name="address"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.address}<#else>${candidate.candidateProfile.address}</#if>"/>
                            <#if addressError??>
                                <div class="invalid-feedback">
                                    ${addressError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="city"><@spring.message "profile.edit.city"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="city" class="form-control ${(cityError??)?string('is-invalid', '')}"
                                   name="city"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.city}<#else>${candidate.candidateProfile.city}</#if>"/>
                            <#if cityError??>
                                <div class="invalid-feedback">
                                    ${cityError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="region"><@spring.message "profile.edit.region"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="region"
                                   class="form-control ${(regionError??)?string('is-invalid', '')}" name="region"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.region}<#else>${candidate.candidateProfile.region}</#if>"/>
                            <#if regionError??>
                                <div class="invalid-feedback">
                                    ${regionError}
                                </div>
                            </#if>
                        </div>

                    </td>
                </tr>
                <tr>
                    <th><label for="school"><@spring.message "profile.edit.school"/></label></th>
                    <td>
                        <div>
                            <input type="text" id="school"
                                   class="form-control ${(schoolError??)?string('is-invalid', '')}" name="school"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.school}<#else>${candidate.candidateProfile.school}</#if>"/>
                            <#if schoolError??>
                                <div class="invalid-feedback">
                                    ${schoolError}
                                </div>
                            </#if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label for="phoneNumber"><@spring.message "profile.edit.phoneNumber"/></label></th>
                    <td>
                        <div>
                            <input type="tel" id="phoneNumber"
                                   class="form-control  ${(phoneNumberError??)?string('is-invalid', '')}"
                                   name="phoneNumber"
                                   value="<#if candidateProfileDTO??>${candidateProfileDTO.phoneNumber}<#else>${candidate.candidateProfile.phoneNumber}</#if>"/>
                            <#if phoneNumberError??>
                                <div class="invalid-feedback">
                                    ${phoneNumberError}
                                </div>
                            </#if>
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
<br>
<br>
<#include "../fragments/footer.ftlh"/>
</body>