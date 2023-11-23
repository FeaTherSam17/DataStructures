/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaPack;

/**
 *
 * @author Polly
 */
public class Lista {
    private Nodo cabeza;
    
    //constructor
    public Lista(){
        cabeza = null;
    }
    
    // Metodos de la lista
    
    public boolean empty(){
        return cabeza == null;
    }
    
    public void insert(Object dato1){
        Nodo dato = new Nodo (dato1);
        //Si la lista esta vacia
        if (empty()) {
            this.cabeza = dato;
            //this.cabeza.setSiguiente(dato);
        }else{
            //Se ocupa un ciclo para encontrar el fin de la lista
            Nodo aux = cabeza;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(dato);
        }        
    }
    
    /* NO SE OCUPA PORQUE EN LA LISTA  / COLA SE ELIMINA EL INICIO XD
    public Nodo remove(Nodo dato){
        if (empty()) {
            return null;
        }else{
            Nodo aux= cabeza;
            while(aux.getSiguiente()!=null && aux!=dato){ // se recorre la lista o hasta que encuentre el nodo
                aux=aux.getSiguiente();
            }
            if (aux==dato) {//If que valida en que caso esta. si lo encontro o no
                cabeza.setSiguiente(aux);
                return aux;
            }else
                return null;
            
            
            
            
        }
    }
    */
    
    public Nodo remove(){
        if (empty()) {
            return null;
        }else{
            Nodo aux=cabeza;
            cabeza = aux.getSiguiente();
            return aux;            
        }
    }
    
    
    
    
    
}
