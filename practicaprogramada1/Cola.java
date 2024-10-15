
package practicaprogramada1;

public class Cola {
    private NodoC frente; 
    private NodoC ultimo;    

    public Cola() {
        this.frente = null;
        this.ultimo = null;
    }

    
    public void encolar(int dato) {
        NodoC nuevoNodo = new NodoC(dato);
        if (ultimo != null) {
            ultimo.setSiguiente(nuevoNodo); 
        }
        ultimo = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo; 
        }
    }

    public void imprimirCola() {
        NodoC actual = frente;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void ordenarCola() {
        if (frente == null || frente.getSiguiente() == null) return;

        boolean ordenar;
        do {
            ordenar = true;
            NodoCola actual = frente;
            NodoCola anterior = null;

            while (actual != null && actual.getSiguiente() != null) {
                NodoC siguiente = actual.getSiguiente();

                if (actual.getDato() > siguiente.getDato()) {
                    ordenado = false;
                    int camb = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(camb);
                }

                anterior = actual;
                actual = siguiente;
            }
        } while (!ordenar); 
    }
}


