<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <#if !isUser !isAdmin !isCreator>
        <meta http-equiv="refresh" content="30; /home/uk/all/uah/activeperiodends">
    </#if>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/welcome.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">

<div class="canvas">
    <#if !isUser !isAdmin !isCreator>
        <div><a class="first-string" href="/home/uk/buy/uah/activeperiodends">Welcome to the <span class="brand"><gg href="/home/uk/buy/uah/activeperiodends">GlassGate<lan class="brand-ua">UA</lan></gg></span>...</a></div>
        <div><a class="second-string" href="/home/uk/buy/uah/activeperiodends">welcome to the marketplace of the future...</a></div>
    </#if>
    <#if isUser || isAdmin || isCreator>
        <div><a class="first-string" href="/main/uk/buy/uah/activeperiodends">Welcome to the <span class="brand"><gg href="/main/uk/buy/uah/activeperiodends">GlassGate<lan class="brand-ua">UA</lan></gg></span>...</a></div>
        <div><a class="second-string" href="/main/uk/buy/uah/activeperiodends">welcome to the marketplace of the future...</a></div>
    </#if>
</div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>