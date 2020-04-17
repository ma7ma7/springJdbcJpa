CREATE TABLE person
(
	id INTEGER NOT NULL,
	name VARCHAR(255) NOT NULL,
	location VARCHAR(255) NOT NULL,
	date_birth TIMESTAMP,
	PRIMARY KEY (id)
);


insert into person values (1001, 'mahmoud', 'rabat', sysdate());