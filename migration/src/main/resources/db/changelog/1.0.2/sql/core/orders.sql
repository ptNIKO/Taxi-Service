create sequence if not exists orders_seq
    start 1;

create table if not exists orders
(
    id bigint      not null default nextval('orders_seq' :: regclass),
    clientId   text        not null,
    driverId   varchar(30) not null,
    start_tip date,
    end_tip date,
    constraint order_pk primary key (id)

);

comment on table orders is 'Зазазы';
comment on column orders.id is 'Идентификатор заказа';
comment on column orders.clientId is 'Идентификатор клиента';
comment on column orders.driverId is 'Идентификатор водителя';
comment on column orders.start_tip is 'Время начала поездки';
comment on column orders.end_tip is 'Время окончания поездки';