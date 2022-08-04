CREATE DATABASE personalhub;
USE personalhub;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL,
active bit DEFAULT 1,
admin bit DEFAULT 0
);

CREATE TABLE collections (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
topic ENUM ("Books", "Electronics", "Jeweler", "Other") NOT NULL,
image VARCHAR(255),
integer1 int DEFAULT NULL,
integer2 int DEFAULT NULL,
integer3 int DEFAULT NULL,
string1 VARCHAR(255),
string2 VARCHAR(255),
string3 VARCHAR(255),
multiline1 VARCHAR(255),
multiline2 VARCHAR(255),
multiline3 VARCHAR(255),
boolean1 bit,
boolean2 bit,
boolean3 bit,
date1 datetime,
date2 datetime,
date3 datetime
);

CREATE TABLE items (
id INT AUTO_INCREMENT PRIMARY KEY,
collection_id INT NOT NULL,
name VARCHAR(50) NOT NULL,
tags VARCHAR(255) NOT NULL,
creation_time datetime DEFAULT CURRENT_TIMESTAMP
);
