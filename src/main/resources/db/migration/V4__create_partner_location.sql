create table partner_location
(
    partner_id uuid,
    id uuid not null
        constraint partner_location_pkey
            primary key
        constraint fk_base_location_partner_location
            references base_location
);

