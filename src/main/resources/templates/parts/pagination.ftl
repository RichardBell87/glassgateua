<#macro pagination url page>
    <#if page.getTotalPages() gt 7>
        <#assign
        totalPages = page.getTotalPages()
        pageNumber = page.getNumber() + 1

        head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
        tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
        bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
        bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

        body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
        >
    <#else>
        <#assign body = 1..page.getTotalPages()>
    </#if>

    <div class="pager">
        <div class="pager-value">
            <ul class="pagination-page">
                <li class="page-item-disabled">
                    <a class="page-link" href="#" tabindex="-1">Сторінки:</a>
                </li>
            <#list body as p>
                <#if (p - 1) == page.getNumber()>
                    <li class="page-item-active">
                        <a class="page-link" href="#" tabindex="-1"><lan class="page-item-active-1">${p}</lan></a>
                    </li>
                <#elseif p == -1>
                    <li class="page-item-disabled">
                        <a class="page-link" href="#" tabindex="-1"><lan class="page-item-disabled-1">...</lan></a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?filter=${filter}&page=${p}&size=${page.getSize()}" tabindex="-1"><lan id="transparent">${p}</lan></a>
                    </li>
                    <#if p = 0 ><style>#transparent{color: transparent}</style></#if>
                </#if>
            </#list>
            </ul>

            <ul class="pagination-element">
                <li class="page-item-disabled">
                    <a class="page-link" href="#" tabindex="-1">Элементів на сторінці:</a>
                </li>
            <#list [4, 8, 16, 32] as siz>
                <#if siz == page.getSize()>
                    <li class="page-item-active">
                        <a class="page-link" href="#" tabindex="-1"><lan class="page-item-active-1">${siz}</lan></a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?filter=${filter}&?page=${page.getNumber()}&size=${siz}" tabindex="-1"><lan>${siz}</lan></a>
                    </li>
                </#if>
            </#list>
            </ul>
        </div>
    </div>
</#macro>