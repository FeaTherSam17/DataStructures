/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasPack;

/**
 *
 * @author Alumno
 */
public class Pila
{
    private Object P[];
    private int tope;

    public Pila(int tam)
    {
        tope = -1;
        P = new Object[tam];
    }
    
    //METODOS
   public void push(Object dato) {
       tope++;
       P[tope]=dato;       
   }
   
   public Object pop(){
       Object dato;
       dato=P[tope];
       tope--;
//tope--;
       //System.out.println("valor "+tope);
       return dato;
   }
   
   public Object stackTop(){
       return P[tope];
   }
    
   public boolean empty(){
       if(tope==-1){
           return true;
       }else
           return false; // XD
   }
   
   public boolean full(){
       if(tope==P.length-1){
         return true;  
       }else
           return false;
       
   }
    
   
   
   
   
   
   
   
   
   
   
}
