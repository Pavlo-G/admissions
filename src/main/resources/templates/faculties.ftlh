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
<br>
<h4>Available faculties</h4>
<hr>

<#--    <div class="border-card">-->
<#--        <div class="card-type-icon with-border">${faculty.getId()}</div>-->
<#--        <div class="content-wrapper">-->
<#--            <div class="label-group fixed">-->
<#--                <p class="title">Name</p>-->
<#--                <p class="caption">${faculty.getName()}</p>-->
<#--            </div>-->
<#--            <div class="min-gap"></div>-->
<#--            <div class="label-group">-->
<#--                <p class="title">Description</p>-->
<#--                <p class="caption">${faculty.getDescription()}</p>-->
<#--            </div>-->
<#--            <div class="min-gap"></div>-->
<#--            <div class="label-group">-->
<#--                <p class="title">Budget Capacity</p>-->
<#--                <p class="caption">${faculty.getBudgetCapacity()}</p>-->
<#--            </div>-->
<#--            <div class="min-gap"></div>-->
<#--            <div class="label-group">-->
<#--                <p class="title">Total Capacity</p>-->
<#--                <p class="caption">${faculty.getTotalCapacity()}</p>-->
<#--            </div>-->
<#--        </div>-->
<section class="details-card">
    <div class="container">
        <div class="row">
            <#list all_faculties as faculty>
                <div class="col-md-4">
                    <div class="card-content">
                        <div class="card-img">
                            <img src="https://placeimg.com/380/230/nature" alt="">
                            <span><h4>heading</h4></span>
                        </div>
                        <div class="card-desc">
                            <h3>${faculty.getName()}</h3>
                            <p>${faculty.getDescription()}</p>
<#--                            <a href="#" class="btn-card">Read</a>-->
                            <#if isAdmin >
                                <div>
                                    <form method="get" action="/edit_faculty">
                                        <input type="hidden" name="faculty_id" value="${faculty.getId()}">
                                        <button type="submit" class="btn btn-primary">Edit Faculty</button>
                                    </form>
                                </div>
                                <div>
                                    <form method="get" action="/delete_faculty">
                                        <input type="hidden" name="faculty_id" value="${faculty.getId()}">
                                        <button type="submit" class="btn btn-primary">Delete Faculty</button>
                                    </form>
                                </div>

                            <#else>
                                <div>
                                    <form method="get" action="/submit_request">
                                        <input type="hidden" name="username" value="${name}">
                                        <input type="hidden" name="faculty_id" value="${faculty.getId()}">
                                        <button type="submit" class="btn btn-primary">Send admission request</button>
                                    </form>
                                </div>

                            </#if>


                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>


</div>


</body>
</html>
