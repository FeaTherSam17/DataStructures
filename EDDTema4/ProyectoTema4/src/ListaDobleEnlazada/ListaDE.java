/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDobleEnlazada;

import exceptionPack.MyException;

/**
 *
 * @author Polly
 */
public class ListaDE {

    //Nodo que sirve de enlace
    private NodoDoble inicio;
    private double importeTotal = 0.0;
   

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
    
    

    //OPERACIONES DE LA LISTA DOBLEMENTE ELAZADA
    public boolean empty() {     //VERIFICA SI LA LISTA ESTA VACIA
        return inicio == null;
    }

    public void insert(NodoDoble dato) throws MyException { // METODO PARA LA INSERTAR DATOS EN LA LISTA
        /*Hay 4 casos debido a la condicion de problema:
        -Cuando la lista esta vacia
        -Cuando el dato se debe posicionar al principio
        -Cuando el dato se debe posicionar al final 
        -Cuando el dato se debe colocar en medio*/
        if (empty()) {  //PARA LA LISTA VACIA

            setInicio(dato);
            inicio.setAnterior(dato);
            inicio.setSiguiente(dato);

        } else {//PARA LOS OTROS 3 CASOS

            if (dato.getInfo().getNoPedido() <= getInicio().getInfo().getNoPedido()) {//PARA CUANDO SE DEBA COLOCAR AL INICIO
                dato.setSiguiente(getInicio());
                dato.setAnterior(getInicio().getAnterior());
                getInicio().setAnterior(dato);
                dato.getAnterior().setSiguiente(dato);

                setInicio(dato);

            } else if (dato.getInfo().getNoPedido() > inicio.getAnterior().getInfo().getNoPedido()) {//CUANDO SE DEBA PONER AL FINAL

                dato.setSiguiente(getInicio());
                dato.setAnterior(getInicio().getAnterior());
                getInicio().getAnterior().setSiguiente(dato);
                getInicio().setAnterior(dato);

            } else {//SI EL DATO DEBE COLOCARSE EN MEDIO

                NodoDoble aux = inicio;
                while (dato.getInfo().getNoPedido() > aux.getInfo().getNoPedido()) {//Se emplea un ciclo para recorrer la lista
                    aux = aux.getSiguiente();
                }
                dato.setSiguiente(aux);
                dato.setAnterior(aux.getAnterior());
                aux.getAnterior().setSiguiente(dato);
                aux.setAnterior(dato);
            }
        }
        calcularImporteTotal();
        
    }

    public NodoDoble busqueda(int noPedido) throws MyException {
        if (inicio == null) {
            return null;
        } else {
            if (inicio == inicio.getSiguiente()) {
                if (inicio.getInfo().getNoPedido() == noPedido) {
                    return inicio;
                } else {
                    return null;
                }

            } else {

                NodoDoble aux = inicio;
                while (inicio != aux.getSiguiente() && (aux.getInfo().getNoPedido() != noPedido)) {

                    aux = aux.getSiguiente();
                }

                if (aux.getInfo().getNoPedido() == noPedido) {
                    return aux;
                } else {
                    return null;
                }

            }
        }

    }

    public NodoDoble delete(int noPedido) throws MyException {//DEBE RETORNAR UN NODO PARA ANUNCIAR CUAL SE ELIMINO

        if (busqueda(noPedido) != null) {
            NodoDoble aux = busqueda(noPedido);
            //HAY VARIOS CASOS
            /*
            1. CUANDO EXISTA UN SOLO ELEMENTO
            2. CUANDO ESTE AL INICIO
            3. CUANDO ESTE AL FINAL
            4. CUANDO ESTE EN MEDIO
             */
            if (inicio == inicio.getSiguiente()) {//unico elemento
                inicio.setSiguiente(null);  //:)
                inicio.setAnterior(null);
                setInicio(null);
                calcularImporteTotal();
                return aux;
            } else {
                if (aux.equals(inicio)) {//Si se encuentra en el inicio de la lista

                    aux.getSiguiente().setAnterior(aux.getAnterior());
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    setInicio(aux.getSiguiente());
                    calcularImporteTotal();
                    return aux;

                } else if (aux == inicio.getAnterior()) {//Si se encuentra en el final de la lista

                    aux.getAnterior().setSiguiente(inicio);
                    inicio.setAnterior(aux.getAnterior());
                    calcularImporteTotal();
                    return aux;

                } else {//Si se encuentra en medio de la lista
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    calcularImporteTotal();
                    return aux;
                }
            }

        } else {//SI ESTA VACIA
            return null;
        }

    }

    public void despliegue() throws MyException {

        if (empty()) {
            throw new MyException("Lista vacia");
        } else {

            try {
                NodoDoble aux = getInicio().getAnterior();
                do {

                    System.out.println("***************************************************");
                    System.out.println("No. de pedido: " + aux.getSiguiente().getInfo().getNoPedido());
                    System.out.println("Importe:" + aux.getSiguiente().getInfo().getImporte());
                    System.out.println("Producto: " + aux.getSiguiente().getInfo().getProducto());
                    System.out.println("No. de Cliente: " + aux.getSiguiente().getInfo().getNoCliente());
                    System.out.println("***************************************************");
                    System.out.println("");

                    aux = aux.getSiguiente();
                } while (getInicio() != aux.getSiguiente());
            } catch (Exception e) {
                throw new MyException("Lista vacia");
            }
        }
    }

    public double calcularImporteTotal() throws MyException{
        setImporteTotal(0);
        if (empty()) {
            throw new MyException("Lista vacia");
        } else {

            try {
                NodoDoble aux = getInicio().getAnterior();
                do {
                    //System.out.println(getImporteTotal()+" importe");
                    setImporteTotal(aux.getInfo().getImporte()+getImporteTotal());
                    aux = aux.getSiguiente();
                } while (getInicio() != aux.getSiguiente());
            } catch (Exception e) {
                throw new MyException("Lista vacia");
            }
        }
        
        return getImporteTotal();
        
    }
   

    
}
