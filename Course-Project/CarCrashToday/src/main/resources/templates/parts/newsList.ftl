<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />
<#list page.content as message>
    <div class="card mb-3">
        <div <#if message.filename??>style="height: 10rem; overflow: hidden;"</#if>>
            <#if message.filename??>
                <img class="card-img-top" src="/img/${message.filename}"  alt="Card image cap">
            </#if>
        </div>
        <div class="card-body" style="height: 10rem;">
            <h5 class="card-title">Card title//TODO</h5>
            <p class="card-text">${message.text}</p><br/>

            <p class="card-text"><small class="text-muted">${message.tag}</i></small></p>

        </div>
        <div class="card-footer" align="right">
            <a href="/user_news/${message.author.id}">${message.authorName}//TODO</a>
            <#if message.author.id == currentUserId>
                <a class="btn btn-primary" href="/user_news/${message.author.id}?message=${message.id}">Редактировать</a>
            </#if>
        </div>
    </div>
<#else >
    No Messages
</#list>
<@p.pager url page />