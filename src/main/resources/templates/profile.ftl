<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/foottemplate.ftl" as foo>

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
<#--<h5>${username}</h5>-->
${message!}
    <#include "parts/profileform.ftl">
</div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>