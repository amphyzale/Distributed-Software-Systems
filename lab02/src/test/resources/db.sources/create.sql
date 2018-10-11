CREATE TABLE owner
(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name char(50) NOT NULL,
  birthDate date NOT NULL,
  address char(50),
  iq int NOT NULL
);

CREATE TABLE pet
(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name         char(25) NOT NULL,
  age          int      NOT NULL,
  type         char(25) NOT NULL,
  pet_owner_id int      NOT NULL,
  FOREIGN KEY (pet_owner_id) REFERENCES owner (id)
);