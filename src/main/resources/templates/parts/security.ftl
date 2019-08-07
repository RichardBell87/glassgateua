<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    userfirstname = user.getUserfirstname()
    userpatronymic = user.getUserpatronymic()
    userphone = user.getUserphone()
    useremail = user.getUseremail()

    isUser = user.isUser()
    isAdmin = user.isAdmin()
    isCreator = user.isCreator()
    >
<#else>
    <#assign
    name = "Гість"
    userfirstname = "Мова вводу - українська, Ваше справжнє ім'я."
    userpatronymic = "Мова вводу - українська, Ваше справжнє по батькові.."
    userphone = "Ваш дійсний мобільний номер в форматі +380ХХХХХХХХХ"
    useremail = "Ваша актуальна електронна скринька в форматі some@some.com"

    isUser = false
    isAdmin = false
    isCreator = false
    >
</#if>