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
  constraint fk_authorities_users foreign key(user_id) references users(id)
);


insert into users ( user_name, password, enabled) values ( 'anton', concat('{MD5}',md5('password')), true);
insert into authorities (user_id, authority) values (2, 'ROLE_ADMIN');

create table labyrinth
(
   id int not null primary key auto_increment,
   name varchar(100),
   size int not null
);

create table labyrinth_room
(
  id int not null primary key auto_increment,
  labyrinth_id int not null,
  x_origin int not null,
  y_origin int not null,
  z_origin int not null,
  x_location int not null,
  y_location int not null,
  z_location int not null,
  room_color varchar(100),
  constraint fk_labyrinth_room_labyrinth_id foreign key(labyrinth_id) references labyrinth(id)
);

create table avatar
(
  id int not null primary key auto_increment,
  user_id int not null,
  name varchar(255) not null,
  xp int not null default 0,
  level int not null default 0,
  strength int not null default 0,
  dexterity int not null default 0,
  luck int not null default 0,
  constitution int not null default 0,
  hp int not null default 0,
  energy int not null default 0,
  labyrinth_room_id int not null,
  constraint fk_avatar_labyrinth_room foreign key(labyrinth_room_id) references labyrinth_room(id),
  constraint fk_avatar_users foreign key(user_id) references users(id)
);
