

<div class="collapse<#if message??>.show</#if>" id="collapseNews">
    <div class="form-group">
        <form method="post" enctype="multipart/form-data">

            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.title}</#if>" name="title" placeholder="Введите заголовок" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="date" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.dateOfCrash}</#if>" name="dateOfCrash" placeholder="Укажите дату и время" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseCar1" role="button"
                   aria-expanded="false" aria-controls="collapseCar1">
                    Участник 1
                </a>
            </p>
            <div class="collapse<#if message??>.show</#if> mb-2" id="collapseCar1">
                <div class="card card-body">
                    <div class="form-group">
                        <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                               value="<#if message??>${message.car1.regNum}</#if>" name="regNum1" placeholder="Регистрационный номер" />
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>

                    <div class="form-group">
                        <input type="hidden" value="" />
                        <select id="brand1" name="brandOfCar1" class="custom-select" data-live-search="true"
                                <#if !message??>onchange="openbox('model1',this)"</#if>>
                            <#if message??>
                                <option selected value="${message.car1.car_brandOfCar.id}" >${message.car1.car_brandOfCar.name}</option>
                            <#else>
                                <option disabled selected >Выберите марку...</option>
                            </#if>
                            <#list brands as brand>
                                <option value="${brand.id}" >${brand.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="model1" name="modelOfCar1" class="custom-select "  <#if !message??>disabled</#if>>
                            <#if message??>
                                <option selected value="${message.car1.car_modelOfCar.id}" >${message.car1.car_modelOfCar.name}</option>
                            <#else>
                                <option disabled selected>Выберите модель...</option>
                            </#if>
                            <#list models as model>
                                <option value="${model.id}" >${model.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="bodyType1" name="typeOfBody1" class="custom-select" >
                            <#if message??>
                                <option selected value="${message.car1.typeOfBody.id}">${message.car1.typeOfBody.name}</option>
                            <#else>
                                <option disabled selected>Выберите тип кузова...</option>
                            </#if>
                            <#list bodies as body>
                                <option value="${body.id}" >${body.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="typeOfCar1" name="typeOfTransport1" class="custom-select">
                            <#if message??>
                                <option selected value="${message.car1.typeOfTransport.id}">${message.car1.typeOfTransport.name}</option>
                            <#else>
                                <option disabled selected>Выберите тип транспорта...</option>
                            </#if>
                            <#list typeOfTransports as typeOfTransport>
                                <option value="${typeOfTransport.id}" >${typeOfTransport.name}</option>
                            </#list>
                        </select>
                    </div>

                </div>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseCar2"
                   role="button" aria-expanded="false" aria-controls="collapseCar2">
                    Участник 2 (если имеется)
                </a>
            </p>

            <div class="collapse<#if (message.car2.regNum)?has_content>.show<#else ></#if> mb-2" id="collapseCar2">
                <div class="card card-body">
                    <div class="form-group">
                        <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                               value="<#if (message.car2.regNum)?has_content>${message.car2.regNum}<#else></#if>"
                               name="regNum2" placeholder="Регистрационный номер" />
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>

                    <div class="form-group">
                        <select id="brand2" name="brandOfCar2" class="custom-select"
                                <#if !message??>onchange="openbox('model2',this)"</#if>>
                            <#if message??>
                                <option selected value="${message.car2.car_brandOfCar.id}">${message.car2.car_brandOfCar.name}</option>
                            <#else>
                                <option disabled selected>Выберите марку...</option>
                            </#if>
                            <#list brands as brand>
                                <option value="${brand.id}" >${brand.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="model2" name="modelOfCar2" class="custom-select" <#if !message??>disabled</#if>>
                            <#if message??>
                                <option selected value="${message.car2.car_modelOfCar.id}">${message.car2.car_modelOfCar.name}</option>
                            <#else>
                                <option disabled selected>Выберите модель...</option>
                            </#if>
                            <#list models as model>
                                <option value="${model.id}" >${model.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="bodyType2" name="typeOfBody2" class="custom-select" >
                            <#if message??>
                                <option selected value="${message.car2.typeOfBody.id}" >${message.car2.typeOfBody.name}</option>
                            <#else>
                                <option disabled selected>Выберите тип кузова...</option>
                            </#if>
                            <#list bodies as body>
                                <option value="${body.id}" >${body.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="typeOfCar2" name="typeOfTransport2" class="custom-select" >
                            <#if message??>
                                <option selected value="${message.car2.typeOfTransport.id}">${message.car2.typeOfTransport.name}</option>
                            <#else>
                                <option disabled selected>Выберите тип транспорта...</option>
                            </#if>
                            <#list typeOfTransports as typeOfTransport>
                                <option value="${typeOfTransport.id}" >${typeOfTransport.name}</option>
                            </#list>
                        </select>
                    </div>

                </div>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse"
                   href="#collapseLocation" role="button" aria-expanded="false" aria-controls="collapseLocation">
                    Местопроисшествия
                </a>
            </p>

            <div class="collapse<#if message??>.show</#if> mb-2" id="collapseLocation">
                <div class="card card-body">

                    <div class="form-group">
                        <select id="region" name="region" class="custom-select"
                                <#if !message??>onchange="openbox('city',this)"</#if>>
                            <#if message??>
                                <option selected value="${message.street1.city.region.id}">${message.street1.city.region.name}</option>
                            <#else>
                                <option disabled selected>Выберите регион...</option>
                            </#if>
                            <#list regions as region>
                                <option value="${region.id}" >${region.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="city" name="city" class="custom-select"<#if !message??> onchange="openbox('street1',this)"</#if>
                                <#if !message??>disabled</#if>>
                            <#if message??>
                                <option selected value="${message.street1.city.id}">${message.street1.city.name}</option>
                            <#else>
                                <option disabled selected>Выберите город...</option>
                            </#if>
                            <#list cities as city>
                                <option value="${city.id}" >${city.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="street1" name="street1" class="custom-select" <#if !message??>onchange="openbox('street2',this)"</#if>
                                <#if !message??>disabled</#if>>
                            <#if message??>
                                <option selected value="${message.street1.id}">${message.street1.name}</option>
                            <#else>
                                <option disabled selected>Выберите улицу...</option>
                            </#if>
                            <#list streets as street>
                                <option value="${street.id}" >${street.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="street2" name="street2" class="custom-select" <#if !message??>disabled</#if>>
                            <#if message??>
                                <option selected value="${message.street2.id}">${message.street2.name}</option>
                            <#else>
                                <option disabled selected>Выберите пересечение (если имеется)...</option>
                            </#if>
                            <#list streets as street>
                                <option value="${street.id}" >${street.name}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="roadObj" name="typeOfRoadObj" class="custom-select" >
                            <#if message??>
                                <option selected value="${message.typeOfRoadObj.id}">${message.typeOfRoadObj.name}</option>
                            <#else>
                                <option disabled selected>Выберите тип дорожного объекта...</option>
                            </#if>
                            <#list roadObj as roadObj>
                                <option value="${roadObj.id}" >${roadObj.name}</option>
                            </#list>
                        </select>
                    </div>

                </div>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input class="form-control" type="text" name="tag" placeholder="Тэг"
                       value="<#if message??>${message.tag}</#if>">
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Выберите файл</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
            <button class="btn btn-primary mt-2" type="submit">Сохранить</button>
        </form>
    </div>
</div>

<script>
    function openbox(id) {
        var select = document.getElementById(id);
        if (!select.disabled) {
            select.disabled = "disabled";
        }
        else {
            select.disabled = "";
        }
    }
</script>

