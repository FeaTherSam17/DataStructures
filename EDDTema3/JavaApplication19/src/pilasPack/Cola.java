/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasPack;

/**
 *
 * @author Alumno
 */
public class Cola
{
    private int frente;
    private int fin;
    private Object c[];
    
    public Cola(int tam){
        fin=-1;
        frente=-1;
        c = new Object[tam];
    }
    
    
    public boolean empty(){
        return (frente==-1)&&(fin==-1);
    }
    
    public boolean full(){
        return ((fin==c.length-1)&&(frente==0))||(fin==frente-1);
    }
    
    public void insertQ(Object dato){
        //System.out.println("vacio"+empty());
        if (empty())
        {
            frente++;
            fin++;
            //c[fin]=dato;
            
        }else if (fin==c.length-1)
        {
            fin=0;
            //c[fin]=dato;
            
        }else{
            fin++;
            //c[fin]=dato;
            
        }
        c[fin]=dato;
    }
    
    
    public Object removeQ(){
        Object datoA=null;
        
        if (frente==fin)
        {
            datoA=c[frente];
            frente=fin=-1;
            //System.out.println(frente);
        }else if (frente==c.length-1){
            datoA=c[frente];
            frente =0;
            //System.out.println(frente);
            
        }else{
            datoA=c[frente];
            frente ++;
            //System.out.println(frente);
        } 
        
        
        return datoA;

    }
    
    public int tope(){
        return fin;
    }
    
    
}
