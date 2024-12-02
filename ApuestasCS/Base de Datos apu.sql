CREATE DATABASE mi_base_de_datos;
USE mi_base_de_datos;

-- Crear tabla de apuesta
CREATE TABLE apuesta(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha VARCHAR(255),
    apostador VARCHAR(255),
    evento VARCHAR(255),
    ganador VARCHAR(255),
    monto DECIMAL(10, 2)
);

-- Insertar elementos
INSERT INTO apuesta (id, fecha, apostador, evento, ganador, monto) VALUES
('P001', '25/12/2024', 'Keren','ruleta', 'keren' , 50000),
('P002', '25/12/2024', 'Gerardo', 'ruleta', 'Jorgi' , 40000);

