<div class="lotcreated">
    <form action="/lotcreated" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div class="lotcreated-radio-form">
            <label class="lotcreated-radio-label">Тип лота:</label>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   checked="checked"
                   required autocomplete="off"
                   pattern="[0][0][0][0][0][0][0][0][0][0]"
                   name="lottype"
                   value="0000000000"><a id="lotbasecurrency">Купівля</a>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   required autocomplete="off"
                   pattern="[0][1][0][0][0][0][0][0][0][0]"
                   name="lottype"
                   value="0100000000"><a id="lotbasecurrency">Продаж</a>
        <#--</div>-->

        <#--<div class="lotcreated-radio-form">-->
            <label class="lotcreated-radio-label">Доставка:</label>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   checked="checked"
                   required autocomplete="off"
                   pattern="[0][0][0][0][0][0][0][0][0][0]"
                   name="lotdelivery"
                   value="0000000000"><a id="lotbasecurrency">Самовивіз</a>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   required autocomplete="off"
                   pattern="[0][1][0][0][0][0][0][0][0][0]"
                   name="lotdelivery"
                   value="0100000000"><a id="lotbasecurrency">Перевізник</a>
        </div>

        <div class="lotcreated-form">
            <label class="lotcreated-label">Категорія:</label>
            <input type="text"
                   class="lotcreated-input-form"
                   required autocomplete="off"
                   pattern="(?=^.{2,16}$)((?=.*\W+)|(?![.\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*"
                   name="lotcategory"
                   <#--value="Кава"-->
                   placeholder="Наприклад: Кава, Олія, тощо...(мова вводу - українська, з Великої літери)" />
        </div>

        <div class="lotcreated-form">
            <label class="lotcreated-label">Зображення лота:</label>
            <input type="file"
                   class="lotcreated-input-form"
                   id="lotcreated-image"
                   required autocomplete="off"
                   accept="image/*"
                   name="file"
                   placeholder="Введіть зображення лота(максимальний розмір <= 1MB)" />
        </div>

    <#--<form id="form1" runat="server">-->
    <#--<input type='file' id="imgInp" />-->
    <#--<img id="blah" src="#" alt="your image" />-->
    <#--</form>-->
    <#--<script>-->
    <#--function readURL(input) {-->
    <#--if (input.files && input.files[0]) {-->
    <#--var reader = new FileReader();-->

    <#--reader.onload = function (e) {-->
    <#--$('#blah').attr('src', e.target.result);-->
    <#--}-->

    <#--reader.readAsDataURL(input.files[0]);-->
    <#--}-->
    <#--}-->

    <#--$("#imgInp").change(function(){-->
    <#--readURL(this);-->
    <#--});-->
    <#--</script>-->

        <div class="lotcreated-form-description">
            <label class="lotcreated-label-description">Опис лота:</label>
            <textarea required aria-autocomplete="off"
                      class="lotcreated-input-form"
                      id="lotcreated-description"
                      minlength="16"
                      maxlength="2048"
                      spellcheck="false"
                      name="lotdescription"
                      placeholder="Введіть опис лота">Опишіть основні характеристики товару(наприклад: мінімальник гарантійний термін, фасовка, оригінал/репліка, тощо...)</textarea>
        </div>

        <div class="lotcreated-form" id="up">
            <label class="lotcreated-label">Кількіст одиниць товару:</label>
            <input type="number"
                   min="1"
                   max="1000000"
                   step="1"
                   class="lotcreated-input-form"
                   required autocomplete="off"
                   pattern="\d{1,9}"
                   name="lotunittotal"
                   <#--value="100"-->
                   placeholder="Введіть кількість одиниць товару.(в штуках - кількість пачок, або пляшок,)" />
        </div>

        <div class="lotcreated-radio-form">
            <label class="lotcreated-radio-label">Базова одиниця виміру (БО):</label>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   checked="checked"
                   required autocomplete="off"
                   pattern="[0][0][0][0][0][0][0][0][0][0]"
                   name="lotmeasure"
                   value="0000000000"><a id="lotbasecurrency">Кілограм</a>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   required autocomplete="off"
                   pattern="[0][0][0][1][0][0][0][0][0][0]"
                   name="lotmeasure"
                   value="0001000000"><a id="lotbasecurrency">Літр</a>
        <#--</div>-->

        <#--<div class="lotcreated-form">-->
            <label class="lotcreated-label-3">Кількість одиниць товару в БО:</label>
            <input type="number"
                   min="1"
                   max="1001"
                   step="0.001"
                   class="lotcreated-input-form"
                   required autocomplete="off"
                   pattern="\d{1,9}+(,\d{0,3})?|\d{1,9}+(.\d{0,3})?"
                   name="lotmeasuretotal"
                   <#--value="50"-->
                   placeholder="Загальна вага чи об'єм" />
        </div>

        <div class="lotcreated-radio-form-1">
            <label class="lotcreated-radio-label">Базова валюта:</label>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   checked="checked"
                   required autocomplete="off"
                   pattern="[0][0][0][0][0][0][0][0][0][0]"
                   name="lotbasecurrency"
                   value="0000000000"><a id="lotbasecurrency">Гривня</a>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   required autocomplete="off"
                   pattern="[0][0][1][0][0][0][0][0][0][0]"
                   name="lotbasecurrency"
                   value="0010000000"><a id="lotbasecurrency">Долар США</a>
            <input type="radio"
                   class="lotcreated-radio-input-form"
                   required autocomplete="off"
                   pattern="[0][0][2][0][0][0][0][0][0][0]"
                   name="lotbasecurrency"
                   value="0020000000"><a id="lotbasecurrency">Євро</a>
        <#--</div>-->

        <#--<div class="lotcreated-form">-->
            <label class="lotcreated-label-1">Вартість одиниці товару:</label>
            <input type="number"
                   min="1"
                   max="1000000"
                   step="0.01"
                   required autocomplete="off"
                   pattern="\d+(\.\d{2})?"
                   name="lotunitprice"
                   class="lotcreated-input-form"
                   <#--value="2.00"-->
                   placeholder="Максимальна вартість одиниці товару" />
        </div>

        <div class="lotcreated-form-1">
            <label class="lotcreated-label">Кінцева дата актуальності лота:</label>
            <input type="date"
                   min="2019-07-17"
                   max="2020-07-16"
                   class="lotcreated-input-form"
                   required autocomplete="off"
            <#--pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[2][0][1][9]|(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[2][0][2][0-9]"-->
                   name="lotexpiringdate"
                   <#--value="10.07.2019"-->
                   placeholder="Введіть кінцеву дату актуальності лота" />
        <#--</div>-->

        <#--<div class="lotcreated-form-2">-->
            <label class="lotcreated-label">Кінцевий час актуальності лота:</label>
            <input type="time"
                   class="lotcreated-input-form"
                   required autocomplete="off"
            <#--pattern="(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])"-->
                   name="lotexpiringtime"
                   <#--value="16:00"-->
                   placeholder="Введіть кінцевий час актуальності лота" />
        </div>

        <div><input type="submit" class="button" value="Додати лот"/></div>
    </form>
</div>