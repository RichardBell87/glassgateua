<#macro login path>
    <div class="login-form-style">
        <form action="${path}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <div class="login-form">
                <label class="login-label">Логін:</label>
                <#--<input type="text"-->
                       <#--class="login-label-->
                       <#--required autocomplete="off"-->
                       <#--pattern="[0-9 A-Za-zА-Яа-яЁёЄєҐґІіЇї']{2,50}"-->
                       <#--name="username"-->
                       <#--value="Логін:"-->
                       <#--placeholder="Логін:" />-->
                <input type="text"
                       class="login-input-form"
                       required autocomplete="off"
                       pattern="[0-9 A-Za-zА-Яа-яЁёЄєҐґІіЇї']{2,50}"
                       name="username"
                       <#--value="Richard"-->
                       placeholder="Введіть нікнейм для доступа на сайт." />
            </div>

            <div class="login-form">
                <label class="login-label">Пароль:</label>
                <input type="password"
                       class="login-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{8,255}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                       name="password"
                       <#--value="Qq123456"-->
                       placeholder="Введіть пароль для доступа на сайт." />
            </div>

            <label><input type="submit" id="button" value="Увійти" /></label>
        </form>
    </div>
</#macro>

<#macro logout path>
    <div class="logout-form">
        <form action="/glass_gate_ua_logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <label><input type="submit" id="button-logout" value="Вийти"/></label>
        </form>
    </div>
</#macro>