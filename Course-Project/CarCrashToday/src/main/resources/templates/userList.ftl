<#import "parts/common.ftl" as c>
<@c.page>
    <div>
        <h4>Список пользователей</h4>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Има пользователя</th>
            <th scope="col">E-mail</th>
            <th scope="col">Роли</th>
            <th scope="col">Действия</th>
        </tr>
        </thead>
        <tbody>


        <#list users as user>
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><#list user.roles as user_role> ${user_role} <#sep>, </#list></td>
                <td><a href="/user/${user.id}">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>