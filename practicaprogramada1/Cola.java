/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada1;

/**
 *
 * @author sebas
 */
public class Cola {
    private NodoCola frente;  // Primer nodo de la cola
    private NodoCola fin;     // Último nodo de la cola

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    // Método para agregar un elemento a la cola
    public void encolar(int dato) {
        NodoCola nuevoNodo = new NodoCola(dato);
        if (fin != null) {
            fin.setSiguiente(nuevoNodo); // Conecta el nuevo nodo al final de la cola
        }
        fin = nuevoNodo; // Actualiza el nodo final
        if (frente == null) {
            frente = nuevoNodo; // Si la cola estaba vacía, el nuevo nodo es el frente
        }
    }

    // Método para eliminar el elemento al frente de la cola
    public void desencolar() {
        if (frente != null) {
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null; // Si la cola quedó vacía, actualizar fin
            }
        }
    }

    // Método para imprimir los elementos de la cola
    public void imprimirCola() {
        NodoCola actual = frente;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    // Método para ordenar los elementos de la cola de forma ascendente
    public void ordenarCola() {
        if (frente == null || frente.getSiguiente() == null) return; // Cola vacía o con un solo elemento

        boolean ordenado;
        do {
            ordenado = true;
            NodoCola actual = frente;
            NodoCola anterior = null;

            while (actual != null && actual.getSiguiente() != null) {
                NodoCola siguiente = actual.getSiguiente();

                // Si el dato actual es mayor que el siguiente, intercambiarlos
                if (actual.getDato() > siguiente.getDato()) {
                    ordenado = false;
                    // Intercambiar datos de los nodos
                    int temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                }

                // Avanzar al siguiente nodo
                anterior = actual;
                actual = siguiente;
            }
        } while (!ordenado); // Repetir hasta que no haya cambios
    }
}


