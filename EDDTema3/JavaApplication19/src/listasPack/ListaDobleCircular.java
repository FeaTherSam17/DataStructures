/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasPack;

import exceptionsPack.ExcepcionPers;

/**
 *
 * @author Alumno
 */
public class ListaDobleCircular
{
    private NodoDoble inicio;

    
    
    public NodoDoble getInicio()
    {
        return inicio;
    }

    public void setInicio(NodoDoble inicio)
    {
        this.inicio = inicio;
    }
    
    public boolean empty(){
        
        return inicio==null;
        
    }
    
    public void insert(NodoDoble dato){
        
        if (empty())
        {
            setInicio(dato);
            inicio.setAnt(dato);
            inicio.setSig(dato);
        }else{
            /*HAY CASOS A CONSIDERAR COMO CUANDO ES AL INICIO DE LA LISTA, AL FINAL DE ELLA O EN MEDIO */
            //CUANDO ESTA AL INICIO DE LA LISTA
            
            if(dato.getInfo().toString().compareTo(getInicio().getInfo().toString())<=0){
                dato.setSig(getInicio());
                dato.setAnt(getInicio().getAnt());                
                getInicio().setAnt(dato);
                dato.getAnt().setSig(dato);
                
                setInicio(dato);
                
                //CUANDO ESTA AL FINAL DE LA LISTA
            }else if (dato.getInfo().toString().compareTo(getInicio().getAnt().getInfo().toString())>0){
                dato.setSig(getInicio());
                dato.setAnt(getInicio().getAnt());
                getInicio().getAnt().setSig(dato);
                getInicio().setAnt(dato);
                
                //No se modifica el inicio pues sigue siendo el mismo
                
                
            }else{//PARA CUANDO SE TIENE QUE INSERTAR EN MEDIO DE LA LISTA
                NodoDoble aux=inicio;
                while(dato.getInfo().toString().compareTo(aux.getInfo().toString())> 0){
                    aux=aux.getSig();
                    
                }//CICLO QUE RECORRE LA LISTA EN BUSCA DE UN VALOR MAYOR
                
                        dato.setSig(aux);
                        dato.setAnt(aux.getAnt());
                        aux.getAnt().setSig(dato);
                        aux.setAnt(dato);
                 
                
            }
        }
        
        
        
         
    }
    /*
    public void despliegue(){
        NodoDoble aux=getInicio();
        
        do{
            System.out.println(aux.getInfo().toString());
            
            aux=aux.getSig();
        }while(getInicio()!=aux.getSig());
           
         
        System.out.println(aux.getInfo().toString());
    }
*/
    public void despliegue(){
        NodoDoble aux=getInicio().getAnt();
        
        do{
            System.out.println(aux.getSig().getInfo().toString());
            
            aux=aux.getSig();
        }while(getInicio()!=aux.getSig());
                    
        //System.out.println(aux.getInfo().toString());
    }
    
    
    
    public NodoDoble busqueda(String nombre){
        NodoDoble aux = getInicio();
        
        if (aux.equals(aux.getSig())) //Si es un solo elemento
        {
            if (inicio.getInfo().toString().equals(nombre))
            {
                return aux;
            }else
                return null;
        }else{
            while(aux!=aux.getSig() && !aux.getInfo().toString().equals(nombre)){
                aux=aux.getSig();
                
            }
           
            if (aux.getInfo().toString().equals(nombre))
            {
                return aux;
            }else
                return null;
            
            
            
        }
        
        
        
    }
    
    
    public NodoDoble eliminar(String nombre){
        if(busqueda(nombre) != null){
            NodoDoble aux=busqueda(nombre);
            
            //4 casos
            if (aux==aux.getSig())//UNICO ELEMENTO
            {
                aux.setSig(null);
                aux.setAnt(null);
                setInicio(null);
                return aux;
                
                
            }else{
                if (aux.equals(inicio))//INICIO DE LA LISTA
                {
                    aux.getSig().setAnt(aux.getAnt());
                    aux.getAnt().setSig(aux.getSig());
                    setInicio(aux.getSig());
                    return aux;
                    
                }else if (aux.equals(getInicio().getAnt()))// FINAL DE LA LISTA
                {
                    aux.getAnt().getAnt().setSig(aux);
                    aux.setAnt(aux.getAnt().getAnt());
                    return aux;
                    
                }else{//EN MEDIO DE LA LISTA
                    
                    aux.getAnt().setSig(aux.getSig());
                    aux.getSig().setAnt(aux.getAnt());
                    return aux;
                    
                }
            }

        }else
            return null;
        
    }
    
    
    
    
}
