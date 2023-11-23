/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDobleEnlazada;

import Pedidos.Pedido;

/**
 *
 * @author Polly
 */
public class NodoDoble {
    private Pedido info;
    private NodoDoble siguiente;
    private NodoDoble anterior;
    
    //La lista doblemente enlazada requiere de un nodo con 2 atributos
    public void setSiguiente(NodoDoble siguiente){
        this.siguiente = siguiente;
    }
    public void setAnterior(NodoDoble anterior){
        this.anterior = anterior;
    }
    public NodoDoble getSiguiente(){
        return siguiente;
    }
    public NodoDoble getAnterior(){
        return anterior;
    }
    public void setInfo(Pedido info){
        this.info = info;
    }
    public Pedido getInfo(){
        return info;
    }
    
    
}
