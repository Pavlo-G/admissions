
    <#include "security.ftlh">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>



            </ul>


            <div class="nav-item dropdown my-2  mr-2  my-lg-0">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${name}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div>
            <#if isAdmin>
                <form action="/candidates" method="get">
                    <button type="submit">Candidates</button>
                </form>
            </#if>


            <form class="form-inline my-2 mr-2 my-lg-0" >
                <a class="btn btn-primary" href="/auth/login" role="button">Login</a>
            </form>

            <form class="form-inline my-2 my-lg-0" >
                <a class="btn btn-primary" href="/registration" role="button">Registration</a>
            </form>

            <form action="/auth/logout" method="post">
                <button type="submit">Logout</button>
            </form>

        </div>
    </nav>


