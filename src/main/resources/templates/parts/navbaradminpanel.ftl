<#include "security.ftl">

<div class="navbaradminpanel">
    <div class="navbaradminpanel-in">

        <#if isUser || isAdmin || isCreator>
            <a class="navbaradminpanel-menu" id="brand" href="/main/uk/all/uah/activeperiodends"><lan>GlassGateUA</lan></a>
        </#if>

            <a class="navbaradditional-menu" id="clean" href="" ><lan>Ви - ${name}</lan></a>

        <#if isAdmin || isCreator>
            <a class="navbaradminpanel-menut" id="navbaradditional-inline" href="/user"><lan>Список користувачів</a>
        </#if>
        <#if isAdmin || isCreator>
            <a class="navbaradminpanel-menut" id="navbaradditional-inline" href="/adminpanel/exchange"><lan>Змінити курс валют</a>
        </#if>
        <#if isUser || isAdmin || isCreator>
            <@log.logout "/glass_gate_ua_logout" />
        </#if>
    </div>
</div>