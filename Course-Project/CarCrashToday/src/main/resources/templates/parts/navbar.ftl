<#include "security.ftl" >
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Car Crash Today</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/index">Новости</a>
            </li>
            <#if isAdmin || isModerator>
            <li class="nav-item active">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout/>
    </div>
</nav>