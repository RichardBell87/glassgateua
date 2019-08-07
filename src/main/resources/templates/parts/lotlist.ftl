<#include "security.ftl">
<#import "pagination.ftl" as pag>

<div id="lot-list">
        <#list page.content as lot>
            <div class="lot" data-id="${lot.id}">
                <#if interfacelanguage == "0000000000">
                    <#if lot.lottype == "0000000000">
                        <div class="lot-characteristic-name">
                            ID лота: <span class="lot-characteristic" >${lot.id+lot.id+1000000-1}</span>
                        </div>
                    </#if>
                    <#if lot.lottype == "0100000000">
                        <div class="lot-characteristic-name">
                            ID лота: <span class="lot-characteristic" >${lot.id+lot.id+5000000-1}</span>
                        </div>
                    </#if>
                    <div class="lot-characteristic-name">Залишилось:
                        <span class="lot-characteristic-datetime" id="${lot.id}">update</span>
                        <#if currency == "0000000000" && lot.lotbasecurrency == "0000000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " грн";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " грн";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0000000000" && lot.lotbasecurrency == "0010000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice / usd}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal / usd}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " грн";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " грн";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0000000000" && lot.lotbasecurrency == "0020000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice / euro}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal / euro}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " грн";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " грн";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0010000000" && lot.lotbasecurrency == "0000000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice * usd}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal * usd}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " usd";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " usd";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0010000000" && lot.lotbasecurrency == "0010000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " usd";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " usd";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0010000000" && lot.lotbasecurrency == "0020000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice / euro * usd}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal / euro * usd}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " usd";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " usd";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0020000000" && lot.lotbasecurrency == "0000000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice * euro}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal * euro}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " euro";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " euro";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0020000000" && lot.lotbasecurrency == "0010000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice / usd * euro}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal / usd * euro}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " euro";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " euro";
                                }, 1000);
                            </script>
                        </#if>
                        <#if currency == "0020000000" && lot.lotbasecurrency == "0020000000">
                            <script>
                                var x = setInterval(function () {
                                    var now = new Date().getTime();
                                    var distance = new Date("${lot.lotexpiringdatetime}").getTime() - now;
                                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                                    var total = ("${lot.lottotalbestprice}");
                                    var unit = ("${lot.lottotalbestprice / lot.lotunittotal}");

                                    document.getElementById("${lot.id}").innerHTML = days + "д " + hours + "г " + minutes + "х " + seconds + "с ";
                                    document.getElementById("${lot.id+1000000000000}").innerHTML = unit + " euro";
                                    document.getElementById("${lot.id+1000000000000000000000}").innerHTML = total + " euro";
                                }, 1000);
                            </script>
                        </#if>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbasecurrency == "0000000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >Гривня</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbasecurrency == "0010000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >USD</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbasecurrency == "0020000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >Euro</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotdelivery == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-1">
                        Доставка: <span class="lot-characteristic" >самовивіз</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotdelivery == "0000000010">
                    <div class="lot-characteristic-name" id="adminpanel-1">
                        Доставка: <span class="lot-characteristic" >перевізник</span>
                    </div>
                </#if>

                <div class="lot-characteristic-name">
                    Категорія лота: <span class="lot-characteristic" >${lot.lotcategory}</span>
                </div>


                <div class="lot-characteristic-name">Вартість лота:
                    <span class="lot-characteristic-datetime" id="${lot.id+1000000000000000000000}">update</span>
                </div>

                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name-long" id="lotbasecurrency">
                        Автор ПІБ: <span class="lot-characteristic" >${lot.lotauthoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>

                <div class="lot-characteristic-name">
                    Одиниць товару: <span class="lot-characteristic" >${lot.lotunittotal} шт</span>
                </div>

                <#if currency == "0000000000">
                    <div class="lot-characteristic-name">Вартість одиниці:
                        <span class="lot-characteristic-datetime" id="${lot.id+1000000000000}">update</span>
                    </div>
                </#if>
                <#if currency == "0010000000">
                    <div class="lot-characteristic-name">Вартість одиниці:
                        <span class="lot-characteristic-datetime" id="${lot.id+1000000000000}">update</span>
                    </div>
                </#if>
                <#if currency == "0020000000">
                    <div class="lot-characteristic-name">Вартість одиниці:
                        <span class="lot-characteristic-datetime" id="${lot.id+1000000000000}">update</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel">
                        Телефон: <span class="lot-characteristic" >${lot.lotauthoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-1">
                        Email: <span class="lot-characteristic" >${lot.lotauthoruseremail}</span>
                    </div>
                </#if>
                <#if lot.lotmeasure == "0000000000">
                    <div class="lot-characteristic-name">
                        Загална вага лота: <span class="lot-characteristic" >${lot.lotmeasuretotal} кг</span>
                    </div>
                </#if>
                <#if lot.lotmeasure == "0001000000">
                    <div class="lot-characteristic-name">
                        Загальний обьєм лота: <span class="lot-characteristic" >${lot.lotmeasuretotal} л</span>
                    </div>
                </#if>
                <#if lot.lottype == "0000000000">
                    <div class="lot-characteristic-name">
                        Тип операції: <span class="lot-characteristic" >купівля</span>
                    </div>
                </#if>
                <#if lot.lottype == "0100000000">
                    <div class="lot-characteristic-name">
                        Тип операції: <span class="lot-characteristic" >продаж</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція ПІБ: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet1authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet2authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet3authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet4authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet5authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet6authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet7authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet8authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name-long" id="adminpanel">
                        Краща пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet9authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet1authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet2authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet3authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet4authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet5authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet6authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet7authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet8authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet9authoruserphone}</span>
                    </div>
                </#if>
                <#if lot.filename??>
                    <div class="picture">
                        <div class="card-img">
                            <img src="/img/${lot.filename}" class="card-img" />
                        </div>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "main" || adminpanelmainhomepersonaloffice == "home" || adminpanelmainhomepersonaloffice == "personaloffice">
                    <div class="lot-characteristic-name-height" id="lotdescription">
                        Опис лота: <span class="lot-characteristic" id="lotdescription-in">${lot.lotdescription}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name-height" id="lotdescription-1">
                        Опис лота: <span class="lot-characteristic" id="lotdescription-in">${lot.lotdescription}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet1authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet2authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet3authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet4authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet5authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet6authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet7authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet8authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet9authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${(lot.lotbet9authoruserlastnamefirstnamepatronymic)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet1authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet2authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet3authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet4authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet7authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet6authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet7authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Друга пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet8authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${(lot.lotbet9authoruserphone)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet1authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet2authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet3authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet4authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet5authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet6authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet7authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet8authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${(lot.lotbet9authoruseremail)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet1authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet2authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet3authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet4authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet5authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet6authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet7authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet8authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${(lot.lotbet8authoruserlastnamefirstnamepatronymic)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${(lot.lotbet9authoruserlastnamefirstnamepatronymic)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet1authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet2authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet3authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet4authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet5authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet6authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name-long" id="adminpanel-2">
                        Третя пропозиція Автор ПІБ: <span class="lot-characteristic" >${lot.lotbet7authoruserlastnamefirstnamepatronymic}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        Телефон: <span class="lot-characteristic" >${(lot.lotbet8authoruserphone)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${(lot.lotbet9authoruserphone)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet1authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet2authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet3authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet4authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet5authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet6authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Телефон: <span class="lot-characteristic" >${lot.lotbet7authoruserphone}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000000">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >null</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000001">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${(lot.lotbet8authoruseremail)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000002">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${(lot.lotbet9authoruseremail)!"null"}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000003">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet1authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000004">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet2authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000005">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet3authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000006">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet4authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000007">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet5authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000008">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet6authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel" && lot.lotbetactive == "0000000009">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        Email: <span class="lot-characteristic" >${lot.lotbet7authoruseremail}</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        1: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        2: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        3: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        4: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        5: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        6: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-3">
                        7: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice == "adminpanel">
                    <div class="lot-characteristic-name" id="adminpanel-2">
                        8: <span class="lot-characteristic" >5555555555</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice != "adminpanel" && lot.lotbasecurrency == "0000000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >Гривня</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice != "adminpanel" && lot.lotbasecurrency == "0010000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >USD</span>
                    </div>
                </#if>
                <#if adminpanelmainhomepersonaloffice != "adminpanel" && lot.lotbasecurrency == "0020000000">
                    <div class="lot-characteristic-name" id="lotbasecurrency">
                        Базова валюта лота: <span class="lot-characteristic" >Euro</span>
                    </div>
                </#if>
                <#if currency == "0000000000">
                    <#if (isUser && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isAdmin && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isCreator && (adminpanelmainhomepersonaloffice != "adminpanel"))>
                    <#--<form action="https://www.liqpay.ua/api/3/checkout" method="post" accept-charset="utf-8>-->
                        <form action="/main/uah/lotbet/test" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="id" value="${lot.id}" />
                            <input type="hidden" name="data" value="eyAidmVyc2lvbiIgOiAzLCAicHVibGljX2tleSIgOiAieW91cl9wdWJsaWNfa2V5IiwgImFjdGlvbiIgOiAicGF5IiwgImFtb3VudCIgOiAxLCAiY3VycmVuY3kiIDogIlVTRCIsICJkZXNjcmlwdGlvbiIgOiAiZGVzY3JpcHRpb24gdGV4dCIsICJvcmRlcl9pZCIgOiAib3JkZXJfaWRfMSIgfQ=="/>
                            <input type="hidden" name="signature" value="QvJD5u9Fg55PCx/Hdz6lzWtYwcI="/>

                            <div class="lotbet-form">
                                <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                    <input type="text"
                                           class="lotbet-input-form"
                                           required autocomplete="off"
                                           pattern="\d+(\.\d{2})?"
                                           name="lotbet"
                                           placeholder="Введіть сумму за яку Ви готові придбати лот" />Гривень
                            </div>
                            <div>
                                <input type="submit" class="button" id="lotbet-button" value="ЗРОБИТИ СТАВКУ"/>
                            </div>
                        </form>
                    </#if>
                </#if>
                <#if currency == "0010000000">
                    <#if (isUser && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isAdmin && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isCreator && (adminpanelmainhomepersonaloffice != "adminpanel"))>
                    <#--<form action="https://www.liqpay.ua/api/3/checkout" method="post" accept-charset="utf-8>-->
                        <form action="/main/usd/lotbet/test" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="id" value="${lot.id}" />
                            <input type="hidden" name="data" value="eyAidmVyc2lvbiIgOiAzLCAicHVibGljX2tleSIgOiAieW91cl9wdWJsaWNfa2V5IiwgImFjdGlvbiIgOiAicGF5IiwgImFtb3VudCIgOiAxLCAiY3VycmVuY3kiIDogIlVTRCIsICJkZXNjcmlwdGlvbiIgOiAiZGVzY3JpcHRpb24gdGV4dCIsICJvcmRlcl9pZCIgOiAib3JkZXJfaWRfMSIgfQ=="/>
                            <input type="hidden" name="signature" value="QvJD5u9Fg55PCx/Hdz6lzWtYwcI="/>

                            <div class="lotbet-form">
                                <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                <input type="text"
                                       class="lotbet-input-form"
                                       required autocomplete="off"
                                       pattern="\d+(\.\d{2})?"
                                       name="lotbet"
                                       placeholder="Введіть сумму за яку Ви готові придбати лот" />USD
                            </div>
                            <div>
                                <input type="submit" class="button" id="lotbet-button" value="ЗРОБИТИ СТАВКУ"/>
                            </div>
                        </form>
                    </#if>
                </#if>
                 <#if currency == "0020000000">
                     <#if (isUser && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isAdmin && (adminpanelmainhomepersonaloffice != "adminpanel")) || (isCreator && (adminpanelmainhomepersonaloffice != "adminpanel"))>
                     <#--<form action="https://www.liqpay.ua/api/3/checkout" method="post" accept-charset="utf-8>-->
                        <form action="/main/euro/lotbet/test" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="id" value="${lot.id}" />
                            <input type="hidden" name="data" value="eyAidmVyc2lvbiIgOiAzLCAicHVibGljX2tleSIgOiAieW91cl9wdWJsaWNfa2V5IiwgImFjdGlvbiIgOiAicGF5IiwgImFtb3VudCIgOiAxLCAiY3VycmVuY3kiIDogIlVTRCIsICJkZXNjcmlwdGlvbiIgOiAiZGVzY3JpcHRpb24gdGV4dCIsICJvcmRlcl9pZCIgOiAib3JkZXJfaWRfMSIgfQ=="/>
                            <input type="hidden" name="signature" value="QvJD5u9Fg55PCx/Hdz6lzWtYwcI="/>

                            <div class="lotbet-form">
                                <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                <input type="text"
                                       class="lotbet-input-form"
                                       required autocomplete="off"
                                       pattern="\d+(\.\d{2})?"
                                       name="lotbet"
                                       placeholder="Введіть сумму за яку Ви готові придбати лот" />Euro
                            </div>
                            <div>
                                <input type="submit" class="button" id="lotbet-button" value="ЗРОБИТИ СТАВКУ"/>
                            </div>
                        </form>
                     </#if>
                 </#if>
                <#if currency == "0010000000" && adminpanelmainhomepersonaloffice == "home">
                    <form >
                        <div class="lotbet-form">
                            <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                <input type="text"
                                       readonly
                                       readonly="readonly"
                                       class="lotbet-input-form"
                                       required autocomplete="off"
                                       pattern="[0-9]{1,9}"
                                       name="lotbet"
                                        <#if currency == "0000000000">
                                           placeholder="Будь ласка, зареєструйтесь..." />Гривень
                                        </#if>
                                        <#if currency == "0010000000">
                                           placeholder="Будь ласка, зареєструйтесь..." />USD
                                        </#if>
                                        <#if currency == "0020000000">
                                            placeholder="Будь ласка, зареєструйтесь..." />Euro
                                        </#if>
                        </div>
                        <div class="button-no-user" id="lotbet-button-no-user">
                            ЗРОБИТИ СТАВКУ
                        </div>
                    </form>
                </#if>
                <#if currency == "0000000000" && adminpanelmainhomepersonaloffice == "home">
                    <form >
                        <div class="lotbet-form">
                            <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                <input type="text"
                                       readonly
                                       readonly="readonly"
                                       class="lotbet-input-form"
                                       required autocomplete="off"
                                       pattern="[0-9]{1,9}"
                                       name="lotbet"
                                       placeholder="Будь ласка, зареєструйтесь..." />Гривень
                        </div>
                        <div class="button-no-user" id="lotbet-button-no-user">
                            ЗРОБИТИ СТАВКУ
                        </div>
                    </form>
                </#if>
                <#if currency == "0010000000" && adminpanelmainhomepersonaloffice == "home">
                    <form >
                        <div class="lotbet-form">
                            <label class="lotbet-label">Ваша пропозиція по "Вартості лота":</label>
                                <input type="text"
                                       readonly="readonly"
                                       class="lotbet-input-form"
                                       required autocomplete="off"
                                       pattern="[0-9]{1,9}"
                                       name="lotbet"
                                        <#if currency == "0000000000">
                                           placeholder="Будь ласка, зареєструйтесь..." />Гривень
                                        </#if>
                                        <#if currency == "0010000000">
                                           placeholder="Будь ласка, зареєструйтесь..." />USD
                                        </#if>
                                        <#if currency == "0020000000">
                                            placeholder="Будь ласка, зареєструйтесь..." />Euro
                                        </#if>
                        </div>
                        <div class="button-no-user" id="lotbet-button-no-user">
                            ЗРОБИТИ СТАВКУ
                        </div>
                    </form>
                </#if>
            </div>
        <#else >
            <div class="empty">

            </div>
            <div class="nolots">
                Лоти, що відповідають критеріям Вашого запиту - відсутні. Сформулюйте Ваш запит інакше.
            </div>
        </#list>
</div>

<div>
    <@pag.pagination url page />
</div>