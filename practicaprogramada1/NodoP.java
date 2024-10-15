/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada1;

/**
 *
 * @author sebas
 */
public class NodoP {
    private DatoC elemento; // Almacena el dato de tipo DatoC
    private NodoP siguiente; // Referencia al siguiente nodo

    public NodoP() {
        this.siguiente = null; // Inicializa el siguiente nodo como nulo
    }

    public NodoP(DatoC elemento, NodoP siguiente) {
        this.elemento = elemento; // Inicializa el elemento
        this.siguiente = siguiente; // Inicializa el siguiente nodo
    }

    public DatoC getElemento() {
        return elemento; // Retorna el elemento
    }

    public void setElemento(DatoC elemento) {
        this.elemento = elemento; // Establece el elemento
    }

    public NodoP getSiguiente() {
        return siguiente; // Retorna el siguiente nodo
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente; // Establece el siguiente nodo
    }
}


