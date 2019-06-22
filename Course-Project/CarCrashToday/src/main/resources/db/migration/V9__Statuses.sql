insert into statuses (id, name) values (1, 'Создано'), (2, 'Отправлено'), (3, 'Опубликовано'), (4, 'Отклонено');

alter table message alter column status_id SET default 1;