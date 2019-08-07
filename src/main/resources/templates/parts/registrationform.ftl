<#macro registration path>
    <div class="registration-form-style">
        <form id="form" action="${path}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <div class="registration-form">
                <label class="registration-label">Логін:</label>
                    <input type="text"
                           class="registration-input-form"
                           required autocomplete="off"
                           pattern="[0-9 A-Za-zА-Яа-яЁёЄєҐґІіЇї']{2,50}"
                           name="username"
                           <#--value="Richard"-->
                           placeholder="Введіть нікнейм для доступа на сайт." />
            </div>

            <div class="registration-form">
                <label class="registration-label">Пароль:</label>
                <input type="password"
                       class="registration-input-form"
                       id="pass-input-1"
                       required autocomplete="off"
                       pattern="(?=^.{8,255}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                       name="password"
                       <#--value="Qq123456"-->
                       placeholder="Мова вводу - англійська, розмір - від 8 символів, з них: мінімум 1 цифра, 1 маленка літера, 1 велика літера." />
            <#--</div>-->

            <#--<div class="registration-form">-->
                <label class="registration-label">Повторіть:</label>
                <input type="password"
                       class="registration-input-form"
                       id="pass-input-2"
                       required autocomplete="off"
                       pattern="(?=^.{8,255}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                       name="userconfirmpassword"
                       <#--value="Qq123456"-->
                       placeholder="Паролі мають збігатися."
                       onChange="checkPasswordMatch();" />
            </div>

            <div class="registration-form">
                <label class="registration-label">Прізвище:</label>
                <input type="text"
                       class="registration-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                       name="userlastname"
                       <#--value="Белл"-->
                       placeholder="Мова вводу - українська, Ваше справжнє прізвище." />
            </div>

            <div class="registration-form">
                <label class="registration-label">Ім'я:</label>
                <input type="text"
                       class="registration-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                       name="userfirstname"
                       <#--value="Річард"-->
                       placeholder="Мова вводу - українська, Ваше справжнє ім'я." />
            </div>

            <div class="registration-form">
                <label class="registration-label">По батькові:</label>
                <input type="text"
                       class="registration-input-form"
                       required autocomplete="off"
                       pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                       name="userpatronymic"
                       <#--value="Джозефович"-->
                       placeholder="Мова вводу - українська, Ваше справжнє по батькові." />
            </div>

            <div class="registration-form">
                <label class="registration-label">Телефон:</label>
                <input type="text"
                       class="registration-input-form"
                       id="phone-input"
                       required autocomplete="off"
                       pattern="[\+][3][8][0][6][7]\d{7}|[\+][3][8][0][9][6]\d{7}|[\+][3][8][0][9][7]\d{7}|[\+][3][8][0][9][8]\d{7}|[\+][3][8][0][5][0]\d{7}|[\+][3][8][0][6][6]\d{7}|[\+][3][8][0][9][5]\d{7}|[\+][3][8][0][9][9]\d{7}|[\+][3][8][0][6][3]\d{7}|[\+][3][8][0][7][3]\d{7}|[\+][3][8][0][9][3]\d{7}"
                       name="userphone"
                       <#--value="+380958335625"-->
                       placeholder="Ваш дійсний мобільний номер в форматі +380ХХХХХХХХХ" />
            <#--</div>-->

            <#--<div class="registration-form">-->
                <label class="registration-label">Email:</label>
                <input type="text"
                       class="registration-input-form"
                       id="email-input"
                       required autocomplete="off"
                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                       name="useremail"
                       <#--value="actio2016@gmail.com"-->
                       placeholder="Ваша актуальна електронна скринька в форматі some@some.com" />
            </div>

            <label><input type="submit" id="button" value="Зареєструватися" /></label>
        </form>
    </div>
</#macro>