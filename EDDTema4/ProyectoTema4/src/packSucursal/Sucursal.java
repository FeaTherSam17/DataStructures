/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packSucursal;

import ListaDobleEnlazada.ListaDE;
import menuPedidosPack.MenuPedidos;

/**
 *
 * @author Polly
 */
public class Sucursal {
    //atributos
    private String nombre;
    private int codigo;
    private char ZonaG ;
    private ListaDE listaPedidos;
    private double importeT;
    private MenuPedidos menu;
    
    
    //Constructor
    public Sucursal(String nombre, char ZonaG){
        this.nombre=nombre;
        this.ZonaG=ZonaG;       
        
        this.codigo = 0;
        this.listaPedidos = new ListaDE();
        this.importeT=0;
        this.menu = new MenuPedidos();
    }
    
    //GETTERS AND SETTERS
    
    
    
    
    
    //Metodos de la sucursal

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getZonaG() {
        return ZonaG;
    }

    public void setZonaG(char ZonaG) {
        this.ZonaG = ZonaG;
    }

    public ListaDE getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ListaDE listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public double getImporteT() {
        return importeT;
    }

    public void setImporteT(double importeT) {
        this.importeT = importeT;
    }

    public MenuPedidos getMenu() {
        return menu;
    }

    public void setMenu(MenuPedidos menu) {
        this.menu = menu;
    }
    
    
    
    
    
    
    
    
    
    
    
}
