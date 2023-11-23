/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPedidosPack;

import ListaDobleEnlazada.ListaDE;
import ListaDobleEnlazada.NodoDoble;
import Pedidos.Pedido;
import arbolesPack.NodoA;
import exceptionPack.MyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Polly
 */
public class MenuPedidos {
  
    private boolean validarArticulo(short noPedido, ListaDE listaDE) throws MyException {
        return listaDE.busqueda(noPedido) != null;

    }

    private void agregarPedido(ListaDE ListaDE, BufferedReader BR) throws MyException {
        NodoDoble nodoD = new NodoDoble();
        short leerNumero;
        double importe;
       
        String producto;
        boolean mistake = true;
        Pedido pedido = new Pedido();

        System.out.println("Ingrese los siguientes datos:");

        while (mistake == true) {
            System.out.println("Numero de pedido: ");

            try {

                leerNumero = Short.parseShort(BR.readLine());

                mistake = false;
                if (validarArticulo(leerNumero, ListaDE) == false) {
                    pedido.setNoPedido(leerNumero);
                } else {
                    System.out.println("Elemento repetido");
                    mistake = true;
                }

            } catch (Exception e) {
                System.out.println("Dato de entrada no aceptado");
                mistake = true;
            }

        }
        mistake = true;

        while (mistake == true) {
            System.out.println("Importe: ");

            try {
                importe = Double.parseDouble(BR.readLine());
                mistake = false;
                
                pedido.setImporte(importe);
               

            } catch (Exception e) {
                System.out.println("Dato de entrada no aceptado");
                mistake = true;
            }
        }
        mistake = true;

        while (mistake == true) {
            System.out.println("Producto: ");

            try {
                producto = BR.readLine();
                mistake = false;
                pedido.setProducto(producto);

            } catch (Exception e) {
                System.out.println("Dato de entrada no aceptado");
                mistake = true;
            }
        }
        mistake = true;

        while (mistake == true) {
            System.out.println("Numero de cliente: ");

            try {
                leerNumero = Short.parseShort(BR.readLine());
                mistake = false;
                pedido.setNoCliente(leerNumero);

            } catch (Exception e) {
                System.out.println("Dato de entrada no aceptado");
                mistake = true;
            }
        }
        nodoD.setInfo(pedido);
        ListaDE.insert(nodoD);
        /*System.out.println(ListaDE.getInicio().getInfo().getProducto());
        System.out.println(ListaDE.getInicio().getAnterior().getInfo().getProducto());*/

    }

    private void consultarOmodificar(int noPedido, ListaDE listaDE, BufferedReader BR) throws MyException, IOException {
        if (listaDE.busqueda(noPedido) != null) {
            //VARIABLES 
            int opcion = -1;
            boolean error = true;
            double importe = 0.0;
            short noCliente=0;
            NodoDoble aux = listaDE.busqueda(noPedido);
            
            

            
            System.out.println("No. de pedido: " + aux.getInfo().getNoPedido());
            System.out.println("Importe:" + aux.getInfo().getImporte());
            System.out.println("Producto: " + aux.getInfo().getProducto());
            System.out.println("No. de Cliente: " + aux.getInfo().getNoCliente());
            System.out.println("");

           
            while (error == true) {
                try {
                    System.out.println("Presione 1 para modificar o 0 para salir");
                    opcion = Integer.parseInt(BR.readLine());
                    error = false;
                } catch (Exception e) {
                    System.out.println("Fromato invalido");
                    error = true;
                }
            }
           
            while(opcion == 1 && opcion != 0){
                error = true;
            while (error == true) {

                        System.out.println("Que elemento desea modificar");
                        System.out.println("1.- Importe");
                        System.out.println("2.- Producto");
                        System.out.println("3.- Numero de cliente");
                        System.out.println("0. Salir");
                        try {
                            opcion = Integer.parseInt(BR.readLine());
                            error = false;
                        } catch (Exception e) {
                            System.out.println("Formato invalido");
                            error = true;
                        }
            }
                        switch (opcion) {
                            case 0->{
                                
                            }
                            case 1 -> {//cambio del importe
                                //SE NECESITA DE DOUBLE
                                error = true;
                                while (error == true) {
                                    System.out.println("Ingrese el importe");
                                    try {
                                        importe = Double.parseDouble(BR.readLine());
                                        error = false;
                                    } catch (Exception e) {
                                        System.out.println("Formato no valido");
                                        error = false;
                                    }
                                }
                                listaDE.busqueda(noPedido).getInfo().setImporte(importe);
                                opcion = 1;
                            }
                            case 2 -> {//cambio del producto
                                //SE NESECITA DE UN STRING
                                System.out.println("Ingrese el producto");
                                String nombreP = BR.readLine();
                                listaDE.busqueda(noPedido).getInfo().setProducto(nombreP);
                                opcion = 1;
                            }
                            case 3 -> {//cambio del numero de cliente
                                //SE NECESITA DE UN SHORT
                                error = true;
                                while (error == true) {
                                System.out.println("Ingrese el numero de cliente");
                                try{
                                noCliente = Short.parseShort(BR.readLine());
                                error = false;
                                }catch(Exception e){
                                    System.out.println("Formato invalido");
                                    error = true;
                                }
                                }
                                listaDE.busqueda(noPedido).getInfo().setNoCliente(noCliente);
                                opcion = 1;
                            }
                            default -> {
                                System.out.println("Opcion no valida");
                            }

                        }
                    }
           listaDE.calcularImporteTotal();

        } else {
            System.out.println("Elemento no encontrado");
        }

    }

