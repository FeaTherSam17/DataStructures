/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaPack;

/**
 *
 * @author Polly
 */
public class Nodo {
    
    //Atributos del nodo
    private Object dato;
    private Nodo siguiente;
    
    public Nodo(Object dato){
        this.dato = dato;
        siguiente=null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
    
    
    
}
