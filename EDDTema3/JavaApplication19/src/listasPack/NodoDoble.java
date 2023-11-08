/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasPack;

/**
 *
 * @author Alumno
 */
public class NodoDoble
{
    private Object info; // informacion
    private NodoDoble sig, ant; // Referencias
    
    public NodoDoble(Object info){
        this.info = info;
        sig=ant=null;              
    }

    public Object getInfo()
    {
        return info;
    }

    public void setInfo(Object info)
    {
        this.info = info;
    }

    public NodoDoble getSig()
    {
        return sig;
    }

    public void setSig(NodoDoble sig)
    {
        this.sig = sig;
    }

    public NodoDoble getAnt()
    {
        return ant;
    }

    public void setAnt(NodoDoble ant)
    {
        this.ant = ant;
    }
    
    
    
    
}
