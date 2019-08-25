<#include "../main-template.ftl"/>
    <html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<script>
    submitForms = function(){
        document.getElementById("form1").submit();
        document.getElementById("form2").submit();
    }
</script>

<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#macro content>
<#--    <@sf.form action="/sign_up" method="post" modelAttribute="address" id="form2">-->
<#--            <div class="form-row mb-4">-->
<#--            <@sf.label path="city">City</@sf.label>-->
<#--            <@sf.input path="city" type="text"/>-->
<#--            <@sf.errors path="city"/>-->
<#--        </div><div class="form-row mb-4">-->
<#--            <@sf.label path="street">Street</@sf.label>-->
<#--            <@sf.input path="street" type="text"/>-->
<#--            <@sf.errors path="street"/>-->
<#--        </div>-->
<#--    </@sf.form>-->
    <@sf.form action="/sign_up" class="text-center border border-light p-5" method="post" modelAttribute="user" id="form1">

        <div class="form-row mb-4">
            <@sf.label path="name">Name</@sf.label>
            <@sf.input path="name"/>
            <@sf.errors path="name"/>
        </div>
        <div>
            <@sf.label path="surname">Surname</@sf.label>
            <@sf.input path="surname"/>
            <@sf.errors path="surname"/>
        </div>
        <div >
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email" type="email"/>
            <@sf.errors path="email"/>
        </div>
        <div class="form-row mb-4">
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" type="password"/>
            <@sf.errors path="password"/>
        </div>
        <div class="form-row mb-4">
            <@sf.label path="address.city">City</@sf.label>
            <@sf.input path="address.city" type="text"/>
            <@sf.errors path="address.city"/>
        </div><div class="form-row mb-4">
            <@sf.label path="address.street">Street</@sf.label>
            <@sf.input path="address.street" type="text"/>
            <@sf.errors path="address.street"/>
        </div>

        <input type="submit" class="btn btn-info my-4 btn-block" name="Authorize">

    </@sf.form>


</#macro>
</body>
    </html>
<@main title="Sign up"/>