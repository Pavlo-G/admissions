<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->



<#import "../fragments/error-login.ftl" as error/>
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
                            Go back to faculties list
                        </button>
                    </form>
                </div>
                <#else>
                <div class="card">
                    <div class="card-header">Admission request to ${faculty.name}</div>
                    <div class="card-body">
                        <form action="/candidate/submit_request" method="post">

                            <div class="form-group row">
                                <label for="first_name" class="col-md-4 col-form-label text-md-right">First
                                    Name </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.firstName}}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="last_name" class="col-md-4 col-form-label text-md-right">Last
                                    Name </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.lastName}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail
                                    Address</label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.email}
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="address" class="col-md-4 col-form-label text-md-right">Address </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.address}
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right">Contact
                                    Number
                                </label>
                                <div class="col-md-6">
                                    ${candidate.candidateProfile.phoneNumber}
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject1Grade" class="col-md-4 col-form-label text-md-right">Grade For ${faculty.getRequiredSubject1()} </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject1Grade" class="form-control" name="requiredSubject1Grade" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject2Grade" class="col-md-4 col-form-label text-md-right">Grade For ${faculty.getRequiredSubject2()} </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject2Grade" class="form-control" name="requiredSubject2Grade" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject3Grade" class="col-md-4 col-form-label text-md-right">Grade For ${faculty.getRequiredSubject3()} </label>
                                <div class="col-md-6">
                                    <input type="number" id="requiredSubject3Grade" class="form-control" name="requiredSubject3Grade" required>
                                </div>
                            </div>


                            <input type="hidden" id="candidateId" name="candidateId" value="${candidate.getId()}"/>
                            <input type="hidden" id="facultyId" name="facultyId" value="${faculty.getId()}"/>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Submit Request
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