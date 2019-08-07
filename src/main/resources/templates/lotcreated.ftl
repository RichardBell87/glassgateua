<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/lotcreated.css" rel="stylesheet" type="text/css"/>
    <script  src="/static/js/jquery-1.9.1.js"></script>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">
    <div class="canvas">
        <#include "parts/lotcreatedform.ftl">
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>