create table Brands
(
    id smallserial not null primary key,
    name varchar(50) unique not null,
    created_at timestamp not null,
    updated_at timestamp not null
);
