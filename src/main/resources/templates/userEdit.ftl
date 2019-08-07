<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
</head>

<body>
<#include "parts/wall.ftl">
<#include "parts/navbar.ftl">

<div class="canvas">
    Права користувача ${user.username}
</div>

<div class="container mt-3 inner-content">
    <form action="/user" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Логін:</label>
            <div class="col-sm-10">
                <input type="text"
                       required autocomplete="off"
                       pattern="[0-9 A-Za-zА-Яа-яЁёЄєҐґІіЇї']{2,50}"
                       name="username"
                       class="form-control"
                       value="${user.username}"
                       placeholder="Admin" />
            </div>
        </div>
        <#--<input type="text" name="username" value="${user.username}">-->
        <#list roles as role>
        <div>
            <label><input type="checkbox" class="btn btn-outline-primary" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary" type="submit">Зберегти</button>
    </form>
</div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>