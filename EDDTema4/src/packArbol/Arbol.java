/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packArbol;

/**
 *
 * @author Alumno
 */
public class Arbol
{

    private NodoA raiz;

    public NodoA getRaiz()
    {
        return raiz;
    }

    public void setRaiz(NodoA raiz)
    {
        this.raiz = raiz;
    }

    //METODOS U OPERACIONES DEL ARBOL
    public boolean empty()
    {
        return (getRaiz() == null);
    }

    public void insert(NodoA nodo)
    {
        if (empty())//Si esta vacio se inserta la raiz
        {
            setRaiz(nodo);
        } else
        {// Si no esta vacio se hace la comparacion

            NodoA aux = getRaiz();

            do
            {
                if (nodo.getClave() < aux.getClave())
                {// Se inserta a la izquierda del nodo
                    if (aux.getHizq() == null)
                    {
                        aux.setHizq(nodo);
                        System.out.println("Izquierda");
                    } else
                    {
                        aux = aux.getHizq();
                    }
                } else
                {//Se inserta a la derecha del nodo
                    if (aux.getHder() == null)
                    {
                        aux.setHder(nodo);
                        System.out.println("Derecha");
                    } else
                    {
                        aux = aux.getHder();
                    }
                }
            } while (aux.getHder() != nodo && aux.getHizq() != nodo);

            //  operador o ||                        
        }
    }

    public void preorden(NodoA nodo)
    {
        if (nodo != null)
        {
            System.out.print(nodo.getClave() + " ");
            preorden(nodo.getHizq());
            preorden(nodo.getHder());
        }

    }

    public void postorden(NodoA nodo)
    {
        if (nodo != null)
        {
            postorden(nodo.getHizq());            
            postorden(nodo.getHder());
            System.out.print(nodo.getClave() + "");
        }

    }

    public void inorden(NodoA nodo)
    {
        if (nodo != null)
        {
        inorden(nodo.getHizq());
        System.out.print(nodo.getClave() + "");
        inorden(nodo.getHder());
        
        }
    }
    
    
    
    
    /* 
    public NodoA remove(char clave){
        NodoA aux = getRaiz(),aux2 = getRaiz();       
        
        while( aux!= null && clave != aux.getClave() ){
            aux2=aux;
            if (clave<aux.getClave())//IZQUIERDA
            {
                aux=aux.getHizq();
            }else{
                aux=aux.getHder();
            }            
        }
        
        
        if(aux==null) return null;
        
        //CASO HOJA
        if (aux.getHizq()==null && aux.getHder() == null)
        {
            eliminarHoja(aux,aux2);// 
            
            
        }
        
        
    }
*/ 
    
    public NodoA eliminarHoja(NodoA aux, NodoA aux2){        
        if (aux2.getHizq()==aux)
        {
            aux2.setHizq(null);
            
        }else
            aux2.setHder(null);
            
        return aux;//Retorna el elemento eliminado
        
        
    }
    
    
}



