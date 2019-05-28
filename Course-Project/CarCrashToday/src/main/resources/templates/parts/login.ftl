<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Имя пользователя:</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="username" placeholder="Имя пользователя"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="password" placeholder="Пароль"/>
            </div>
        </div>
        <#if isRegisterForm>
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Электронная почта:</label>
            <div class="col-sm-5">
                <input class="form-control" type="email" name="email" placeholder="E-mail"/>
            </div>
        </div>
        </#if>
        <div><input type="hidden" name="_csrf" value="${_csrf.token}" /></div>
        <#if !isRegisterForm>
            <a href="/registration">Регистрация</a>
        </#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>

    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit" >Выход</button>
    </form>

</#macro>