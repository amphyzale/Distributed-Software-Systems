<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />
<#list page.content as message>
    <div class="card mb-3 w-100">
        <div <#if message.filename??>style="height: 10rem; overflow: hidden;"</#if>>
            <#if message.filename??>
                <img class="card-img-top" src="/img/${message.filename}"  alt="Card image cap">
            </#if>
        </div>
        <div class="card-body" >
            <h5 class="card-title">${message.title}</h5>
            <p class="card-text">${message.text}</p>

            <div class="row">
                <div class="card ml-4" >
                    <div class="card-body">
                        <h5 class="card-title">Участник ДТП</h5>
                        <table class="table table-borderless">
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td colspan="2">Гос. номер/Регистрационный знак:</td>
                                <td>${message.car1.regNum}</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td colspan="2">Марка:</td>
                                <td>${message.car1.car_brandOfCar.name}</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td colspan="2">Модель:</td>
                                <td>${message.car1.car_modelOfCar.name}</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td colspan="2">Тип кузова:</td>
                                <td>${message.car1.typeOfBody.name}</td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td colspan="2">Вид транспорта:</td>
                                <td>${message.car1.typeOfTransport.name}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <#if message.car2??>
                    <div class="card ml-4" >
                        <div class="card-body">
                            <h5 class="card-title">Участник ДТП</h5>
                            <table class="table table-borderless">
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td colspan="2">Гос. номер/Регистрационный знак:</td>
                                    <td>${message.car2.regNum}</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td colspan="2">Марка:</td>
                                    <td>${message.car2.car_brandOfCar.name}</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td colspan="2">Модель:</td>
                                    <td>${message.car2.car_modelOfCar.name}</td>
                                </tr>
                                <tr>
                                    <th scope="row">4</th>
                                    <td colspan="2">Тип кузова:</td>
                                    <td>${message.car2.typeOfBody.name}</td>
                                </tr>
                                <tr>
                                    <th scope="row">5</th>
                                    <td colspan="2">Вид транспорта:</td>
                                    <td>${message.car2.typeOfTransport.name}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </#if>

            </div>
            <h5 class="card-title">Место происшествия:</h5>
            <table class="table table-borderless">
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td colspan="2">Область:</td>
                    <td>${message.street1.city.region.name}</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td colspan="2">Город:</td>
                    <td>${message.street1.city.name}</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Улица:</td>
                    <td>${message.street1.name}</td>
                </tr>
                <#if message.street2??>
                    <tr>
                        <th scope="row">4</th>
                        <td colspan="2">Пересечение:</td>
                        <td>${message.street2.name}</td>
                    </tr>
                </#if>
                <tr>
                    <th scope="row"><#if !message.street2??>4<#else>5</#if></th>
                    <td colspan="2">Тип дорожного объекта:</td>
                    <td>${message.typeOfRoadObj.name}</td>
                </tr>
                </tbody>
            </table>

            <p class="card-date">Дата события: ${message.dateOfCrash}</p>
            <p class="card-text"><small class="text-muted">${message.tag}</i></small></p>

        </div>

        <div class="card-footer" align="right">
            Пользователь: <a href="/user_news/${message.author.id}">${message.authorName}</a>
            <#if message.author.id == currentUserId>
                <#if message.status.id != 3>
                    <a class="btn btn-primary" href="/user_news/${message.author.id}?message=${message.id}">Редактировать</a>
                    <#if message.status.id == 2>
                        <a class="btn btn-primary" href="/user_news/${message.author.id}">Опубликовать</a>
                    <#else >
                        <a class="btn btn-primary" href="/user_news/propose/${message.author.id}?message=${message.id}">Отправить</a>
                    </#if>
                </#if>
            </#if>
            <#if message.author.id == currentUserId>
                <div>
                    <small class="text-muted">Статус: ${message.status.name}</i></small>
                </div>
            </#if>
        </div>
    </div>
<#else >
    No Messages
</#list>
<@p.pager url page />