ALTER TABLE if exists message drop CONSTRAINT message_road_obj_fk;

alter table if exists message
    add constraint message_road_obj_fk
        foreign key (road_obj_id) references type_of_road_objects;