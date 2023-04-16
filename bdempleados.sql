CREATE DATABASE BDEMPLEADOS
    DEFAULT CHARACTER SET = 'utf8mb4';
USE BDEMPLEADOS;
CREATE TABLE tb_empleados(
    id_empleado INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    apellido_paterno CHAR(20),
    apellido_materno CHAR(20),
    nombre CHAR(20),
    fecha_contratacion DATE,
    salario_diario DECIMAL(5, 2)  
);  
SELECT * FROM tb_empleados; 