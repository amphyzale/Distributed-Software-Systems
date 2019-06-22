

<div class="collapse<#if message??>show</#if>" id="collapseNews">
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
                <input type="datetime-local" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.date}</#if>" name="dateOfCrash" placeholder="Укажите дату и время" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseCar1" role="button" aria-expanded="false" aria-controls="collapseCar1">
                    Участник 1
                </a>
            </p>
            <div class="collapse mb-2" id="collapseCar1">
                <div class="card card-body">
                    <div class="form-group">
                        <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                               value="<#if car1??>${car1.regNum}</#if>" name="regNum" placeholder="Регистрационный номер" />
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>

                    <div class="form-group">
                        <select id="brand1" name="brandOfCar1" class="custom-select" data-live-search="true" >
                            <option selected>Выберите марку...</option>
                            <#list regions as region>
                                <option >${region.name}</option>
                            </#list>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="model1" name="modleOfCar1" class="custom-select" data-live-search="true">
                            <option selected>Выберите модель...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="bodyType1" name="typeOfBody1" class="custom-select" data-live-search="true">
                            <option selected>Выберите тип кузова...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="typeOfCar1" name="typeOfTransport1" class="custom-select" data-live-search="true">
                            <option selected>Выберите тип транспорта...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                </div>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseCar2" role="button" aria-expanded="false" aria-controls="collapseCar2">
                    Участник 2 (если имеется)
                </a>
            </p>

            <div class="collapse mb-2" id="collapseCar2">
                <div class="card card-body">
                    <div class="form-group">
                        <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                               value="<#if car1??>${car1.regNum}</#if>" name="regNum" placeholder="Регистрационный номер" />
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>

                    <div class="form-group">
                        <select id="brand2" name="brandOfCar2" class="custom-select" data-live-search="true">
                            <option selected>Выберите марку...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="model2" name="modelOfCar2" class="custom-select" data-live-search="true">
                            <option selected>Выберите модель...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="bodyType2" name="typeOfBody2" class="custom-select" data-live-search="true">
                            <option selected>Выберите тип кузова...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="typeOfCar2" name="typeOfTransport2" class="custom-select" data-live-search="true">
                            <option selected>Выберите тип транспорта...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                </div>
            </div>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseLocation" role="button" aria-expanded="false" aria-controls="collapseLocation">
                    Местопроисшествия
                </a>
            </p>

            <div class="collapse mb-2" id="collapseLocation">
                <div class="card card-body">

                    <div class="form-group">
                        <select id="region" name="region" class="custom-select" data-live-search="true">
                            <option selected>Выберите регион...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="city" name="city" class="custom-select" data-live-search="true">
                            <option selected>Выберите город...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="street1" name="street1" class="custom-select" data-live-search="true">
                            <option selected>Выберите улицу...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="street2" name="street2" class="custom-select" data-live-search="true">
                            <option selected>Выберите пересечение (если имеется)...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <select id="roadObj" name="typeOfRoadObj" class="custom-select" data-live-search="true">
                            <option selected>Выберите тип дорожного объекта...</option>
                            <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                            <option data-tokens="mustard">Burger, Shake and a Smile</option>
                            <option data-tokens="frosting">Sugar, Spice and all things nice</option>
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

