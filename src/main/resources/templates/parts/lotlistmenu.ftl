<#include "security.ftl">

<#if  interfacelanguage == "0000000000">
    <#if  lottype == "0000000000">
        <#if  currency == "0000000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                 <div class="lot-menu-dropdown" id="lot-input-category">
                     <form method="get" action="${url}">
                         <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                         <input type="text"
                                class="lot-input-form"
                         <#--required autocomplete="off"-->
                         <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                name="filter"
                                value="${filter!}"
                                placeholder="Пошук за категорією або ID">
                     </form>
                 </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                 <div class="lot-menu-dropdown" id="lot-input-category">
                     <form method="get" action="${url}">
                         <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                         <input type="text"
                                class="lot-input-form"
                         <#--required autocomplete="off"-->
                         <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                name="filter"
                                value="${filter!}"
                                placeholder="Пошук за категорією або ID">
                     </form>
                 </div>
            </#if>
            <#if  assortment == "0000300000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000"><#--<по категориї від А до Я>-->
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0010000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="main-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000"><#--<старіші лоти>-->
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                    <div class="lot-menu-dropdown" id="lot-input-category">
                        <form method="get" action="${url}">
                            <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                            <input type="text"
                                   class="lot-input-form"
                            <#--required autocomplete="off"-->
                            <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                   name="filter"
                                   value="${filter!}"
                                   placeholder="Пошук за категорією або ID">
                        </form>
                    </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0020000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Купівля</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
    </#if>








    <#if  lottype == "0100000000">
        <#if  currency == "0000000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000"><#--<новіші лоти>-->
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="main-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lotn-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0010000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content" id="lot-menu-dropdown-content-1">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content" id="lot-menu-dropdown-content-2">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content" >
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0020000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Продаж</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Всі</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
    </#if>








    <#if  lottype == "0200000000">
        <#if  currency == "0000000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                 <div class="lot-menu-dropdown" id="lot-input-category">
                     <form method="get" action="${url}">
                         <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                         <input type="text"
                                class="lot-input-form"
                         <#--required autocomplete="off"-->
                         <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                name="filter"
                                value="${filter!}"
                                placeholder="Пошук за категорією або ID">
                     </form>
                 </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                 <div class="lot-menu-dropdown" id="lot-input-category">
                     <form method="get" action="${url}">
                         <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                         <input type="text"
                                class="lot-input-form"
                         <#--required autocomplete="off"-->
                         <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                name="filter"
                                value="${filter!}"
                                placeholder="Пошук за категорією або ID">
                     </form>
                 </div>
            </#if>
            <#if  assortment == "0000300000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000"><#--<по категориї від А до Я>-->
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/uah/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Гривня</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0010000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="main-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000"><#--<старіші лоти>-->
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                    <div class="lot-menu-dropdown" id="lot-input-category">
                        <form method="get" action="${url}">
                            <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                            <input type="text"
                                   class="lot-input-form"
                            <#--required autocomplete="off"-->
                            <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                                   name="filter"
                                   value="${filter!}"
                                   placeholder="Пошук за категорією або ID">
                        </form>
                    </div>
            </#if>
            <#if  assortment == "0000700000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/usd/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Долар США</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
        <#if  currency == "0020000000">
            <#if  assortment == "0000000000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodends?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності закінчується</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000100000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/activeperiodbegins?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Період активності триваліший</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000200000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/new?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/new?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/new?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Новіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000300000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/old?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/old?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/old?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Старіші лоти</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000400000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/expensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/expensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/expensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від дорогого до дешевшого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000500000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/inexpensive?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від девшого до дорожчого</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000600000">
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                    <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromatoz?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/uah/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Гривня</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromatoz?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від від А до Я</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&size=${page.getSize()}">По категориї від Я до А</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
            <#if  assortment == "0000700000">
                 <div class="lot-menu-dropdown" id="lot-menu-dropdown-1">
                     <span>Тип операції:<a class="dropdown-filters"> Всі</a></span>
                     <div class="lot-menu-dropdown-content">
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/buy/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Купівля</a></ul>
                         <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/sale/euro/fromztoa?filter=${filter}&size=${page.getSize()}">Продаж</a></ul>
                     </div>
                 </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-2">
                    <span>Валюта:<a class="dropdown-filters"> Євро</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/usd/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Долар США</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromztoa?filter=${filter}&page=${(page.getNumber()+ 1)}&size=${page.getSize()}">Євро</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-menu-dropdown-3">
                    <span>Сортувати:<a class="dropdown-filters"> Від Я до А</a></span>
                    <div class="lot-menu-dropdown-content">
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodends?filter=${filter}&size=${page.getSize()}">Період активності закінчується</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/activeperiodbegins?filter=${filter}&size=${page.getSize()}">Період активності триваліший</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/new?filter=${filter}&size=${page.getSize()}">Спочатку новіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/old?filter=${filter}&size=${page.getSize()}">Спочатку старіші лоти</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/expensive?filter=${filter}&size=${page.getSize()}">Від дорогого до дешевшого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/inexpensive?filter=${filter}&size=${page.getSize()}">Від девшого до дорожчого</a></ul>
                        <ul class="lot-menu-link" ><a href="/${adminpanelmainhomepersonaloffice}/uk/all/euro/fromatoz?filter=${filter}&size=${page.getSize()}">По категориї від А до Я</a></ul>
                    </div>
                </div>
                <div class="lot-menu-dropdown" id="lot-input-category">
                    <form method="get" action="${url}">
                        <button type="submit" class="dropdown-filters-btn">Категорія або ID:</button>
                        <input type="text"
                               class="lot-input-form"
                        <#--required autocomplete="off"-->
                        <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                               name="filter"
                               value="${filter!}"
                               placeholder="Пошук за категорією або ID">
                    </form>
                </div>
            </#if>
        </#if>
    </#if>
</#if>