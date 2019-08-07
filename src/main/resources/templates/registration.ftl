<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/registrationform.ftl" as reg>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/registration.css" rel="stylesheet" type="text/css"/>
    <script  src="/static/js/jquery-1.9.1.js"></script>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">
    <div class="canvas">
        <div id="msg">${message!}</div>
        <#if !isUser !isAdmin !isCreator>
            <div><@reg.registration "/registration" /></div>
            <script  src="/static/js/passwordmatch.js"></script>
        </#if>
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>