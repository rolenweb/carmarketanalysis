create table Brands
(
    id smallserial not null primary key,
    name varchar(50) unique,
    created_at timestamp not null,
    updated_at timestamp not null
);
