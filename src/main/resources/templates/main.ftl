<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <#--<link href="/static/css/turbolinks.css" rel="stylesheet" type="text/css"/>-->
    <link href="/static/css/currentexchangerate.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/lotlistmenu.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/lotlist.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/pagination.css" rel="stylesheet" type="text/css"/>
    <#--<script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>-->
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">
    <div class="canvas">
            <div id="msg">${message!}</div>
            <#include "parts/currentexchangerate.ftl">
            <#include "parts/lotlistmenu.ftl">
            <#include "parts/lotlist.ftl">
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>