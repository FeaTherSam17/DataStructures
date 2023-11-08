/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import packArbol.Arbol;
import packArbol.NodoA;

/**
 *
 * @author Alumno
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Arbol arbol = new Arbol();
        NodoA nodo = null;
        BufferedReader BR = new BufferedReader (new InputStreamReader (System.in));
          int opcion=-1;      
                
          do{
              System.out.println("Ingresa una de las opciones");
              System.out.println("1. Ingresar dato al arbol");
              System.out.println("2. Recorrido Preorden");
              System.out.println("3. Recorrido Postorden");
              System.out.println("4. Recorrido Inorden");
              System.out.println("5. Busqueda por nombre");
              
              opcion=Integer.parseInt(BR.readLine());
              
              switch(opcion){
                  
                  case 1 ->{
                      // j, e, s, c, g, w, f, i, h
                      System.out.println("Clave");
                      String clave = BR.readLine();/*
                      System.out.println("Cantidad");
                      Float cantidad = Float.parseFloat(BR.readLine());
                      System.out.println("Nombre");
                      String nombre = BR.readLine();  */                  
                      
                      nodo= new NodoA(clave.charAt(0),10,"Nodo");
                      arbol.insert(nodo);
                      
                  }
                  
                  case 2 ->{
                      
                      arbol.preorden(arbol.getRaiz());
                      System.out.println("");
                  }
                  case 3 ->{
                    arbol.postorden(arbol.getRaiz());
                    System.out.println();
                  }
                  case 4 ->{
                    arbol.inorden(arbol.getRaiz());
                    System.out.println();
                  }
                  case 5 ->{

                  }
                  
                  
                  
              }
              
              
          }while(opcion!=0);
          
          
    }
   
}
