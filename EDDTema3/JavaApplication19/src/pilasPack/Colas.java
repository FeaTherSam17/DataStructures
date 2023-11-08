/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasPack;

/**
 *
 * @author Polly
 */
public class Colas {

    private Object c[];
    private int fin;
    private int inicio;

    //Metodo constructor 
    public Colas() {

    }

    public Colas(int tam) {
        fin = -1;
        inicio = -1;
        c = new Object[tam];
    }

    //Que metodos tiene la cola?
    //METODO PARA INSERTAR
    public void push(Object dato) {
        if (inicio!=-1) {
            if (fin==c.length-1) {
                fin=0;
                c[fin]=dato;
                
            }else
            {
                fin++;
            c[fin] = dato;
            }
            
            

        } else {
            inicio++;
            fin++;
            c[fin] = dato;

        }

    }

    //METODO PARA ELIMINAR
    public Object pop() {
        Object aux = null;
        
        if (inicio==c.length-1) {

            aux=c[inicio];
            c[inicio]=null;
            inicio =-1;
            
            return aux;
        }else{
            inicio++;
            aux=c[inicio];
            c[inicio]=null;
            //inicio =0;
            
            return aux;
        }

    }

    public boolean empty() {
        return fin == -1;
    }

    public boolean full() {
        return (fin == c.length - 1);
    }

}
