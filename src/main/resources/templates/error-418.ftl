<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/loginform.ftl" as log>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/httperror.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">

<div class="canvas">
    <div class="error" >
        <div id="iamateapot">Кава скінчилась((( Чаю?</div>
    </div>
</div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>