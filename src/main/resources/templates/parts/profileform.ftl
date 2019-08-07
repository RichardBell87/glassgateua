<form method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group row mt-3">
        <label class="col-sm-2 col-form-label">Пароль:</label>
        <div class="col-sm-10">
            <input type="password"
                   required autocomplete="off"
                   pattern="(?=^.{8,255}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                   name="password"
                   class="form-control"
                   placeholder="Мова вводу - англійська, розмір - від 8 символів, з них: мінімум 1 цифра, 1 маленка літера, 1 велика літера."
                   value="${password!''}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Прізвище:</label>
        <div class="col-sm-10">
            <input type="text"
                   required autocomplete="off"
                   pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                   name="userlastname"
                   class="form-control"
                   placeholder="Мова вводу - українська, Ваше справжнє прізвище."
                   value="${userlastname!''}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ім'я:</label>
        <div class="col-sm-10">
            <input type="text"
                   required autocomplete="off"
                   pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                   name="userfirstname"
                   class="form-control"
                   placeholder="Мова вводу - українська, Ваше справжнє ім'я."
                   value="${userfirstname!''}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">По батькові:</label>
        <div class="col-sm-10">
            <input type="text"
                   required autocomplete="off"
                   pattern="(?=^.{2,50}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                   name="userpatronymic"
                   class="form-control"
                   placeholder="Мова вводу - українська, Ваше справжнє по батькові."
                   value="${userpatronymic!''}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Мобільний телефон:</label>
        <div class="col-sm-10">
            <input type="text"
                   required autocomplete="off"
                   pattern="[\+][3][8][0][6][7]\d{7}|[\+][3][8][0][9][6]\d{7}|[\+][3][8][0][9][7]\d{7}|[\+][3][8][0][9][8]\d{7}|[\+][3][8][0][5][0]\d{7}|[\+][3][8][0][6][6]\d{7}|[\+][3][8][0][9][5]\d{7}|[\+][3][8][0][9][9]\d{7}|[\+][3][8][0][6][3]\d{7}|[\+][3][8][0][7][3]\d{7}|[\+][3][8][0][9][3]\d{7}"
                   name="userphone"
                   class="form-control"
                   placeholder="Ваш дійсний мобільний номер в форматі +380ХХХХХХХХХ"
                   value="${userphone!''}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-10">
            <input type="text"
                   required autocomplete="off"
                   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                   name="useremail"
                   class="form-control"
                   placeholder="Ваша актуальна електронна скринька в форматі some@some.com"
                   value="${email!''}"/>
        </div>
    </div>
    <#--<div class="form-group row">-->
        <#--<label class="col-sm-2 col-form-label">Номер Вашої карти:</label>-->
        <#--<div class="col-sm-10">-->
            <#--<input type="text"-->
                   <#--required autocomplete="off"-->
                   <#--pattern="[4-5][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"-->
                   <#--name="usercardnumber"-->
                   <#--class="form-control"-->
                   <#--placeholder="Введіть 16 цифр. Приймаються банківськи карти Visa або MasterCard."-->
                   <#--value="${usercardnumber!''}"/>-->
        <#--</div>-->
    <#--</div>-->
    <#--<div class="form-group row">-->
        <#--<label class="col-sm-2 col-form-label">Термін дії карти:</label>-->
        <#--<div class="col-5">-->
            <#--<input type="text"-->
                   <#--required autocomplete="off"-->
                   <#--pattern="[0][1-9]|[1][0-2]"-->
                   <#--name="usercardexpirationdatemonth"-->
                   <#--class="form-control"-->
                   <#--placeholder="місяць в форматі ХХ"-->
                   <#--value="${usercardexpirationdatemonth!''}"/>-->
        <#--</div>-->
        <#--<div class="col-5">-->
            <#--<input type="text"-->
                   <#--required autocomplete="off"-->
                   <#--pattern="[1][9]|[2][0-9]"-->
                   <#--name="usercardexpirationdateyear"-->
                   <#--class="form-control"-->
                   <#--placeholder="рік в форматі ХХ"-->
                   <#--value="${usercardexpirationdateyear!''}"/>-->
        <#--</div>-->
    <#--</div>-->
    <#--<div class="form-group row">-->
        <#--<label class="col-sm-2 col-form-label">CVV/CVC код карти:</label>-->
        <#--<div class="col-sm-10">-->
            <#--<input type="text"-->
                   <#--required autocomplete="off"-->
                   <#--pattern="[0-9][0-9][0-9]"-->
                   <#--name="usercardcvv2cvc2code"-->
                   <#--class="form-control"-->
                   <#--placeholder="Введіть 3 цифри."-->
                   <#--value="${usercardcvv2cvc2code!''}"/>-->
        <#--</div>-->
    <#--</div>-->
    <div><input type="submit" class="btn btn-primary" value="Зберегти"/></div>
</form>