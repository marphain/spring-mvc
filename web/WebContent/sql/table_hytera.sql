create table hytera
(
    id int(5) not null,
    name varchar(25) not null,
    sex varchar(2),
    age int(2),
    primary key (id)
);
select * from hytera;

select * from user;
delete from user where id=3;
truncate table user;