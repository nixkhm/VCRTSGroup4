-- Active: 1669699637682@@127.0.0.1@3306@vcrts_database
create database VCRTS4Group;
create table vehicle_application(vehicle_id int (5), vehicle_make varchar(50), vehicle_model varchar(50), vehicle_year int (4), time_start int (5), time_end int (5), primary key (vehicle_id));
create table pending_vehicle_application(vehicle_id int (5), vehicle_make varchar(50), vehicle_model varchar(50), vehicle_year int (4), time_start int (5), time_end int (5), primary key (vehicle_id));
create table pending_job_application(job_id int (5) not null, job_name varchar (50), job_type varchar (50), job_duration int (5), job_deadline int (5), primary key (job_id) );
create table job_application(job_id int (5) not null, job_name varchar (50), job_type varchar (50), job_duration int (5), job_deadline int (5), primary key (job_id));

