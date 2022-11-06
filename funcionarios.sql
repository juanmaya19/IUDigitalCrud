CREATE TABLE `test`.`funcionarios` (
`id_funcionario` INT NOT NULL AUTO_INCREMENT,
`tipo_identificacion` VARCHAR(45) NOT NULL,
`numero_identificacion` VARCHAR(45) NOT NULL,
`nombres` VARCHAR(45) NOT NULL,
`apellidos` VARCHAR(45) NOT NULL,
`estado_civil` INT NOT NULL,
`sexo` INT NOT NULL,
`direccion` VARCHAR(45) NOT NULL,
`telefono` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_funcionario`),
FOREIGN KEY (estado_civil) REFERENCES estado (`id_estado`),
FOREIGN KEY (sexo) REFERENCES sexo (`id_sexo`));

CREATE TABLE `test`.`tipodocumento` (
`id_tipodocumento` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_tipodocumento`));

CREATE TABLE `test`.`gradoacademico` (
`id_gradoacademico` INT NOT NULL AUTO_INCREMENT,
`titulo` VARCHAR(45) NOT NULL,
`universidad` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_gradoacademico`));

CREATE TABLE `test`.`sexo` (
`id_sexo` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_sexo`));

CREATE TABLE `test`.`estado` (
`id_estado` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_estado`));

CREATE TABLE `test`.`grupofamiliar` (
`id_grupofamiliar` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`apellido` VARCHAR(45) NOT NULL,
`rol` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_grupofamiliar`));


SELECT * FROM funcionarios;
SELECT * FROM tipodocumento;
SELECT * FROM grado_academico;
SELECT * FROM sexo;
SELECT * FROM estado;
SELECT * FROM grupofamiliar;


INSERT INTO sexo (nombre) value ('Femenino');
INSERT INTO sexo (nombre) value ('Masculino');


INSERT INTO gradoacademico (titulo, univesidad) VALUES ('administrador ', 'iudigital' );
INSERT INTO gradoacademico (titulo, univesidad) VALUES ('Administrador', 'IUdigital');
INSERT INTO gradoacademico (titulo, univesidad) VALUES ('ingeniero', 'Udea');

INSERT INTO tipodocumento(nombre) value ('Cedula');
INSERT INTO tipodocumento(nombre) value ('Pasaporte');

INSERT INTO estado (nombre) value ('Soltero');
INSERT INTO estado (nombre) value ('Casado');
INSERT INTO estado (nombre) value ('Separado');

INSERT INTO grupofamiliar(nombre, apellido, rol) VALUES ('juan David ', 'Maya', 'Padre');

INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Cedula', '1033456782', 'Camilo', 'Gutierrez', 1, 2, 'Bogota', '3235871539');
INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Pasaporte', '6783456732', 'Andres Julian', 'Rendon Tobon', 2, 1, 'Caldas', '3178996788');
INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Cedula', '3456123897', 'Marcela', 'Rios Rua', 2, 1, 'San Andres', '3145089988');
INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Pasaporte', '1098456785', 'Maria Camila', 'Arango Maya', 1, 2, 'Tolima', '3005872339');
INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Cedula Extrangera', '2341234767', 'Sara Camila', 'Zuluaga Peña', 2, 1, 'Entrerrios', '3112789988');
INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES ('Pasaporte', '3523124576', 'Andres', 'Rojas Incapie', 2, 1, 'Cartagena', '3145712388');

SELECT funcionarios.id_funcionario, funcionarios.tipo_identificacion, funcionarios.numero_identificacion, funcionarios.nombres, funcionarios.apellidos,
       funcionarios.direccion, funcionarios.telefono, estado.nombre, sexo.nombre FROM funcionarios
        INNER JOIN estado ON funcionarios.estado_civil = estado.id_estado
        INNER JOIN sexo ON funcionarios.sexo = sexo.id_sexo