<#include "security.ftl">

<div class="navbaradminpanel">
    <div class="navbaradminpanel-in">

        <#if isUser || isAdmin || isCreator>
            <a class="navbaradminpanel-menu" id="brand" href="/main/uk/all/uah/activeperiodends"><lan>GlassGateUA</lan></a>
        </#if>

            <a class="navbaradditional-menu" id="clean" href="" ><lan>Ви - ${name}</lan></a>

         <#if isAdmin || isCreator>
            <a class="navbar-menut" id="navbar-inline" href="/adminpanel/uk/all/uah/activeperiodends"><lan>Панель адміністратора</a>
         </#if>
        <#if isUser || isAdmin || isCreator>
            <@log.logout "/glass_gate_ua_logout" />
        </#if>
    </div>
</div>