<#include "security.ftlh"/>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <#if know>
    <a class="navbar-brand" href="/faculties">Admission Board App</a>
    <#else >
        <a class="navbar-brand" href="/">Admission Board App</a>
    </#if>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isAdmin>
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0" action="/admin/workspace" method="get">
                        <button class="btn btn-primary" type="submit">Admin Workspace</button>
                    </form>
                </li>
            </#if>
        </ul>


        <#if know>

            <div class="nav-item dropdown">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Account:${name}
                            <b class="caret"></b></a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <form action="" method="get">
                            <button class="dropdown-item" type="submit">My profile</button>
                            </form>
                            <form action="/candidate/candidate_requests" method="get">
                            <button class="dropdown-item" type="submit">My requests</button>
                            </form>
                            <form action="/auth/logout" method="post">
                                <button class="dropdown-item" type="submit">Logout</button>
                            </form>
                        </div>

                        </form>
                    </li>
                </ul>
            </div>

        <#else>
            <div>

                <form class="form-inline my-2 mr-2 my-lg-0">
                    <a class="btn btn-primary my-2 my-sm-0" href="/auth/login" role="button">Login</a>
                </form>
            </div>
            <div>

                <form class="form-inline my-2 my-lg-0">
                    <a class="btn btn-primary my-2 my-sm-0" href="/registration" role="button">Registration</a>
                </form>

            </div>

        </#if>
    </div>
</nav>




