drop table post_codes if exists;
drop table suburbs if exists;

create table post_codes (
	id bigint generated by default as identity, 
	code integer not null unique, 
	category varchar(20) not null default '',
	primary key (id)
);

create table suburbs (
	id bigint generated by default as identity, 
	name varchar(255) not null,
	state_territory varchar(3) not null,
	post_code_id bigint not null, 
	primary key (id),
	unique key (post_code_id, name)
);

alter table suburbs add constraint FK_POST_CODE foreign key (post_code_id) references post_codes;