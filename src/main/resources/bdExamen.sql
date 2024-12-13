-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS Empresa;

-- Crear la base de datos
CREATE DATABASE Empresa;

-- Usar la base de datos
USE Empresa;

-- Creación de la tabla departamento con los nuevos campos
CREATE TABLE departamento (
                              departamentoID INT AUTO_INCREMENT PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL,
                              ubicacion VARCHAR(100) NOT NULL,
                              presupuesto INT NOT NULL,
                              gastos INT NOT NULL
);

-- Creación de la tabla empleado
CREATE TABLE empleado (
                          empleadoID INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL,
                          rol VARCHAR(20) NOT NULL,
                          departamento_id INT,
                          FOREIGN KEY (departamento_id) REFERENCES departamento(departamentoID)
);

-- Inserción de datos en la tabla departamento
INSERT INTO departamento (nombre, ubicacion, presupuesto, gastos)
VALUES
    ('Recursos Humanos', 'Edificio A', 500000, 200000),
    ('TI', 'Edificio B', 1000000, 800000),
    ('Marketing', 'Edificio C', 750000, 300000),
    ('Finanzas', 'Edificio D', 600000, 250000),
    ('Ventas', 'Edificio E', 900000, 450000),
    ('Operaciones', 'Edificio F', 1200000, 700000);

-- Inserción de datos en la tabla empleado
INSERT INTO empleado (nombre, apellido, rol, departamento_id)
VALUES
    ('Carlos', 'Ramírez', 'usuario', 1),
    ('María', 'Lopez', 'administrador', 2),
    ('Miguel', 'Sánchez', 'usuario', 3),
    ('Laura', 'Martinez', 'administrador', 4),
    ('Sofía', 'González', 'usuario', 5),
    ('Jorge', 'Fernandez', 'usuario', 6),
    ('Patricia', 'Jiménez', 'administrador', 1),
    ('Raúl', 'Mendoza', 'usuario', 2),
    ('Susana', 'Castro', 'usuario', 3),
    ('David', 'Ortega', 'administrador', 4),
    ('Ana', 'Rojas', 'usuario', 5),
    ('Luis', 'Navarro', 'usuario', 6);
