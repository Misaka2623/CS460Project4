-- TODO: delete this file when release
-- this sql is only a memo of the statements

create table "member"
(
    "mid"       int           not null primary key,
    "username"  varchar(25)   not null unique,
    "password"  varchar(25)   not null,
    "fist_name" varchar(35)   not null,
    "last_name" varchar(35)   not null,
    "birthday"  date,
    "address"   varchar(255),
    "phone"     varchar(15),
    "reward"    int default 0 not null
);

create table "employee"
(
    "eid"       int           not null primary key,
    "fist_name" varchar(35)   not null,
    "last_name" varchar(35)   not null,
    "gender"    int default 0 not null check ("gender" in (0, 1, 2, 9)),
    "address"   varchar(255),
    "phone"     varchar(15),
    "group"     varchar(20),
    "salary"    number(*, 2)
);

create table "product"
(
    "pid"                 int                    not null primary key,
    "name"                varchar(255)           not null,
    "retail_price"        number(*, 2),
    "category"            varchar(255)           not null,
    "membership_discount" number(*, 2) default 0 not null,
    "stock_info"          varchar(255)           not null
);

create table "supplier"
(
    "sid"            int          not null primary key,
    "name"           varchar(255) not null,
    "address"        varchar(255),
    "contact_person" varchar(70)
);

create table "warehouse"
(
    "sid"            int          not null,
    "pid"            int          not null,
    "incoming_date"  date         not null,
    "purchase_price" number(*, 2) not null,
    "amount"         number(*, 2) not null,
    foreign key ("sid") references "supplier" ("sid"),
    foreign key ("pid") references "product" ("pid")
);

create table "sale"
(
    "sid"            int          not null primary key,
    "date"           date         not null,
    "payment_method" varchar(255),
    "total_price"    number(*, 2) not null,
    "mid"            int,
    "sub_sid"        int,
    foreign key ("mid") references "member" ("mid")
);

create table "sub_sale"
(
    "ssid"   int           not null primary key,
    "pid"    int           not null,
    "sid"    int           not null,
    "price"  number(*, 2)  not null,
    "amount" int default 1 not null,
    foreign key ("pid") references "product" ("pid"),
    foreign key ("sid") references "sale" ("sid")
);
