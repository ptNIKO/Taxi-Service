create sequence if not exists order_total_seq
    start 1;

create table if not exists order_total
(
    order_id bigint not null default nextval('order_total_seq' :: regclass),
    cost    int,
    constraint order_id_fk foreign key (order_id) references testliquibase.taxi_service.orders(id)

);

comment on table order_total is 'Общая таблица стоимости поездкок';
comment on column order_total.order_id is 'Идентификатор заказа';
comment on column order_total.cost is 'Стоимость поездки';

