alter table if exists cars
    add constraint cars_brand_fk
        foreign key (brand_id) references brand_of_cars;

alter table if exists cars
    add constraint cars_model_fk
        foreign key (model_id) references model_of_cars;

alter table if exists cars
    add constraint cars_body_fk
        foreign key (body_id) references type_of_bodies;

alter table if exists cars
    add constraint cars_transport_fk
        foreign key (transport_id) references type_of_transports;

alter table if exists cities
    add constraint cities_region_fk
        foreign key (region_id) references regions;

alter table if exists model_of_cars
    add constraint model_of_brand_fk
        foreign key (brand_id) references brand_of_cars;

alter table if exists streets
    add constraint street_of_city_fk
        foreign key (city_id) references cities;

