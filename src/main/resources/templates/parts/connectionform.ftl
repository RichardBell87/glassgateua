<#include "security.ftl">
<#macro connection path>
    <div class="connection">
        <form action="/connection" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <div class="connection-form">
                <label class="connection-label">Ім'я:</label>
                <input type="text"
                       class="connection-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                       name="connectionuserfirstname"
                       value="${userfirstname}"
                       placeholder="Мова вводу - українська, Ваше справжнє ім'я." />
            </div>

            <div class="connection-form">
                <label class="connection-label">По батькові:</label>
                <input type="text"
                       class="connection-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                       name="connectionuserpatronymic"
                       value="${userpatronymic}"
                       placeholder="Мова вводу - українська, Ваше справжнє по батькові." />
            </div>

            <div class="connection-form">
                <label class="connection-label">Телефон:</label>
                <input type="text"
                       class="connection-input-form"
                       id="phone-input"
                       required autocomplete="off"
                       pattern="[\+][3][8][0][6][7]\d{7}|[\+][3][8][0][9][6]\d{7}|[\+][3][8][0][9][7]\d{7}|[\+][3][8][0][9][8]\d{7}|[\+][3][8][0][5][0]\d{7}|[\+][3][8][0][6][6]\d{7}|[\+][3][8][0][9][5]\d{7}|[\+][3][8][0][9][9]\d{7}|[\+][3][8][0][6][3]\d{7}|[\+][3][8][0][7][3]\d{7}|[\+][3][8][0][9][3]\d{7}"
                       name="connectionuserphone"
                       value="${userphone}"
                       placeholder="Ваш дійсний мобільний номер в форматі +380ХХХХХХХХХ" />
            <#--</div>-->

            <#--<div class="registration-form">-->
                <label class="connection-label">Email:</label>
                <input type="text"
                       class="connection-input-form"
                       id="email-input"
                       required autocomplete="off"
                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                       name="connectionuseremail"
                       value="${useremail}"
                       placeholder="Ваша актуальна електронна скринька в форматі some@some.com" />
            </div>

            <div class="connection-form">
                <label class="connection-label">Тема запиту:</label>
                <input type="text"
                       class="connection-input-form"
                <#--required autocomplete="off"-->
                <#--pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"-->
                       name="connectioncategory"
                       value="Неналежна робота сервіса..."/>
            </div>

            <div class="connection-form">
                <label class="connection-label-description">Ваш запит:</label>
                <textarea required aria-autocomplete="off"
                          class="connection-input-form-description"
                          id="connection-description"
                          minlength="16"
                          maxlength="2048"
                          spellcheck="false"
                          name="connectiondescription"></textarea>
                <img id="advance" src="#" />
            </div>

            <div class="connection-form">
                <label class="connection-label">Графічний файл:</label>
                <input type="file"
                       class="connection-input-form"
                       id="connection-image"
                <#--required autocomplete="off"-->
                       accept="image/*"
                       name="file"
                       placeholder="Введіть зображення (максимальний розмір <= 1MB)" />
            </div>

            <script  src="/static/js/advance.js"></script>

            <label><input type="submit" class="button" value="Надіслати запит"/></label>
        </form>
    </div>
</#macro>