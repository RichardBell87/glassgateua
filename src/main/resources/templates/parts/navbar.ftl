<#include "security.ftl">
<#import "loginform.ftl" as log>

<div class="navbar">
    <div class="navbar-in">
        <#if !isUser !isAdmin !isCreator>
            <a class="navbar-menu" id="brand" href="/home/uk/all/uah/activeperiodends"><lan>GlassGateUA</lan></a>
        </#if>
        <#if isUser || isAdmin || isCreator>
            <a class="navbar-menu" id="brand" href="/main/uk/all/uah/activeperiodends"><lan>GlassGateUA</lan></a>
        </#if>

            <a class="navbar-menu" id="clean" href="" ><lan>Ви - ${name}</lan></a>

        <#if !isUser !isAdmin !isCreator>
            <a class="navbar-menu" id="navbar-inline" href="/login"><lan>Увійти</lan></a>
        </#if>
        <#if !isUser !isAdmin !isCreator>
            <a class="navbar-menu" id="navbar-inline" href="/registration"><lan>Зареєструватися</lan></a>
        </#if>
        <#if isUser || isAdmin || isCreator>
            <a class="navbar-menu" id="navbar-inline" href="/personaloffice/uk/all/uah/activeperiodends"><lan>В особистий кабінет</lan></a>
        </#if>

            <a class="navbar-menu" id="navbar-inline" href="/rules"><lan>Правила</lan></a>


            <a class="navbar-menu" id="navbar-inline" href="/connection"><lan>Зв'язатися з нами</lan></a>

        <#if isAdmin || isCreator>
            <a class="navbar-menut" id="navbar-inline" href="/adminpanel/uk/all/uah/activeperiodends"><lan>Панель адміністратора</a>
        </#if>

        <#if isUser || isAdmin || isCreator>
            <@log.logout "/glass_gate_ua_logout" />
        </#if>
    </div>
</div>