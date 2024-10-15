/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaprogramada1;

/**
 *
 * @author sebas
 */
public class PracticaProgramada1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 12; 
        System.out.println("Los números pares desde 0 hasta " + n + " son:");
        NumerosPares.pares(n);
        
        PilaP pila = new PilaP();

        // Agregar elementos a la pila
        pila.apilar(new DatoC("O"));
        pila.apilar(new DatoC("T"));
        pila.apilar(new DatoC("A"));
        pila.apilar(new DatoC("G"));

        // Imprimir la pila
        System.out.println("Elementos en la pila:");
        pila.imprimirPila();
        
       Cola cola = new Cola();

        // Agregar elementos a la cola
        cola.encolar(4);
        cola.encolar(6);
        cola.encolar(8);
        cola.encolar(2);
        cola.encolar(7);

        System.out.println("Cola original:");
        cola.imprimirCola();

        // Ordenar la cola
        cola.ordenarCola();

        System.out.println("Cola ordenada:");
        cola.imprimirCola(); 
        
        

    }
    
}
