use veterinaria;
CREATE TABLE especie (
idEspecie INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomEspecie VARCHAR(20) NOT NULL
);

CREATE TABLE raza (
idRaza INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomRaza VARCHAR(20) NOT NULL
);

CREATE TABLE tipoIdentificacion (
idTipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomTipo VARCHAR (20) NOT NULL
);

CREATE TABLE propietario (
idPropietario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomPropietario VARCHAR(45) NOT NULL,
tipoId INT NOT NULL,
numId INT NOT NULL,
ciudad VARCHAR (20) NOT NULL,
direccion VARCHAR (40) NOT NULL,
tel VARCHAR(10) NOT NULL,
FOREIGN KEY (tipoId) REFERENCES tipoIdentificacion (idTipo)
);

CREATE TABLE paciente (
idPaciente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomPaciente VARCHAR(20) NOT NULL,
especie INT NOT NULL,
raza INT NOT NULL,
fechaNac DATE NOT NULL,
idProMascota INT NOT NULL,
fechaIng DATE NOT NULL,
FOREIGN KEY (especie) REFERENCES especie (idEspecie),
FOREIGN KEY (raza) REFERENCES raza (idRaza),
FOREIGN KEY (idProMascota) REFERENCES propietario (idPropietario)
);

INSERT INTO especie (nomEspecie) VALUES ("Perro"),("Gato");

INSERT INTO raza (nomRaza) VALUES 
("Abisinio"),("Asiático"),("Birmano"),("Azúl Ruso"),
("Bullterrier"),("Sabueso"),("Labrador"),("Pastor Alemán");

INSERT INTO tipoIdentificacion (nomTipo) VALUES ("CC"),("CE"),("PASAPORTE");

INSERT INTO propietario (nomPropietario, tipoId, numId, ciudad, direccion, tel)
VALUES ("Oscar Lopez", 1, "1062954341", "Monteria", "Calle 28 cr 14", "3008468644"),
("Laura Florez", 3, "109584655851", "Medellin", "Calle 87 cr 47", "3125546889"),
("Jesus Argumedo", 1, "1062954341", "Sincelejo", "Calle 10 cr 2", "3002566989");

INSERT INTO paciente (nomPaciente, especie, raza, fechaNac, idProMascota, fechaIng) VALUES
("Guardian", 1, 5, "2009-04-04", 10, CURDATE()),
("Danza", 1, 6, "2015-09-14", 10, CURDATE()),
("Copito", 2, 4, "2020-02-10", 11, CURDATE()),
("Minina", 2, 4, "2019-01-31", 12, CURDATE());


