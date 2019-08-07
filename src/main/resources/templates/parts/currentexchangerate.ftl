<div class="currentexchangerate">
    <div class="resource-1">
        <div>
            glassgateua.com
        </div>
        <div class="resource-in">
            <#if usd != 1>
                ${1 / usd}<div class="current-in">USD</div>
            </#if>
            <#if usd == 1>
                <div class="attention">
                    update
                </div>
                <div class="current-in">
                    USD
                </div>
            </#if>
        </div>
        <div class="resource-in">
            <#if euro != 1>
                ${1 / euro}<div class="current-in">Euro</div>
            </#if>
            <#if euro == 1>
                <div class="attention">
                    update
                </div>
                <div class="current-in">
                    Euro
                </div>
            </#if>
        </div>
    </div>
    <div class="resource-2">
        <div>
            minfin.com.ua
        </div>
        <div class="resource-in">
            <#if minfinUsd != 1>
                ${minfinUsd?string(",##0.00")}<div class="current-in">USD</div>
            </#if>
            <#if minfinUsd == 1>
                update<div class="current-in">USD</div>
            </#if>
        </div>
        <div class="resource-in">
            <#if minfinEuro != 1>
                ${minfinEuro?string(",##0.00")}<div class="current-in">Euro</div>
            </#if>
            <#if minfinEuro == 1>
                update<div class="current-in">Euro</div>
            </#if>
        </div>
    </div>
    <div class="resource-3">
        <div>
            goverla.ua
        </div>
        <div class="resource-in">
            <#if goverlaUsd != 1>
                ${goverlaUsd?string(",##0.00")}<div class="current-in">USD</div>
            </#if>
            <#if goverlaUsd == 1>
                update<div class="current-in">USD</div>
            </#if>
        </div>
        <div class="resource-in">
            <#if goverlaEuro != 1>
                ${ goverlaEuro?string(",##0.00")}<div class="current-in">Euro</div>
            </#if>
            <#if goverlaEuro == 1>
                update<div class="current-in">Euro</div>
            </#if>
        </div>
    </div>
    <div class="resource-4">
        <div>
            bank.gov.ua
        </div>
        <div class="resource-in">
            <#if bankUsd != 1>
                ${bankUsd?string(",##0.00")}<div class="current-in">USD</div>
            </#if>
            <#if bankUsd == 1>
                update<div class="current-in">USD</div>
            </#if>
        </div>
        <div class="resource-in">
            <#if bankEuro != 1>
                ${bankEuro?string(",##0.00")}<div class="current-in">Euro</div>
            </#if>
            <#if bankEuro == 1>
                update<div class="current-in">Euro</div>
            </#if>
        </div>
    </div>
</div>