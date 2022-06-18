create user microservices with encrypted password 'pass';

create database customerservice;
grant all privileges on database customerservice to microservices;

create database fraudservice;
grant all privileges on database fraudservice to microservices;

create database notificationservice;
grant all privileges on database notificationservice to microservices;
