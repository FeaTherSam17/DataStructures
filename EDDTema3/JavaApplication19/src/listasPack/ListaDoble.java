/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasPack;


/**
 *
 * @author Alumno
 */
public class ListaDoble
{
    private NodoDoble frente, ult; // referencia o el inicial

    public NodoDoble getFrente()
    {
        return frente;
    }

    public void setFrente(NodoDoble frente)
    {
        this.frente = frente;
    }

    public NodoDoble getUlt()
    {
        return ult;
    }

    public void setUlt(NodoDoble ult)
    {
        this.ult = ult;
    }
    
        
    public boolean empty(){
        return (frente==null)&&(ult==null);
    }
    
    
    
    public void insert(NodoDoble nodo){ // con referencia y con dato
        if (empty())
        {
            setFrente(nodo);
            setUlt(nodo);
        }else{
            if (nodo.getInfo().toString().compareTo(getFrente().getInfo().toString())>=0)
            {//inicio
                nodo.setSig(getFrente());
                getFrente().setAnt(nodo);
                setFrente(nodo);
            }else{//final
                if (nodo.getInfo().toString().compareTo(getUlt().getInfo().toString())<0)
                {
                    nodo.setAnt(getUlt());
                    getUlt().setSig(nodo);
                    setUlt(nodo);
                    
                }else{//en medio
                    NodoDoble aux = getFrente().getSig();
                    
                    while(nodo.getInfo().toString().compareTo(aux.getInfo().toString())<0){
                        aux=aux.getSig();                        
                    }
                    
                    nodo.setAnt(aux.getAnt());
                    nodo.setSig(aux);                    
                    aux.setAnt(nodo);
                    nodo.getAnt().setSig(nodo);  //Ch0nk4
                    
                }
            }
        } 
    }
    
    
    public void desplegarDescendente() {
        
        if (frente==null) {
            System.out.println("Lista vacia");
        }else{
            NodoDoble aux = frente;
        //System.out.println(frente.getInfo().toString()+" ");
        while(aux.getSig()!=null){
            System.out.println(aux.getInfo().toString()+" ");
            aux=aux.getSig();
            
        }
        }
        System.out.println(ult.getInfo().toString()+" ");
        
        
    }
    
    public void desplegarAscendente() {
        
        if (getFrente()==null) {
            System.out.println("Lista vacia");
        }else{
            NodoDoble aux = getUlt();
            
        //System.out.println(frente.getInfo().toString()+" ");
        while(aux.getAnt()!=null){
            System.out.println(aux.getInfo().toString()+" ");
            aux=aux.getAnt();
            
        }
        }
        System.out.println(frente.getInfo().toString()+" ");
        
        
    }
    
    public NodoDoble busquedaElemento(String dato){
        
        NodoDoble aux = getFrente();
        while(aux!=null && !dato.equals(aux.getInfo().toString())){
            aux=aux.getSig();
        }
        return aux;
        
    }
    
    
    public NodoDoble delete(String dato){
        //busquedaElemento(dato);
        
        if (busquedaElemento(dato)!=null)//VALIDA SI SE ENCONTRO O NO EL DATO A ELIMINAR
        {
            
            //NODO AUXILIAR
            NodoDoble aux = busquedaElemento(dato);
            
            //HABRIA QUE VALIDAR SI EL QUE SE ELIMINA ES EL PRIMERO, EL ULTIMO O EN MEDIO
            
            if(frente.equals(ult)){// SI HAY UN SOLO ELEMENTO
               
                aux = busquedaElemento(dato);
                frente=null; // los nodos al crearse son nulos
                ult=null;
                return aux;
                
            }else if (aux.getAnt()==null){ //SI EL NODO ES EL PRIMERO
                
                //Como el nodo es el primero se trabaja modificando el nodo frente
                
                
                getFrente().setSig(aux.getSig());                          
                aux.getSig().setAnt(getFrente().getAnt());                             
                setFrente(aux.getSig());
                
                return aux;
                
            }else if(busquedaElemento(dato).getSig() == null){//SI EL NODO ES EL ULTIMO
                //aux = busquedaElemento(dato);
                getUlt().setAnt(aux.getAnt());
                aux.getAnt().setSig(aux.getSig());
                
                //ult.s
                setUlt(aux.getAnt());
               return aux;
            }else{//SI EL NODO ESTA ENTRE 2 NODOS
                //Hace el intercambio de apuntadores 
                
                aux.getSig().setAnt(aux.getAnt());
                aux.getAnt().setSig(aux.getSig());
                
                
                return aux;
                
            }
              
        }else{
            return null;
        }
        
    }
    
    
    
    
    
    
    
    
}
