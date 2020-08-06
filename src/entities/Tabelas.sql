CREATE TABLE autor(
id int(4) AUTO_INCREMENT,
nome varchar(45) NOT NULL,
constraint pk_Autor PRIMARY KEY (id)
);


CREATE TABLE livro
(id int(4) AUTO_INCREMENT,
titulo varchar(45),
constraint pk_Livro PRIMARY KEY (id));

CREATE TABLE autor_livro (
  id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  AutortId int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (AutortId) REFERENCES autor (id)
);