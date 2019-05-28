<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form class="form-inline" method="get" action="/index">
                <input class="form-control" type="text" name="filter" value="${filter?ifExists}" placeholder="Поиск по тэгу">
                <button type="submit" class="btn btn-primary ml-2">Найти</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary mb-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новость
    </a>
    <div>
        <div class="form-group">
            <form class="collapse" id="collapseExample" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input class="form-control" type="text" name="text" placeholder="Введите сообщение" />
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="tag" placeholder="Тэг">
                </div>
                <div class="custom-file">
                    <input type="file" name="file" id="customFile"/>
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button class="btn btn-primary mt-2" type="submit">Добавить</button>
            </form>
        </div>
    </div>

    <#list messages as message>
        <div class="card mb-3">
            <div <#if message.filename??>style="height: 10rem; overflow: hidden;"</#if>>
                <#if message.filename??>
                    <img class="card-img-top" src="/img/${message.filename}"  alt="Card image cap">
                </#if>
            </div>
            <div class="card-body" style="height: 10rem;">
                <h5 class="card-title">Card title//TODO</h5>
                <p class="card-text">${message.text}</p>
                <p class="card-text"><small class="text-muted">${message.tag}</i></small></p>
                <div>
                    <strong>${message.authorName} //TODO</strong>
                </div>
            </div>

        </div>
    <#else >
        No Messages
    </#list>

</@c.page>