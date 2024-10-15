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
    private DatoC elemento; 
    private NodoP siguiente; 

    public NodoP() {
        this.siguiente = null; 
    }

    public NodoP(DatoC elemento, NodoP siguiente) {
        this.elemento = elemento; 
        this.siguiente = siguiente; 
    }

    public DatoC getElemento() {
        return elemento; 
    }

    public void setElemento(DatoC elemento) {
        this.elemento = elemento; 
    }

    public NodoP getSiguiente() {
        return siguiente; 
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente; /
    }
}


