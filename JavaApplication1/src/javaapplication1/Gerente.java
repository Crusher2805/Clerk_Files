/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Laboratorio
 */
public class Gerente extends Empleado {

    protected String departameto = "TI";
    @Override

    public String obtenerDetalles() 
        {
            return super.obtenerDetalles() + "\n Departamento: " + departameto;
        }

    }

