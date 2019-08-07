<div class="basecurrencyvalue">
    <form action="/adminpanel/exchange" method="post" >
        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div class="exchange-form">
            <label class="exchange-label">USD:</label>
            <input type="text"
                   class="exchange-input-form"
                   required autocomplete="off"
                   pattern="([0-9]{1,3})+(.\[0-9]{2,5})?"
                   name="basecurrencyusdvalue"
                   value="${1 / usd}"
                   placeholder="Введіть кількість USD, що можливо придбати на 1 Гривню, за 'ринковим' курсом.(формат: 9.99999)" />
        </div>

        <div class="exchange-form">
            <label class="exchange-label">Euro:</label>
            <input type="text"
                   class="exchange-input-form"
                   required autocomplete="off"
                   pattern="([0-9]{1,3})+(.\[0-9]{2,5})?"
                   name="basecurrencyeurovalue"
                   value="${1 / euro}"
                   placeholder="Введіть кількість Euro, що можливо придбати на 1 Гривню, за 'ринковим' курсом.(формат: 9.99999)" />
        </div>

        <div><input type="submit" class="button" value="Оновити поточний - контрольний, для ресурса glassgateua.com, курс гривні до іноземних валют" /></div>
    </form>
</div>