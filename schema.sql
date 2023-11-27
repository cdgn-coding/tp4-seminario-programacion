create
database if not exists `schedules`;
use
`schedules`;

create table Car
(
    id    bigint       not null auto_increment,
    brand varchar(255) not null,
    model varchar(255) not null,
    year  int          not null,
    primary key (id)
);

create table Customer
(
    id                   bigint       not null auto_increment,
    name                 varchar(255) not null,
    identificationType   varchar(255) not null,
    identificationNumber varchar(255) not null,
    phoneNumber          varchar(255) not null,
    email                varchar(255) not null,
    primary key (id)
);

create table Insurance
(
    id          bigint       not null auto_increment,
    name        varchar(255) not null,
    companyName varchar(255) not null,
    primary key (id)
);

create table Schedule
(
    id               bigint       not null auto_increment,
    dateAndTime      datetime     not null,
    professionalType varchar(255) not null,
    car_id           bigint       not null,
    insurance_id     bigint       not null,
    customer_id      bigint       not null,
    primary key (id),
    constraint fk_car foreign key (car_id) references Car (id),
    constraint fk_insurance foreign key (insurance_id) references Insurance (id),
    constraint fk_customer foreign key (customer_id) references Customer (id)
);