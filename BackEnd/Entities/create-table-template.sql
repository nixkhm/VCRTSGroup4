-- Active: 1669699637682@@127.0.0.1@3306@vcrts_database
create database VCRTS4Group;
use VCRTS4Group;
create table AllVehicles(VEHICLEID int (5), make varchar(50), model varchar(50), year int (4), timeIn int (5), timeOut int (5), primary key (VehicleID));
create table PendingVehicleApplications(VehicleID int (5), make varchar(50), model varchar(50), year int (4), timeIn int (5), timeOut int (5), primary key (VehicleID));
create table PendingJobApplications(JobID int (5) not null, name varchar (50), type varchar (50), duration int (5), deadline int (5), primary key (JobID) );
create table AllJobs(JobID int (5) not null, name varchar (50), type varchar (50), duration int (5), deadline int (5), primary key (JobID));
