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
                <div class="card">
                    <div class="card-header">Admission request form</div>
                    <div class="card-body">
                        <#if errorMessage??>
                            <div class="alert alert-primary" role="alert">
                                ${errorMessage}

                                <form method="get"action="/faculties">

                                    <button type="submit" class="btn btn-primary">
                                        Go back to faculties list
                                    </button>
                                </form>
                            </div>
                        <#else>

                            <form action="/candidate/submit_request" method="post">

                                <div class="form-group row">
                                    <label for="first_name" class="col-md-4 col-form-label text-md-right">First
                                        Name </label>
                                    <div class="col-md-6">
                                        <input type="text" id="first_name" class="form-control" name="first_name"
                                               required autofocus>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="last_name" class="col-md-4 col-form-label text-md-right">Last
                                        Name </label>
                                    <div class="col-md-6">
                                        <input type="text" id="last_name" class="form-control" name="last_name"
                                               required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="address" class="col-md-4 col-form-label text-md-right">Address </label>
                                    <div class="col-md-6">
                                        <input type="text" id="address" class="form-control" name="address"
                                               required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail
                                        Address</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email_address" class="form-control" name="email"
                                               required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">Contact
                                        Number
                                    </label>
                                    <div class="col-md-6">
                                        <input type="tel" id="phone_number" class="form-control" name="phone_number"
                                               required>
                                    </div>
                                </div>


                                <#--                            <div class="form-group row">-->
                                <#--                                <label for="cert_file" class="col-md-4 col-form-label text-md-right">Certificate </label>-->
                                <#--                                <div class="col-md-6">-->
                                <#--                                    <img src="/img/file.png" id="upfile1" style="cursor:pointer" />-->
                                <#--                                    <input type="file" id="file1"  name="file1" style="display:none" />-->

                                <#--                                </div>-->
                                <#--                            </div>-->
                                <#--                            <script>-->
                                <#--                            function previewFile() {-->
                                <#--                            const preview = document.querySelector('img');-->
                                <#--                            const file = document.querySelector('input[type=file]').files[0];-->
                                <#--                            const reader = new FileReader();-->

                                <#--                            reader.addEventListener("load", function () {-->
                                <#--                            // convert image file to base64 string-->
                                <#--                            preview.src = reader.result;-->
                                <#--                            }, false);-->

                                <#--                            if (file) {-->
                                <#--                            reader.readAsDataURL(file);-->
                                <#--                            }-->
                                <#--                            }-->
                                <#--                            </script>-->


                                <input type="hidden" name="userId" value="${userId}"/>
                                <input type="hidden" name="facultyId" value="${facultyId}"/>

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