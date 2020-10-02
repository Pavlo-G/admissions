



<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
    >
<head>
    <title>Admission board app </title>
    <#include "fragments/bootsrap-links.ftl"/>

</head>
<body>
<#include "fragments/nav-bar.ftl" />
<form action="/auth/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>

</form>
</body>
</html>