/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Laboratorio
 */
public class Empleado {
    protected String nombre = "hollu ";
    protected double salario = 1000;
    protected String fechaNacimiento;
    
    public String obtenerDetalles(){
        return " nombre: " + nombre + "\n Salario: " + salario; 
    
    }
            
}
