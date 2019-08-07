<#include "parts/security.ftl">
<#import "parts/headtemplate.ftl" as hea>
<#import "parts/connectionform.ftl" as con>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <@hea.page>
        <#include "parts/headtemplate.ftl">
    </@hea.page>
    <link href="/static/css/connection.css" rel="stylesheet" type="text/css"/>
    <script  src="/static/js/jquery-1.9.1.js"></script>
</head>

<body>
    <#include "parts/wall.ftl">
    <#include "parts/navbar.ftl">
    <div class="canvas">
        <div class="support">
            <div class="support-1">
                Технічна підтримка:
            </div>
            <div class="support-2">
                +38(099)0036705 +38(098)0036705 +38(073)0036705 або Ви можете скористатися формою нижче:
            </div>
        </div>
        <#--<div id="msg">-->
            <#--${message!}-->
        <#--</div>-->
        <div>
            <@con.connection "/connection" />
        </div>
    </div>
    <#include "parts/foottemplate.ftl">
    <#include "parts/loadingend.ftl">
</body>
</html>