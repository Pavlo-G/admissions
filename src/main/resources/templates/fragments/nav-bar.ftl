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
                    <form class="form-inline my-2 my-lg-0" action="/api/candidate" method="get">
                        <button class="btn btn-primary" type="submit">Candidates</button>
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




