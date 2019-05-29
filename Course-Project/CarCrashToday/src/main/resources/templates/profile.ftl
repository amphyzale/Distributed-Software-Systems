<#import "parts/common.ftl" as c>

<@c.page>
    <h5>${username}</h5>
    ${message?ifExists}
    <form method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Имя пользователя:</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="username" placeholder="Имя пользователя" value="${username}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="password" placeholder="Пароль"/>
            </div>
        </div>
            <div class="form-group">
                <label class="col-sm-2 col-form-label">Электронная почта:</label>
                <div class="col-sm-5">
                    <input class="form-control" type="email" name="email" placeholder="E-mail" value="${email}"/>
                </div>
            </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>