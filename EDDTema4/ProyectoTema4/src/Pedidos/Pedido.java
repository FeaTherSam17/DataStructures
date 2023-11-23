/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedidos;

/**
 *
 * @author Polly
 */
public class Pedido {
    /*
    Cada pedido cuenta con los siguientes datos:
a)	Número de pedido (Entero corto)
b)	Importe (Doble)
c)	Producto (Cadena)
d)	Número de Cliente (Entero corto)
    */
    
    private short noPedido;
    private double importe;
    private String producto;
    private short noCliente;
    

    
    public short getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(short noPedido) {
        this.noPedido = noPedido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public short getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(short noCliente) {
        this.noCliente = noCliente;
    }

    
    
    
    
    
    
    
    
    
    
    
}