    public void menu(NodoA nodo) throws IOException, MyException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int option = 0, readInt = 0;
        boolean mistake = true;
        ListaDE listaDobleE = nodo.getSucursal().getListaPedidos(); // se inseta la lista en el nodo pasado por parametro
        Pedido pedido = new Pedido();
        NodoDoble nodoD;

        //MENU
        while (option != 5 || mistake == true) {
            
          
            System.out.println("**********************************************************");
            System.out.println("*   Bienvenido al programa de Pedidos                   *");
            System.out.println("* Ingrese una de las siguientes opciones                *");
            System.out.println("* 1. Agregar pedido                                     *");
            System.out.println("* 2. Eliminar pedido                                    *");
            System.out.println("* 3. Desplegar listado de pedidos                       *");
            System.out.println("* 4. Consultar un pedido con opción a cambio de datos   *");
            System.out.println("* 5. Salir                                              *");
            System.out.println("*********************************************************");

            try {
                option = Integer.parseInt(BR.readLine());

                mistake = false;
            } catch (Exception e) {

                System.out.println("Error en la entrada");
                mistake = true;
            }

            switch (option) {
                case 1 -> { // Agregar pedido (en orden numérico ascendente)

                    agregarPedido(listaDobleE, BR);

                }
                case 2 -> {// Eliminar pedido
                    mistake = true;
                    while (mistake == true) {

                        System.out.println("Ingrese el numero de pedido");
                        try {//*GESTIONA LA ENTRADA INCORRECTA
                            readInt = Integer.parseInt(BR.readLine());
                            mistake = false;

                            try {//**GESTIONA EL ELEMENTO NULO DE BUSQUEDA
                                nodoD = listaDobleE.delete(readInt);//Guarda el elemnto eliminado en una variable Nodo

                                if (nodoD == null) {
                                    System.out.println("Elemento no encontrado");
                                } else {
                                    System.out.println("Pedido eliminado: " + nodoD.getInfo().getProducto());
                                }
                            } catch (MyException e) {//**GESTIONA EL ELEMENTO NULO DE BUSQUEDA
                                System.out.println(e.getMessage());
                            }
                        } catch (Exception e) {//*GESTIONA LA ENTRADA INCORRECTA
                            System.out.println("Entrada invalida");
                        }

                    }
                }

                case 3 -> {// Desplegar listado de pedidos
                    
                    try {
                        listaDobleE.despliegue();
                        System.out.println("Importe total");
                        System.out.println(listaDobleE.getImporteTotal());
                        
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                        
                    }
                
                }
                case 4 -> {// Consultar un pedido con opción a cambio de datos
                    mistake = true;
                    while (mistake == true) {
                        System.out.println("Ingrese el numero de pedido:");
                        try {
                            readInt = Integer.parseInt(BR.readLine());
                            mistake = false;

                        } catch (Exception e) {
                            System.out.println("Formato invalido");
                        }

                        try {
                            //listaDobleE.busqueda(option);
                            consultarOmodificar(readInt, listaDobleE, BR);
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                        }

                    }

                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }

        }

        
    }
    
   
}
