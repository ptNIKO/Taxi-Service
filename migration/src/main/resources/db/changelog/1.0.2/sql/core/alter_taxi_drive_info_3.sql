alter table taxi_service.taxi_drive_info add column active_status boolean default false;
alter table taxi_service.taxi_drive_info add column number_tips integer default 0;
alter table taxi_service.taxi_drive_info add column rating float default 0;
