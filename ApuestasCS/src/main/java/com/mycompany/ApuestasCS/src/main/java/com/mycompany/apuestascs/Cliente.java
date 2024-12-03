/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apuestascs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 12345;
    private JFrame frame;
    private JTextField fechaField, apostadorField, eventoField, ganadorField, montoField;
    private JTable tabla;
    

    public Cliente() {
        frame = new JFrame("Gestión de Apuestas");
        frame.setLayout(new GridLayout(6, 2));

        fechaField = new JTextField();
        apostadorField = new JTextField();
        eventoField = new JTextField();
        ganadorField = new JTextField();
        montoField = new JTextField();

        JButton enviarButton = new JButton("Enviar Apuesta");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarApuesta();
            }
        });

        frame.add(new JLabel("Fecha "));
        frame.add(fechaField);
        frame.add(new JLabel("Apostador "));
        frame.add(apostadorField);
        frame.add(new JLabel("Evento "));
        frame.add(eventoField);
        frame.add(new JLabel("Ganador "));
        frame.add(ganadorField);
        frame.add(new JLabel("Monto "));
        frame.add(montoField);
        frame.add(enviarButton);

        tabla = new JTable();
        frame.add(new JScrollPane(tabla));

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void enviarApuesta() {
        try (Socket socket = new Socket(HOST, PUERTO); ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Apuesta apuesta = new Apuesta(
                    fechaField.getText(),
                    apostadorField.getText(),
                    eventoField.getText(),
                    ganadorField.getText(),
                    Double.parseDouble(montoField.getText())
            );

            out.writeObject(apuesta);
            List<Apuesta> apuestas = (List<Apuesta>) in.readObject();
            actualizarTabla(apuestas);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void actualizarTabla(List<Apuesta> apuestas) {
        String[] columnNames = {"ID", "Fecha", "Apostador", "Evento", "Ganador", "Monto"};
        Object[][] data = new Object[apuestas.size()][6];

        for (int i = 0; i < apuestas.size(); i++) {
            Apuesta apuesta = apuestas.get(i);
            data[i][0] = apuesta.getId();
            data[i][1] = apuesta.getFecha();
            data[i][2] = apuesta.getApostador();
            data[i][3] = apuesta.getEvento();
            data[i][4] = apuesta.getGanador();
            data[i][5] = apuesta.getMonto();
        }

        tabla.setModel(new DefaultTableModel(data, columnNames));
    }

    public static void main(String[] args) {
        new Cliente();
    }
}
