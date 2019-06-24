insert into brand_of_cars(id, name) VALUES (1, 'Audi'),
                                           (2, 'BMW'),
                                           (3, 'KIA');

insert into model_of_cars(id, name, brand_id) VALUES (1, 'TT', 1),
                                                     (2, 'A3', 1),
                                                     (3, 'M3', 2),
                                                     (4, 'M5', 2),
                                                     (5, 'Rio', 3),
                                                     (6, 'Spectra', 3);

insert into type_of_transports(id, name) VALUES (1, 'Общественный'),
                                                (2, 'Такси'),
                                                (3, 'Индивидуальный'),
                                                (4, 'Организация');

insert into type_of_bodies(id, name) VALUES (1, 'Седан'),
                                            (2, 'Купе'),
                                            (3, 'Грузовик'),
                                            (4, 'Автобус');