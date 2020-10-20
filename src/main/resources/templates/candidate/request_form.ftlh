
<#import "../fragments/error.ftl" as error/>
<!doctype html>
<html lang="en">
<head>
    <#include "../fragments/bootsrap-links.ftl" />

    <title>Admission request form</title>
</head>
<body>


<#include "../fragments/nav-bar.ftl"/>

<br>
<main class="login-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <#if errorMessage??>
                <div class="alert alert-primary" role="alert">
                    ${errorMessage}

                    <form method="get" action="/faculties">
                        <button type="submit" class="btn btn-primary">
                            <@spring.message "admin.check_request.back"/>
                        </button>
                    </form>
                </div>
                <#else>
                <div class="card">
                    <div class="card-header"><@spring.message "admin.requests_of_faculty.to_the_faculty"/> ${faculty.getNameEn()}</div>
                    <div class="card-body">
                        <form action="/candidate/submit_request" method="post">

                            <div class="form-group row">
                                <label for="first_name" class="col-md-4 col-form-label text-md-right"><@spring.message "profile.edit.first_name"/></label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.firstName}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="last_name" class="col-md-4 col-form-label text-md-right"><@spring.message "profile.edit.last_name"/> </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.lastName}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right"><@spring.message "profile.edit.email"/></label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.email}
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="address" class="col-md-4 col-form-label text-md-right"><@spring.message "profile.edit.address"/> </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.address}
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right"> <@spring.message "profile.edit.phoneNumber"/></label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.phoneNumber}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject1Grade" class="col-md-4 col-form-label text-md-right"><@spring.message "candidate.admission.requests.grade.for"/>
                                    <#if springMacroRequestContext.getLocale().toString()?contains("uk")>
                                    ${faculty.getRequiredSubject1Uk()}
                                    <#else >
                                     ${faculty.getRequiredSubject1En()}
                                    </#if>
                                    </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject1Grade" min="1" max="12" class="form-control" name="requiredSubject1Grade" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject2Grade" class="col-md-4 col-form-label text-md-right"><@spring.message "candidate.admission.requests.grade.for"/>
                                  <#if springMacroRequestContext.getLocale().toString()?contains("uk")>
                                    ${faculty.getRequiredSubject2Uk()}
                                    <#else >
                                     ${faculty.getRequiredSubject2En()}
                                     </#if>
                                    </label> </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject2Grade" min="1" max="12" class="form-control" name="requiredSubject2Grade" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject3Grade"  class="col-md-4 col-form-label text-md-right"><@spring.message "candidate.admission.requests.grade.for"/>
                                  <#if springMacroRequestContext.getLocale().toString()?contains("uk")>
                                    ${faculty.getRequiredSubject3Uk()}
                                    <#else >
                                     ${faculty.getRequiredSubject3En()}
                                      </#if>
                                 </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject3Grade" min="1" max="12" class="form-control" name="requiredSubject3Grade" required>
                                </div>
                            </div>


                            <input type="hidden" id="candidateId" name="candidateId" value="${candidate.id}"/>
                            <input type="hidden" id="facultyId" name="facultyId" value="${faculty.id}"/>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    <@spring.message "faculty.submit_request"/>
                                </button>
                            </div>

                        </form>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>


</body>
</html>

</body>
</html>












<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="utf-8">-->
<#--    <title>Log in</title>-->
<#--</head>-->
<#--<body>-->
<#--<nav role="navigation">-->
<#--    <ul>-->
<#--        <li><a href="/">Home</a></li>-->
<#--    </ul>-->
<#--</nav>-->

<#--<h1>Faculty admission request form</h1>-->


<#--<form role="form" action="/submit_request" method="post">-->
<#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

<#--    <div>-->
<#--        <label for="first_name">First Name</label>-->
<#--        <input type="text" name="first_name" id="first_name" required autofocus/>-->
<#--    </div>-->
<#--    <div>-->
<#--        <label for="last_name">Last Name</label>-->
<#--        <input type="text" name="last_name" id="last_name" required />-->
<#--    </div>-->
<#--    <div>-->
<#--        <label for="address">Address</label>-->
<#--        <input type="text" name="address" id="address" required />-->
<#--    </div>-->
<#--    <div>-->
<#--        <label for="email">Email</label>-->
<#--        <input type="email" name="email" id="email" required />-->
<#--    </div>-->
<#--    <div>-->
<#--        <label for="number">Contact Number</label>-->
<#--        <input type="tel" name="number" id="number" required />-->
<#--    </div>-->
<#--    -->
<#--    <button type="submit">Submit</button>-->
<#--</form>-->

<#--&lt;#&ndash;<#if error.isPresent()>&ndash;&gt;-->
<#--&lt;#&ndash;    <p>The email or password you have entered is invalid, try again.</p>&ndash;&gt;-->
<#--&lt;#&ndash;</#if>&ndash;&gt;-->
<#--</body>-->
<#--</html>-->