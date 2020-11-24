-- TODO: delete this file when release
-- this sql is only a memo of the statements

CREATE TABLE "member"
(
    "member_id" int           NOT NULL PRIMARY KEY,
    "username"  varchar(25)   NOT NULL UNIQUE,
    "password"  varchar(25)   NOT NULL,
    "fist_name" varchar(35)   NOT NULL,
    "last_name" varchar(35)   NOT NULL,
    "birthday"  date,
    "address"   varchar(255),
    "phone"     varchar(15),
    "reward"    int DEFAULT 0 NOT NULL
);

CREATE TABLE "employee"
(
    "employee_id" int           NOT NULL PRIMARY KEY,
    "fist_name"   varchar(35)   NOT NULL,
    "last_name"   varchar(35)   NOT NULL,
    "gender"      int DEFAULT 0 NOT NULL CHECK ("gender" IN (0, 1, 2, 9)),
    "address"     varchar(255),
    "phone"       varchar(15),
    "group"       varchar(20),
    "salary"      number(*, 2)
);

CREATE TABLE "product"
(
    "product_id"          int                    NOT NULL PRIMARY KEY,
    "name"                varchar(255)           NOT NULL,
    "retail_price"        number(*, 2),
    "category"            varchar(255)           NOT NULL,
    "membership_discount" number(*, 2) DEFAULT 0 NOT NULL,
    "stock_info"          varchar(255)           NOT NULL
);

CREATE TABLE "supplier"
(
    "supplier_id"    int          NOT NULL PRIMARY KEY,
    "name"           varchar(255) NOT NULL,
    "address"        varchar(255),
    "contact_person" varchar(70)
);

CREATE TABLE "warehouse"
(
    "warehouse_id"   int          NOT NULL PRIMARY KEY,
    "supplier_id"    int          NOT NULL,
    "product_id"     int          NOT NULL,
    "incoming_date"  date         NOT NULL,
    "purchase_price" number(*, 2) NOT NULL,
    "amount"         number(*, 2) NOT NULL,
    FOREIGN KEY ("supplier_id") REFERENCES "supplier" ("supplier_id"),
    FOREIGN KEY ("product_id") REFERENCES "product" ("product_id")
);

CREATE TABLE "sale"
(
    "sale_id"        int          NOT NULL PRIMARY KEY,
    "date"           date         NOT NULL,
    "payment_method" varchar(255),
    "total_price"    number(*, 2) NOT NULL,
    "member_id"      int,
    "sub_sale_id"    int,
    FOREIGN KEY ("member_id") REFERENCES "member" ("member_id")
);

CREATE TABLE "sub_sale"
(
    "sub_sale_id" int           NOT NULL PRIMARY KEY,
    "product_id"  int           NOT NULL,
    "sale_id"     int           NOT NULL,
    "price"       number(*, 2)  NOT NULL,
    "amount"      int DEFAULT 1 NOT NULL,
    FOREIGN KEY ("product_id") REFERENCES "product" ("product_id"),
    FOREIGN KEY ("sale_id") REFERENCES "sale" ("sale_id")
);
