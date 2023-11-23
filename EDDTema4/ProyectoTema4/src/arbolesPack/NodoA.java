/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesPack;

import packSucursal.Sucursal;

/**
 *
 * @author Polly
 */
public class NodoA {
    
    
    private Sucursal sucursal;
    private NodoA hizq, hder;
    
    //CONSTRUCTOR
    public NodoA(Sucursal sucursal){
        this.sucursal = sucursal;
        hizq = null;
        hder = null;
    }
    
    
    public Sucursal getSucursal()
    {
        return sucursal;
    }

    //GET Y SET
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public NodoA getHizq() {
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
