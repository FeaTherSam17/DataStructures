/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesPack;

import ListaDobleEnlazada.ListaDE;
import ListaDobleEnlazada.NodoDoble;
import ListaPack.Lista;
import ListaPack.Nodo;
import packSucursal.Sucursal;

/**
 *
 * @author Polly
 */
public class Arbol {

    private NodoA raiz;

    //CONSTRUCTOR
    public Arbol() {
        this.raiz = null;
    }

    //GETTERS AND SETTERS
    public NodoA getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoA raiz) {
        this.raiz = raiz;
    }

    //METODOS U OPERACIONES DEL ARBOL
    public boolean empty() {
        return (getRaiz() == null);
    }

    public NodoA busqueda(NodoA raiz, String nombre) {
        NodoA aux = raiz;
        if (aux == null) {
            return null;
        } else {
            if (aux.getSucursal().getNombre().equals(nombre)) {
                return aux;
            } else {
                if (nombre.compareTo(aux.getSucursal().getNombre()) <= 0) {
                    aux = busqueda(aux.getHizq(), nombre);
                } else {
                    aux = busqueda(aux.getHder(), nombre);
                }

            }

            return aux;
        }

    }

    public double sumarImporte(Sucursal sucursal) {
        NodoDoble aux = sucursal.getListaPedidos().getInicio().getAnterior();
        ListaDE listaDe = sucursal.getListaPedidos();
        double importe = 0;
        if (listaDe.empty()) {
            return importe;
        } else {
            do {

                importe = importe + aux.getSiguiente().getInfo().getImporte();
                aux = aux.getSiguiente();
            } while (sucursal.getListaPedidos().getInicio() != aux.getSiguiente());

        }
        return importe;

    }

    public void insert(Sucursal sucursal) {//Inserta un nodo en el arbol, ese nodo contendra una sucursal
        NodoA nodo = new NodoA(sucursal);
        int nivel = nodo.getSucursal().getCodigo(); //Inicialmente esta en el nivel 0

        if (empty())//Si esta vacio se inserta la raiz
        {
            setRaiz(nodo);

        } else {// Si no esta vacio se hace la comparacion

            NodoA aux = getRaiz();

            do {
                if (nodo.getSucursal().getNombre().compareTo(aux.getSucursal().getNombre()) < 0) {// Se inserta a la izquierda del nodo
                    if (aux.getHizq() == null) {
                        nivel++; // si se inserta por la izquierda aumenta el nivel
                        System.out.println(nivel);
                        nodo.getSucursal().setCodigo(nodo.getSucursal().getCodigo() + nivel);

                        aux.setHizq(nodo);

                        System.out.println("Insertado por la Izquierda");
                    } else {
                        aux = aux.getHizq();
                        nivel++;
                    }
                } else {//Se inserta a la derecha del nodo
                    if (aux.getHder() == null) {
                        nivel++;
                        nodo.getSucursal().setCodigo(nodo.getSucursal().getCodigo() + nivel);

                        aux.setHder(nodo);

                        System.out.println("Insertado por la Derecha");
                    } else {
                        aux = aux.getHder();
                        nivel++;
                    }
                }
            } while (aux.getHder() != nodo && aux.getHizq() != nodo);

        }

    }

    public NodoA remove(String nombre) {
        NodoA aux = getRaiz(), aux2 = getRaiz();
        
        //aux2 ES EL PADRE 
        
        if (aux.getSucursal().getNombre().equals(nombre)) {
            if (aux.getHder()== null && aux.getHizq()== null) {//solo existe la raiz
                setRaiz(null);
                return aux;
            }else
                return null;
        }
        
        
        
        
            /*-----------------Cuando no es la raiz---------------------*/
        
        while (aux != null && !nombre.equals(aux.getSucursal().getNombre())) {
            aux2 = aux;
            if (nombre.compareTo(aux.getSucursal().getNombre()) < 0)//IZQUIERDA
            {
                aux = aux.getHizq();
            } else {
                aux = aux.getHder();
            }
        }

        if (aux == null) {
            return null;
        }
/*----------------------------------------------------------------------
--------Casos de la eliminacion------------------------------------------*/

        NodoA eliminado;
        //CASO HOJA (CASO 1)
        
        if (aux.getHizq() == null && aux.getHder() == null) {
            eliminado = eliminarHoja(aux, aux2);// LLAMA AL METODO eliminarHoja ANTES YA DEFINIDO        
            subirNivel(eliminado);
            return eliminado;
        }
        //CASO DE UN SOLO HIJO (CASO 2)
        if (aux.getHizq() == null || aux.getHder() == null) {//SI LOS 2 SE CUMPLEN ENTRA EN EL CASO 1

            eliminado = eliminarUnHijo(aux, aux2);// LLAMA AL METODO eliminarHoja ANTES YA DEFINIDO        
            subirNivel(eliminado);
            return eliminado;

        }
        

        //CASO CON DOS HIJOS (CASO 3)

        
        //CASO CON DOS HIJOS (CASO 3)

        
        if (aux.getHder().getHizq() == null)//SI NO TIENE HIJO IZQUIERDO NO SE RECORRE LA RAMA IZQUIERDA
        {

            aux.getHder().setHizq(aux.getHizq());//ASIGNA EL HIJO DEL NODO ELIMINADO AL NODO DE LA DERECHA
            setRaiz(aux.getHder());

        } else {//EN CASO DE QUE SI TENGA HIJOS el izquierdo
            NodoA temporal, temporal2,padreNodoElim;
            temporal = aux.getHder();
            padreNodoElim =temporal2 = temporal;

            while (temporal.getHizq() != null) {
                // temporal2=temporal;//ASIGNACION A temporal2 EL NODO ANTERIOR A TEMPORAL
                padreNodoElim = temporal;
                temporal = temporal.getHizq(); // AVANCE DEL TEMPORAL                                
            }
            //SALE CUANDO YA SE ENCUENTRA EN EL ULTIMO NODO
            subirNivel(temporal);
            temporal.getSucursal().setCodigo(aux.getSucursal().getCodigo());//cambio de nivel
            
            temporal.setHizq(aux.getHizq());
            padreNodoElim.setHizq(temporal.getHder());
            //setRaiz(temporal);
           temporal.setHder(padreNodoElim);
            
            //OTRA COMPARACION PARA CONOCER CUAL NODO ES (IZQUIERDO O DERECHO)
            if (aux2.getHizq() == aux)//SE ENCUENTRA EN LA PARTE IZQUIERDA
            {
                
                aux2.setHizq(temporal);
            } else {//SE ENCUENTRA EN LA PARTE DERECHA
                aux2.setHder(temporal);
            }
           
            
            
            

        }
        
        
        
        return aux;
        
        
    }

    private NodoA eliminarHoja(NodoA aux, NodoA aux2) {
        if (aux2.getHizq() == aux) {
            aux2.setHizq(null);

        } else {
            aux2.setHder(null);
        }

        return aux;//Retorna el elemento eliminado

    }

    private NodoA eliminarUnHijo(NodoA aux, NodoA aux2) {

        if (aux2.getHizq() == aux)//ES EL HIJO IZQUIERDO
        {
            if (aux.getHizq() != null) {
                aux2.setHizq(aux.getHizq());
            } else {
                aux2.setHizq(aux.getHder());
            }
        } else {
            if (aux.getHizq() != null) {
                aux2.setHder(aux.getHizq());
            } else {
                aux2.setHder(aux.getHder());
            }
        }
        return aux;
    }

    public void inorden(NodoA nodo) {
        if (nodo != null) {
            inorden(nodo.getHizq());
            System.out.println("Nombre: " + nodo.getSucursal().getNombre() + "");
            System.out.println("Nivel: " + nodo.getSucursal().getCodigo());
            System.out.println("Zona geografica: " + nodo.getSucursal().getZonaG());
            System.out.println("Total de ventas mensuales: " + nodo.getSucursal().getImporteT());
            System.out.println("");
            inorden(nodo.getHder());

        }
    }

    public void recorrerAnchura(NodoA nodo) {
        if (empty()) {
            System.out.println("Arbol vacio");
        } else {
            Nodo cabeza = new Nodo(nodo); // Nodo cabeza de la cola
            Lista lista = new Lista(); //Creacion de la lista donde se guardaran los nodos
            NodoA aux = nodo;// nodo aux <3
            NodoA datoFinal;
            lista.insert(aux);

            while (!lista.empty()) {

                aux = (NodoA) lista.remove().getDato();

                if (aux.getHizq() != null && aux.getHder() != null) {
                    lista.insert(aux.getHizq());
                    lista.insert(aux.getHder());

                } else if (aux.getHizq() != null) {
                    lista.insert(aux.getHizq());

                } else if (aux.getHder() != null) {
                    lista.insert(aux.getHder());

                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Estado: " + aux.getSucursal().getCodigo() + " ");
                System.out.println("Nombre: " + aux.getSucursal().getNombre() + " ");
                System.out.println("Zona Geografica: " + aux.getSucursal().getZonaG() + " ");
                System.out.println("Total de ventas mensuales: " + aux.getSucursal().getImporteT() + " ");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("");

            }

        }

    }

    public void subirNivel(NodoA nodo) {
        //Este metodo recorre los hijos de un nodo dado para aumentar el nivel luego de ser eliminado el padre
        /*
         Nota: al eliminar un nodo padre(que tenga hijos) la posicion de sus hijos se vera afectada segun
         los casos de eliminacion distintos, aun asi funciona el metodo
         Que hace? 
         Recorre los hijos del nodo dado cambiandoles de nivel, en este caso lo reduce  5 --> 4
         
         */
        if (nodo != null) {
            subirNivel(nodo.getHizq());
            nodo.getSucursal().setCodigo(nodo.getSucursal().getCodigo() - 1);
            subirNivel(nodo.getHder());
        }

    }
    
    

}
