create table base_location
(
    id           uuid not null
        constraint base_location_pkey
            primary key,
    city         varchar(255),
    country      varchar(255),
    house_number varchar(255),
    postal_code  varchar(255),
    street       varchar(255)
);

