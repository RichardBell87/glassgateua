<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" manifest="example.appcache>

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/adminpanel.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/navbaradminpanel.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/currentexchangerate.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/lotlistmenu.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/adminpanellotlist.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/pagination.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbaradminpanel.ftl">
    <div class="canvas">
        <#include "parts/currentexchangerate.ftl">
        <#include "parts/lotlistmenu.ftl">
        <#include "parts/lotlist.ftl">
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>