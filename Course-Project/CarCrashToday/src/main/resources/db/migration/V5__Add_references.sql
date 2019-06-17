alter table if exists message
    add constraint message_status_fk
        foreign key (status_id) references statuses;

alter table if exists message
    add constraint message_car1_fk
        foreign key (car1_id) references cars;

alter table if exists message
    add constraint message_car2_fk
        foreign key (car2_id) references cars;

alter table if exists message
    add constraint message_street1_fk
        foreign key (street1_id) references streets;

alter table if exists message
    add constraint message_street2_fk
        foreign key (street2_id) references streets;

alter table if exists message
    add constraint message_road_obj_fk
        foreign key (road_obj_id) references streets;