<#include "security.ftl">
<#import "loginform.ftl" as log>

<div class="navbar">
    <div class="navbar-in">
        <#if isUser || isAdmin || isCreator>
            <a class="navbar-menu" id="brand" href="/main/uk/all/uah/activeperiodends"><lan>GlassGateUA</lan></a>
        </#if>

            <a class="navbar-menu" id="clean" href="" ><lan>Ви - ${name}</lan></a>

        <#if isUser || isAdmin || isCreator>
            <a class="navbar-menu" id="navbar-inline" href="/lotcreated"><lan>Створити лот</lan></a>
        </#if>
        <#if isUser || isAdmin || isCreator>
            <a class="navbar-menu" id="navbar-inline" href="/user/profile"><lan>Редагувати профіль</lan></a>
        </#if>

            <a class="navbar-menu" id="navbar-inline" href="/rules"><lan>Правила</lan></a>

        <#if isUser || isAdmin || isCreator>
            <@log.logout "/glass_gate_ua_logout" />
        </#if>
    </div>
</div>