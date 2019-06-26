create table users
(
  id int not null primary key auto_increment,
  user_name varchar(255) not null,
  password varchar(255),
  enabled  bit not null
);

create table authorities
(
  id int not null primary key auto_increment,
  user_id int not null,
  authority varchar(255) not null,
  constraint fk_authorities_users foreign key(user_id) references users(user_id)
);


insert into users ( user_name, password, enabled) values ( 'anton', concat('{MD5}',md5('password')), true);
insert into authorities (user_id, authority) values (2, 'ROLE_ADMIN');