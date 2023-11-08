/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasPack;

/**
 *
 * @author Alumno
 */
public class Nodo {

    private Object info;
    private Nodo sig;

    public Nodo(Object info) {
        this.info = info;
        sig = null;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getInfo() {
        return info;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getSig() {
        return sig;
    }
}
