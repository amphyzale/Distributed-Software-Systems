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
    <a class="btn btn-primary mb-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">Предложить новость</a>
    <#include "parts/messageEdit.ftl" />

    <#include 'parts/newsList.ftl' />

</@c.page>