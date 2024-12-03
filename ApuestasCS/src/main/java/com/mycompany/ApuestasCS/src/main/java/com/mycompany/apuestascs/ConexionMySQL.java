/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apuestascs;

/**
 *
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    private static final String USER = "root";
    private static final String PASSWORD = "hola123";

    public Connection conectar() {
        Connection conexion = null;
        try {

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
        } catch (SQLException e) {

            System.out.println("Error al conectar a la base de datos " + e.getMessage());
        }

        return conexion;
    }

    public void crearTabla() {

        String sql = """
                CREATE TABLE IF NOT EXISTS empleados (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    fecha VARCHAR(20) NOT NULL,
                    evento VARCHAR(50) NOT NULL, 
                    ganador VARCHAR(50) NOT NULL, 
                    monto DOUBLE NOT NULL 
                      
                );
                """;

        try (Connection conexion = conectar()) {
            if (conexion != null) {

                conexion.createStatement().execute(sql);
                System.out.println("Tabla apuestas creada o ya existia.");
            }
        } catch (SQLException e) {

            System.out.println("Error al crear la tabla apuestas " + e.getMessage());
        }
    }
}
