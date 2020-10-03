<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admission board app faculties </title>
    <#include "fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<#include "fragments/nav-bar.ftl" />


<section class="details-card">
    <h4>Available faculties</h4>
    <hr>
    <div class="container">
        <div class="row">
            <#list all_faculties as faculty>
                <div class="col-md-4">
                    <div class="card-content">
                        <div class="card-img">
                            <img src="https://placeimg.com/380/230/nature" alt="">
                            <span><h4>${faculty.getName()}</h4></span>
                        </div>
                        <div class="card-desc">
                            <h3>${faculty.getName()}</h3>
                            <p>${faculty.getDescription()}</p>

                                <div>
                                    <form method="get" action="/candidate/submit_request">
                                        <input type="hidden" name="username" value="${name}">
                                        <input type="hidden" name="faculty_id" value="${faculty.getId()}">
                                        <button type="submit" class="btn btn-primary">Send admission request</button>
                                    </form>
                                </div>




                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>





</body>
</html>
