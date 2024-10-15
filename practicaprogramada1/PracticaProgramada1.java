
package practicaprogramada1;


public class PracticaProgramada1 {


    public static void main(String[] args) {
        int num = 12; 
        System.out.println("Los números pares desde 0 hasta " + num + " son:");
        NumerosPares.pares(num);
        
        PilaP pila = new PilaP();

        pila.apilar(new DatoC("H"));
        pila.apilar(new DatoC("E"));
        pila.apilar(new DatoC("L"));
        pila.apilar(new DatoC("L"));
        pila.apilar(new DatoC("O"));


        System.out.println("Pila ");
        pila.imprimirPila();
        
       Cola cola = new Cola();

        cola.encolar(7);
        cola.encolar(5);
        cola.encolar(20);
        cola.encolar(9);
        cola.encolar(10);

        System.out.println("Cola sin ordenar ");
        cola.imprimirCola();

        cola.ordenarCola();

        System.out.println("Cola ya ordenada ");
        cola.imprimirCola(); 
        
        

    }
    
}
