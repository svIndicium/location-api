create table location
(
    description varchar(255),
    name varchar(255),
    id uuid not null
        constraint location_pkey
            primary key
        constraint fk_base_location_location
            references base_location
);

