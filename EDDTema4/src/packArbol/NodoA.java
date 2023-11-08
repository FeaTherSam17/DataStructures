/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packArbol;

/**
 *
 * @author Alumno
 */
public class NodoA
{
    private char clave;
    private float cantidad;
    private String nombre;
    private NodoA hizq, hder;
    
    //CONSTRUCTOR
    public NodoA(char clave, float cantidad, String nombre){
        this.cantidad= cantidad;
        this.clave=clave;
        this.nombre = nombre;
        hizq = null;
        hder = null;
    }

       
    //GET Y SET
    public char getClave()
    {
        return clave;
    }

    public void setClave(char clave)
    {
        this.clave = clave;
    }

    public float getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(float cantidad)
    {
        this.cantidad = cantidad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public NodoA getHizq()
    {
        return hizq;
    }

    public void setHizq(NodoA hizq)
    {
        this.hizq = hizq;
    }

    public NodoA getHder()
    {
        return hder;
    }

    public void setHder(NodoA hder)
    {
        this.hder = hder;
    }
    
    
    
    
    
    
    
    
}
