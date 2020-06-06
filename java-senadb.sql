create database if not exists senaJava;

use senaJava;

create table if not exists usuario(
id int not null default(null) primary key auto_increment,
nombre varchar(45) default(null) not null, 
correo varchar(45) default(null) not null, 
contraseña varchar(45) default(null) not null
)engine=InnoDB;

 create table if not exists cliente(
id int not null default(null) primary key auto_increment,
nombre varchar(45) default(null) not null, 
apellido varchar(45) default(null) not null, 
correo varchar(45) default(null) unique not null, 
celular varchar(45) default(null) not null
)engine=InnoDB;

insert into cliente (id, nombre, apellido, correo, celular) values (0,"jonathan", "hinestroza", "jhinestroza@mail.com", "352698521");
SELECT id, nombre, apellido, celular FROM cliente;

create table if not exists login(
usuario varchar(45) not null,
contrasena varchar(45) default null
)engine=InnoDB;

create table if not exists producto(
id int not null primary key,
nombre varchar(45) not null,
cantidad int not null,
precio float not null
)engine=InnoDB;

 