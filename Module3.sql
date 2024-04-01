create database Module3;
use Module3;
CREATE DATABASE IF NOT EXISTS your_database_name;

USE your_database_name;

CREATE TABLE IF NOT EXISTS Classroom (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    dob DATE,
    address VARCHAR(255),
    phone_number VARCHAR(20),
    classroom_id INT,
    FOREIGN KEY (classroom_id) REFERENCES Classroom(id)
);
