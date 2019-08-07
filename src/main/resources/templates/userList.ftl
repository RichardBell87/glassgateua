<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/userlist.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<#include "parts/wall.ftl">
<#include "parts/navbar.ftl">

<div class="canvas">
    Список користувачів
<table>
    <thead>
    <tr>
        <th>Логін</th>
        <th>Права</th>
        <th>Редагувати</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">Редагувати</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>