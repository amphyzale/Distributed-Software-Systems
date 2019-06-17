create table brand_of_cars (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

create table cars (
                 id int8 not null,
                 reg_num varchar(255),
                 brand_id int8,
                 model_id int8,
                 body_id int8,
                 transport_id int8,
                 primary key (id)
);

create table cities (
                 id int8 not null,
                 name varchar(255),
                 region_id int8,
                 primary key (id)
);

create table model_of_cars (
                 id int8 not null,
                 name varchar(255),
                 brand_id int8,
                 primary key (id)
);

create table regions (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

create table statuses (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

create table streets (
                 id int8 not null,
                 name varchar(255),
                 city_id int8,
                 primary key (id)
);

create table type_of_bodies (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

create table type_of_road_objects (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

create table type_of_transports (
                 id int8 not null,
                 name varchar(255),
                 primary key (id)
);

alter table if exists message add column title varchar(255);
alter table if exists message add column dateOfCrash date;
alter table if exists message add column status_id int8;
alter table if exists message add column car1_id int8;
alter table if exists message add column car2_id int8;
alter table if exists message add column street1_id int8;
alter table if exists message add column street2_id int8;
alter table if exists message add column road_obj_id int8;



