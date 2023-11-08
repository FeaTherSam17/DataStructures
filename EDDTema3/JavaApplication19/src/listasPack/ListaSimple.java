/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasPack;

/**
 *
 * @author Alumno
 */
public class ListaSimple
{

    private Nodo inicial;

    public Nodo getInicial()
    {
        return inicial;
    }

    public void setInicial(Nodo inicial)
    {
        this.inicial = inicial;
    }

    public boolean empty()
    {
        return (getInicial() == null);
    }

    public void insert(Nodo dato)
    {
        
        if (empty())
        {
            setInicial(dato);
                
        } else
        {
            Nodo aux = getInicial();
                
            while (aux.getSig() != null)
            {
                aux = aux.getSig();
                
            }
            aux.setSig(dato);
            
        }
        
    }
    
    
    public Nodo remove(){
        Nodo aux = getInicial();               
        setInicial(aux.getSig());
        return aux;
    }
    
    
    /*
    beto
    ana
    zita
    carlos
    
    */
    

}
