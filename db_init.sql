create schema currency;

create table if not exists currency.exchange_office(
    id serial primary key ,
    bank_name text not null ,
    address text not null
);

create table if not exists currency.exchange_rate(
    id serial primary key ,
    base_currency text not null ,
    target_currency text not null ,
    date timestamp not null ,
    purchase_rate numeric not null ,
    sale_rate numeric not null ,
    exchange_office_id int references currency.exchange_office(id) on delete no action
);

create unique index if not exists "exchange_office_id_idx" on currency.exchange_office using btree(id asc);
create unique index if not exists "exchange_rate_id_idx" on currency.exchange_rate using btree(id asc);

insert into currency.exchange_office(bank_name, address) VALUES ('SPB BANK','bolshaya ul 2');
insert into currency.exchange_office(bank_name, address) VALUES ('GAZPROM BANK','nabibulina ul 5');
insert into currency.exchange_office(bank_name, address) VALUES ('YANDEX BANK','koroleva ul 1');
insert into currency.exchange_office(bank_name, address) VALUES ('ALFA BANK','smoilova ul 3');

insert into currency.exchange_rate(base_currency, target_currency, date, purchase_rate, sale_rate, exchange_office_id)
VALUES ('USD','RUB','2023-09-20 00:00:00.000000', 88.12, 100, 1);
insert into currency.exchange_rate(base_currency, target_currency, date, purchase_rate, sale_rate, exchange_office_id)
VALUES ('USD','RUB','2023-09-20 00:00:00.000000', 88.20, 99, 2);
insert into currency.exchange_rate(base_currency, target_currency, date, purchase_rate, sale_rate, exchange_office_id)
VALUES ('USD','RUB','2023-09-20 00:00:00.000000', 88.88, 100, 3);
insert into currency.exchange_rate(base_currency, target_currency, date, purchase_rate, sale_rate, exchange_office_id)
VALUES ('USD','RUB','2023-09-20 00:00:00.000000', 88.55, 98, 4);
