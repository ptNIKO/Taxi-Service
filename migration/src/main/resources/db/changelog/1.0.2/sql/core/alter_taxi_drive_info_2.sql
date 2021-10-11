alter table taxi_service.taxi_drive_info add city_id bigint not null default 0;
alter table taxi_service.taxi_drive_info add constraint fk_city_id foreign key (city_id) references city_queue(id);