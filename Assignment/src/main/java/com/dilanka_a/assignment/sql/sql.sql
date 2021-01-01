CREATE DATABASE user;

use user;


CREATE TABLE userrole (
    urid int NOT NULL AUTO_INCREMENT,
    user_role varchar(20) ,
    PRIMARY KEY (urid)
);

CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    userrole int,
    PRIMARY KEY (id),
    FOREIGN KEY (userrole) REFERENCES userrole(urid)
);


CREATE TABLE loginhistory (
    lhid int NOT NULL AUTO_INCREMENT,
    time DATETIME ,
    userid int,
    PRIMARY KEY (lhid),
    FOREIGN KEY (userid) REFERENCES users(id)
);