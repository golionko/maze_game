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
  max_hp int not null,
  energy int not null default 0,
  max_energy int not null,
  labyrinth_room_id int not null,
  constraint fk_avatar_labyrinth_room foreign key(labyrinth_room_id) references labyrinth_room(id),
  constraint fk_avatar_users foreign key(user_id) references users(id)
);

insert into avatar (id, user_id, name, xp, level, strength, dexterity, luck, constitution, hp, max_hp, energy, max_energy, labyrinth_room_id) VALUES
(1, 1, 'Anton Avatar', 1 , 1 , 1, 1, 1, 1, 1, 100, 1, 100, 2);


create table item
(
  id int not null primary key auto_increment,
  item_type varchar(255) not null,
  name varchar(255) not null,
  description text not null
);

create table item_buff
(
  id int not null primary key auto_increment,
  item_id int not null,
  buff_type varchar(255) not null,
  stat varchar(255) not null,
  amount int not null default 0,
  constraint fk_item_buff_item foreign key(item_id) references item(id)
);

create table avatar_item_inventory
(
  id int not null primary key auto_increment,
  item_id int not null,
  avatar_id int not null,
  amount int not null default 0,
  constraint fk_avatar_inventory_item foreign key(item_id) references item(id),
  constraint fk_avatar_inventory_avatar foreign key(avatar_id) references avatar(id)
);

create table avatar_item_equipped
(
  id int not null primary key auto_increment,
  item_id int not null,
  avatar_id int not null,
  body_part varchar(255) not null,
  constraint fk_avatar_inventory_item foreign key(item_id) references item(id),
  constraint fk_avatar_inventory_avatar foreign key(avatar_id) references avatar(id)
);

create table creature
(
  id int not null primary key auto_increment,
  name varchar(255) not null,
  description text not null,
  xp int not null default 0,
  level int not null default 0,
  strength int not null default 0,
  dexterity int not null default 0,
  luck int not null default 0,
  constitution int not null default 0,
  hp int not null default 0,
  max_hp int not null,
  energy int not null default 0,
  max_energy int not null
);

create table labyrinth_room_creature
(
  id int not null primary key auto_increment,
  creature_id int not null,
  labyrinth_room_id int not null,
  constraint fk_labyrinth_room_creature_labyrinth_room foreign key(labyrinth_room_id) references labyrinth_room(id),
  constraint fk_labyrinth_room_creature foreign key(creature_id) references creature(id)
);