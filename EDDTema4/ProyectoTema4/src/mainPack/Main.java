/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPack;

import arbolesPack.Arbol;
import arbolesPack.NodoA;
import exceptionPack.MyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import packSucursal.Sucursal;

/**
 *
 * @author Polly
 */
public class Main {

    public static void main(String[] args) throws IOException, MyException {
        //VARIABLES
        int opcion = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean error = true;
        Arbol arbol = new Arbol();

        while (opcion != 6) {//Menu

            
            do{//Ciclo que gestiona el error
                
            
            
            System.out.println("------------------------Bienvenido al menu de opciones de la sucursal------------------------");
            System.out.println("---------------Ingrese una de las siguientes opciones para realizar una accion--------------------");
            System.out.println("1. Agregar sucursal.");
            System.out.println("2. Eliminar sucursal.");
            System.out.println("3. Desplegar sucursales en orden alfabetico.");
            System.out.println("4. Menu de pedidos de una sucursal");
            System.out.println("5. Desplegar sucursales por codigo de estado (nivel)");
            System.out.println("6. Salir");
            try{
            opcion = Integer.parseInt(br.readLine());
            error = false;
            }catch(Exception e){
                error = true;
                System.out.println("!!!!!!!            Error en el dato de entrada               !!!!!!!");
                System.out.println("             Por favore ingrese una de las opciones");
                System.out.println("");
            }
            
            
            }while(error==true);
            switch (opcion) {

                case 1 -> {//Agregar sucursal (No puede haber sucursales iguales)

                    /*Metodo para buscar la sucursal en el arbol
                    si no se encuentra se inserta y si se encuentra no se agrega
                     */
                    System.out.println("**************** Agregar sucursal *************************");
                    System.out.println("Ingrese el nombre de la sucursal");
                    String nombreS = br.readLine().toUpperCase();
                    if (arbol.busqueda(arbol.getRaiz(), nombreS) == null) {
                        //Se agrega en un arbol por medio del nombre
                        Sucursal sucursal;

                        System.out.println("Ingrese la zona");
                        char zonaG = br.readLine().toUpperCase().charAt(0);

                        sucursal = new Sucursal(nombreS, zonaG);
                        //Se agrega la sucursal al arbol
                        arbol.insert(sucursal);
                        System.out.println("--------Sucursal: "+nombreS+" agregada correctamente------");
                        System.out.println("");
                        
                        
                        
                    } else {
                        System.out.println("La sucursal ya existe");
                    }

                }

                case 2 -> {//Eliminar sucursal (Solo si no tiene pedidos)  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                    //Se valida si existen sucursales
                    System.out.println("**************** Eliminar sucursal *************************");
                    if (arbol.empty()) {
                        System.out.println("No existen sucursales");
                        System.out.println("");
                    } else {
                        System.out.println("Ingresa el nombre de la sucursal a eliminar");
                        String nombre = br.readLine().toUpperCase();

                        /*
                    Metodo para buscar la sucursal, si se encuentra se hace una validacion de pedidos
                    si no tiene se elimina, si tiene, no                    
                         */
                        NodoA nodo = arbol.busqueda(arbol.getRaiz(), nombre);
                        if (nodo == null) {//Condicional para buscar la sucursal a eliminar
                            System.out.println("La sucursal no existe");
                        } else {

                            if (nodo.getSucursal().getListaPedidos().empty()) {//Si la sucursal tiene una lista vacia se elimina
                                NodoA eliminado = arbol.remove(nombre);
                                if (eliminado == null) {
                                    System.out.println("!       ATENCION        !");
                                    System.out.println("No es posible eliminar a la raiz ");
                                    System.out.println("");
                                }else{
                                    System.out.println("Sucursal: " + eliminado.getSucursal().getNombre() + " eliminada");
                                }
                                

                            } else {
                                System.out.println("");
                                System.out.println("No es posible eliminar la sucursal porque tiene una lista de pedidos");
                                System.out.println("");
                            }

                        }

                    }

                }

                case 3 -> {// Desplegar sucursales en orden alfabetico.
                    //El catalogo contien Nombre de la sucursal, Zona greografica y Total de ventas mensuales

                    //Validar si el arbol esta vacio
                    if (arbol.empty()) {
                        System.out.println("        !No hay sucursales registradas!     ");
                    } else {
                        System.out.println("**************** Despliegue de sucursales *************************");
                        System.out.println(arbol.getRaiz().getSucursal().getNombre());
                        arbol.inorden(arbol.getRaiz());
                    }

                }

                case 4 -> {//Menu de pedidos de una Sucursal
                    System.out.println("**************** Menu de una sucursal *************************");
                    System.out.println("Ingresa el nombre de la sucursal");
                    String nombre = br.readLine().toUpperCase();
                    //Metodo para buscar la sucursal
                    NodoA nodo = arbol.busqueda(arbol.getRaiz(), nombre);
                    if (nodo != null) {//Si la encuentra de abre el menu de opciones de la sucursal
                        System.out.println("**************** Entrando... *************************");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        nodo.getSucursal().getMenu().menu(nodo);//Esto inserta la lista al nodo 
                        nodo.getSucursal().setImporteT(nodo.getSucursal().getListaPedidos().getImporteTotal());

                    } else {
                        System.out.println("Sucursal no encontrada");
                    }

                }

                case 5 -> {//Desplegar Sucursales por codigo de estado(nivel). El catalogo contiene:        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    //Estado, Nombre del al sucursal, Zona geografica, y Total de ventas mensuales
                    if (arbol.empty()) {
                        System.out.println("Arbol vacio");
                    }else{
                        System.out.println("**************** Desplegar Sucursales por codigo de estado (nivel) *************************");
                        arbol.recorrerAnchura(arbol.getRaiz());
                    }
                    //Despliege por medio del nivel, con el metodo del arbol :)
                }

                case 6 -> {
                    System.out.println("Saliendo...");
                }

                default -> {
                    System.out.println("Opcion no valida");
                }

            }

        }

    }
}
