/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apuestascs;

import java.io.Serializable;

/**
 *
 */
public class Apuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id; 
    private String fecha;
    private String apostador;
    private String evento;
    private String ganador;
    private double monto;

    public Apuesta(String fecha, String apostador, String evento, String ganador, double monto) {
        this.fecha = fecha;
        this.apostador = apostador;
        this.evento = evento;
        this.ganador = ganador;
        this.monto = monto;
    }

   
    public int getId() {
        return id; 
    }

    public String getFecha() {
        return fecha;
    }

    public String getApostador() {
        return apostador;
    }

    public String getEvento() {
        return evento;
    }

    public String getGanador() {
        return ganador;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Apuesta{"
                + "id=" + id
                + ", fecha='" + fecha + '\''
                + ", apostador='" + apostador + '\''
                + ", evento='" + evento + '\''
                + ", ganador='" + ganador + '\''
                + ", monto=" + monto
                + '}';
    }
}
