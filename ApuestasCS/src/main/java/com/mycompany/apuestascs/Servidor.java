/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apuestascs;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private static final int PUERTO = 12345;
    private static Connection conexion;

    public static void main(String[] args) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_apuesta", "usuario", "contraseña");
            ServerSocket serverSocket = new ServerSocket(PUERTO);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClienteHandler(socket)).start();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClienteHandler implements Runnable {

        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                Apuesta apuesta = (Apuesta) in.readObject();
                guardarApuesta(apuesta);
                List<Apuesta> apuestas = listarApuestas();
                out.writeObject(apuestas);

            } catch (SQLException e) {
                System.err.println("Error en la base de datos " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Error de entrada/salida " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.err.println("Clase no encontrada " + e.getMessage());
                e.printStackTrace();
            }
        }

        private void guardarApuesta(Apuesta apuesta) throws SQLException {
            String sql = "INSERT INTO apuesta (fecha, apostador, evento, ganador, monto) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, apuesta.getFecha());
                stmt.setString(2, apuesta.getApostador());
                stmt.setString(3, apuesta.getEvento());
                stmt.setString(4, apuesta.getGanador());
                stmt.setDouble(5, apuesta.getMonto());
                stmt.executeUpdate();
            }
        }
    }

    private static List<Apuesta> listarApuestas() throws SQLException {
        List<Apuesta> apuestas = new ArrayList<>();
        String sql = "SELECT * FROM apuesta";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Apuesta apuesta = new Apuesta(
                        rs.getString("fecha"),
                        rs.getString("apostador"),
                        rs.getString("evento"),
                        rs.getString("ganador"),
                        rs.getDouble("monto")
                );
                apuestas.add(apuesta);
            }
        }
        return apuestas;
    }
}
