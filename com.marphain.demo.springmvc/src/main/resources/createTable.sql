drop table if exists test.t_hello;
create table `t_hello`(
`id` int(11) not null auto_increment,
`description` varchar(256),
primary key(`id`)
)engine=InnoDB default charset=UTF8;

insert into t_hello(`description`) values('Hello World!');