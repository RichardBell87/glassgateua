<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">
    <div class="canvas">
        <#--<#if !isUser !isAdmin !isCreator>-->
            <#--<div id="recover"><a id="recover" href="/recover_registration_data">Нагадати Логін та(або) пароль</a></div>-->
        <#--</#if>-->
            <div id="msg">${message!}</div>
        <#if !isUser !isAdmin !isCreator>
            <div><@log.login "/login"/></div>
        </#if>
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>