<#include "security.ftlh"/>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Admission Board App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">


            <#if isAdmin>
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0" action="/candidates" method="get">
                        <button class="btn btn-primary" type="submit">Candidates</button>
                    </form>
                </li>

            </#if>

            <#if know>
            <li class="nav-item">
                <form class="form-inline my-2 mr-2 my-lg-0">
                    <a class="btn btn-primary" href="/faculties" role="button">faculties</a>
                </form>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <div class="nav-item dropdown">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Account:${name}
                            <b class="caret"></b></a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <button class="dropdown-item" type="button">My profile</button>
                                    <button class="dropdown-item" type="button">My requests</button>
                                    <form action="/auth/logout" method="post">
                                    <button class="dropdown-item" type="submit">Logout</button>
                                    </form>
                                </div>

                        </form>
                    </li>
                </ul>
            </div>
        </ul>
        <#else>
            <form class="form-inline my-2 mr-2 my-lg-0">
                <a class="btn btn-primary" href="/auth/login" role="button">Login</a>
            </form>
            <form class="form-inline my-2 my-lg-0">
                <a class="btn btn-primary" href="/registration" role="button">Registration</a>
            </form>
        </#if>
    </div>
</nav>




